package DesignMode.Mediator;

/**
 * 抽象同事类
 * 国家类相当于Colleague类
 * @author JYH
 * 2018/10/21 8:58
 */
public abstract class Country {
    protected UnitedNations unitedNations;

    public Country(UnitedNations unitedNations) {
        this.unitedNations = unitedNations;
    }
}
