package DesignMode.Structural;

/**
 * @author JYH
 * 2018/12/2 20:00
 */
public class PointsPaymentService {
    public boolean pay(PointGift pointGift){
//        扣减积分
        System.out.println("支付" + pointGift.getName() + "积分成功");
        return true;
    }
}
