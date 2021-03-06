package factory.pizzafm;

/**
 * @Author hustffx
 * @Date 2020/4/24 18:07
 */
public class PizzaTestDrive {
    public static void main(String[] args) {
        PizzaStore nyPizzaStore = new NYPizzaStore();
        PizzaStore chicagoPizzaStore = new ChicagoPizzaStore();

        Pizza pizza = nyPizzaStore.orderPizza("cheese");
        System.out.println("Flexia ordered a " + pizza.getName() + "\n");
        System.out.println(pizza);

        pizza = chicagoPizzaStore.orderPizza("clam");
        System.out.println("Hustffx ordered a " + pizza.getName() + "\n");
        System.out.println(pizza);
    }
}
