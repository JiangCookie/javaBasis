package DesignMode.Builder;

/**
 * @author JYH
 * 2018/9/24 10:37
 */
public class ConcreteBuilder  implements Builder{


    private Product resultProduct;

    /**
     * 获取生成器最终构建的产品对象
     * @return
     */
    public Product getResultProduct(){
        return resultProduct;
    }


    public void buildPart() {
        //构建某个部件的功能处理
    }


}
