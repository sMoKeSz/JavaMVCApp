package ro.z2h;

import org.codehaus.jackson.map.ObjectMapper;
import ro.z2h.annotation.MyController;
import ro.z2h.annotation.MyRequestMethod;
import ro.z2h.controller.DepartmentController;
import ro.z2h.controller.EmployeeController;
import ro.z2h.domain.Department;
import ro.z2h.fmk.AnnotationScanUtils;
import ro.z2h.fmk.MethodAttributes;
import ro.z2h.fmk.methAttributes;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 11/11/2014.
 */
public class DispatcherServlet extends HttpServlet{
    Map<String,MethodAttributes> annotationMap = new HashMap<String, MethodAttributes>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//      Delegate to someone. (app controler)
        dispatchReply(req,resp,"GET");
    }
    
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//      Delegate to someone. (app controler)
        dispatchReply(req,resp,"POST");
    }

    private void dispatchReply(HttpServletRequest req, HttpServletResponse resp, String httpMethod) {
//      Delegate to some app controller and return an answer.
        Object r =  dispatch(req,resp);
//      Return the answer for client.
        try {
            reply(req,resp,r);
        } catch (IOException e) {
            sentExcept(req, resp, e);
        }

    }

    private void sentExcept(HttpServletRequest req, HttpServletResponse resp, Exception ex) {
        // tratare exceptie;
    }

    private void reply(HttpServletRequest req, HttpServletResponse resp, Object r) throws IOException {

        PrintWriter out = resp.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValueAsString(r);
        out.printf(mapper.writeValueAsString(r));
    }

    //  Unde ar trb ar trebui apelat un app controller + primire raspuns.
    private Object dispatch(HttpServletRequest req, HttpServletResponse resp) {
        String pathInfo = req.getPathInfo();
        MethodAttributes methodAttributes = annotationMap.get(pathInfo);


        try {
            if(methodAttributes!=null) {
                Class<?> appControllerClass = Class.forName(methodAttributes.getControllerClass());
                Object appControllerInstance = appControllerClass.newInstance();
                Method controllerMethod = appControllerClass.getMethod(methodAttributes.getMethodName());
                return controllerMethod.invoke(appControllerInstance);

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }



        return "Hello";
    }

    @Override
    public void init() throws ServletException {

        try {
         Iterable<Class> classes =   AnnotationScanUtils.getClasses("ro.z2h.controller");

            for (Class aClass : classes) {

                if(aClass.isAnnotationPresent(MyController.class)){
                    MyController annotation = (MyController)aClass.getAnnotation(MyController.class);

                 Method[] methods = aClass.getMethods();
                    for (Method method : methods) {
                        if(method.isAnnotationPresent(MyRequestMethod.class)) {
                            MyRequestMethod meth = (MyRequestMethod)method.getAnnotation(MyRequestMethod.class);

                            MethodAttributes obj = new MethodAttributes();
                            obj.setControllerClass(aClass.getName());
                            obj.setMethodType(meth.methodType());
                            obj.setMethodName(method.getName());
                            annotationMap.put(annotation.urlPath() + meth.urlPath(), obj);
                        }
                    }
                }
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

}




