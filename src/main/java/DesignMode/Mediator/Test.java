package DesignMode.Mediator;

/**
 * @author JYH
 * 2018/10/21 9:09
 */
public class Test {
    public static void main(String[] args) {
        /**
         * 定义具体中介者
         */
        UnitedNationsSecurityCouncil m = new UnitedNationsSecurityCouncil();

        /**
         * 让两个具体同事类认识中介者对象
         */
        USA c1 = new USA(m);
        Iraq c2 = new Iraq(m);

        m.setCountry1(c1);
        m.setCountry2(c2);

        c1.Declare("不准研制核武器");
        c2.Declare("我们没有核武器，也不怕侵略");
    }
}
