package DesignMode.Mediator;

/**
 * @author JYH
 * 2018/10/21 9:05
 */
public class USA extends Country {
    public USA(UnitedNations unitedNations) {
        super(unitedNations);
    }

    public void Declare(String message){
        unitedNations.Declare(message,this);
    }

    public void notify(String message){
        System.out.println("美国获得对方消息：" + message);
    }
}
