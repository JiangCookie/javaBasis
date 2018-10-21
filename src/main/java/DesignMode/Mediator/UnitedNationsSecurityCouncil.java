package DesignMode.Mediator;

/**
 * 联合国安全理事会
 * @author JYH
 * 2018/10/21 9:03
 */
public class UnitedNationsSecurityCouncil extends UnitedNations {

    private USA country1;
    private Iraq country2;

    public USA getCountry1() {
        return country1;
    }

    public void setCountry1(USA country1) {
        this.country1 = country1;
    }

    public Iraq getCountry2() {
        return country2;
    }

    public void setCountry2(Iraq country2) {
        this.country2 = country2;
    }

    @Override
    public void Declare(String message, Country country) {
        if(country == country1) {
            country2.notify(message);
        }else {
            country1.notify(message);
        }
    }
}
