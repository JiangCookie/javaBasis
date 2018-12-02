package DesignMode.Structural;

/**
 * @author JYH
 * 2018/12/2 19:58
 */
public class QualifyService {
    public boolean isAvailable(PointGift pointGift){
        System.out.println("校验" + pointGift.getName() + "积分资格通过，库存通过");
        return true;
    }
}
