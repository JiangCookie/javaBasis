package DesignMode.Singleton;

/**
 * @author JYH
 * 2018/11/22 13:52
 */
public enum  EnumInstance {
    INSTANCE;
    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static EnumInstance getInstance(){
        return INSTANCE;
    }
}
