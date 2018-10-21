package DesignMode.Mediator;

/**
 * @author JYH
 * 2018/10/21 9:08
 */
public class Iraq extends Country {
    public Iraq(UnitedNations unitedNations) {
        super(unitedNations);
    }

    public void Declare(String message){
        unitedNations.Declare(message,this);
    }

    public void notify(String message){
        System.out.println("伊拉克获得对方消息：" + message);
    }

}
