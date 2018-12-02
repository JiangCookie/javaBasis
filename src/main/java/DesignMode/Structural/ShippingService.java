package DesignMode.Structural;

/**
 * @author JYH
 * 2018/12/2 20:01
 */
public class ShippingService {
    public String shipGift(PointGift pointGift){
        System.out.println(pointGift.getName() + "进入物流系统");
        String shippingOrderNo = "666";
        return shippingOrderNo;
    }
}
