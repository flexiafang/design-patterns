package decorator.starbucks;

/**
 * 奶泡装饰者
 *
 * @Author hustffx
 * @Date 2020/4/22 16:44
 */
public class Whip extends CondimentDecorator {
    /**
     * 用一个饮料类实例变量记录饮料，也就是被装饰着
     */
    Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    /**
     * 不只是描述饮料，而是完整地连调料都描述出来
     */
    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }

    /**
     * 调料价格加上饮料价格
     */
    @Override
    public double cost() {
        return 0.10 + beverage.cost();
    }
}
