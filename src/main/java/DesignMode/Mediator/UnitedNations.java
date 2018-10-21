package DesignMode.Mediator;

/**
 * 抽象中介者
 * 联合国机构类 相当于Meditor类
 * @author JYH
 * 2018/10/21 8:56
 */
public abstract class UnitedNations {

    /**
     * 声明
     * @param message
     * @param country
     */
    public abstract void Declare(String message, Country country);
}
