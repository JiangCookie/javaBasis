package DesignMode.Structural;

/**
 * @author JYH
 * 2018/12/2 20:15
 */
public class Test {
    public static void main(String[] args) {
        PointGift pointGift = new PointGift("半袖");
        GiftExchangeService giftExchangeService = new GiftExchangeService();



        giftExchangeService.giftExchange(pointGift);
    }
}
