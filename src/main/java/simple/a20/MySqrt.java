package simple.a20;

/**
 * 求平方根
 */
public class MySqrt {
    public int mySqrt(int x) {
        Double d = Double.valueOf(x);
        Double pow = Math.pow(d, 0.5);
        return Math.toIntExact(pow.intValue());
    }
}
