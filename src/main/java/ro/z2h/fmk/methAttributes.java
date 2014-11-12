package ro.z2h.fmk;

/**
 * Created by user on 11/11/2014.
 */
public class methAttributes {

    String controllerName;
    String methodName;
    String methodType;

    public String getControllerName() {
        return controllerName;
    }

    public void setControllerName(String controllerName) {
        this.controllerName = controllerName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getMethodType() {
        return methodType;
    }

    public void setMethodType(String methodType) {
        this.methodType = methodType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        methAttributes that = (methAttributes) o;

        if (controllerName != null ? !controllerName.equals(that.controllerName) : that.controllerName != null)
            return false;
        if (methodName != null ? !methodName.equals(that.methodName) : that.methodName != null) return false;
        if (methodType != null ? !methodType.equals(that.methodType) : that.methodType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = controllerName.hashCode();
        result = 31 * result + methodName.hashCode();
        result = 31 * result + methodType.hashCode();
        return result;
    }
}
