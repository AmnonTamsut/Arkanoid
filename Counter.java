

/**
 * Counter - a counter.
 */
public class Counter {
    private int counter = 0;

    /**
     * increase.
     * <p>
     * increases the counter.
     *
     * @param number - a given number
     */
    public void increase(int number) {
        this.counter += number;
    }


    /**
     * decrease.
     * <p>
     * decreases the counter.
     *
     * @param number - a given number
     */
    public void decrease(int number) {
        this.counter -= number;
    }

    /**
     * getValue.
     * <p>
     *
     * @return counter the value of the counter
     */
    public int getValue() {
        return counter;
    }
}