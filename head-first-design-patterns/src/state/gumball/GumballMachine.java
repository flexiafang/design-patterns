package state.gumball;

/**
 * @Author hustffx
 * @Date 2020/5/8 15:40
 */
public class GumballMachine {
    /**
     * 4种状态：售罄、没钱、有钱、售出
     */
    private static final int SOLD_OUT = 0;
    private static final int NO_QUARTER = 1;
    private static final int HAS_QUARTER = 2;
    private static final int SOLD = 3;

    /**
     * 当前状态
     */
    private int state;
    private int count;

    public GumballMachine(int count) {
        this.count = count;
        state = count > 0 ? NO_QUARTER : SOLD_OUT;
    }

    public void insertQuarter() {
        switch (state) {
            case HAS_QUARTER:
                System.out.println("You can't insert another quarter");
                break;

            case NO_QUARTER:
                state = HAS_QUARTER;
                System.out.println("You inserted a quarter");
                break;

            case SOLD_OUT:
                System.out.println("You can't insert a quarter, the machine is sold out");
                break;

            case SOLD:
                System.out.println("Please wait, we're already giving you a gumball");
                break;

            default:
        }
    }

    public void ejectQuarter() {
        switch (state) {
            case HAS_QUARTER:
                System.out.println("Quarter returned");
                state = NO_QUARTER;
                break;

            case NO_QUARTER:
                System.out.println("You haven't inserted a quarter");
                break;

            case SOLD:
                System.out.println("Sorry, you already turned the crank");
                break;

            case SOLD_OUT:
                System.out.println("You can't eject, you haven't inserted a quarter yet");
                break;

            default:
        }
    }

    public void turnCrank() {
        switch (state) {
            case SOLD:
                System.out.println("Turning twice doesn't get you another gumball!");
                break;

            case NO_QUARTER:
                System.out.println("You turned but there's no quarter");
                break;

            case SOLD_OUT:
                System.out.println("You turned, but there are no gumballs");
                break;

            case HAS_QUARTER:
                System.out.println("You turned...");
                state = SOLD;
                dispense();
                break;

            default:
        }
    }

    private void dispense() {
        switch (state) {
            case SOLD:
                System.out.println("A gumball comes rolling out the slot");
                count--;
                if (count == 0) {
                    System.out.println("Oops, out of gumballs!");
                    state = SOLD_OUT;
                } else {
                    state = NO_QUARTER;
                }
                break;

            case NO_QUARTER:
                System.out.println("You need to pay first");
                break;

            case SOLD_OUT:
            case HAS_QUARTER:
                System.out.println("No gumball dispensed");
                break;

            default:
        }
    }

    public void refill(int numGumBalls) {
        this.count = numGumBalls;
        state = NO_QUARTER;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("\nMighty Gumball, Inc.");
        result.append("\nJava-enabled Standing Gumball Model #2020\n");
        result.append("Inventory: ").append(count).append(" gumball");
        if (count > 1) {
            result.append("s");
        }

        result.append("\nMachine is ");

        switch (state) {
            case SOLD_OUT:
                result.append("sold out");
                break;

            case NO_QUARTER:
                result.append("waiting for quarter");
                break;

            case HAS_QUARTER:
                result.append("waiting for turn of crank");
                break;

            case SOLD:
                result.append("delivering a gumball");
                break;

            default:
        }

        result.append("\n");
        return result.toString();
    }
}
