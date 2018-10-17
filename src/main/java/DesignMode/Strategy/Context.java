package DesignMode.Strategy;

/**
 * @author JYH
 * 2018/9/25 11:33
 */
public class Context {
    Strategy strategy;

    /**
     * 初始化时，传入具体的策略对象
     * @param strategy
     */
    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    /**
     * 上下文接口
     * 根据具体的策略对象，调用其算法的方法
     */
    public void ContextInterface(){
        strategy.AlgorithmInterface();
    }
}
