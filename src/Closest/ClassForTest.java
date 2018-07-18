package Closest;

public class ClassForTest extends Number implements CalcDistance<Number>, Comparable<Number>
{


    Integer val;
    public ClassForTest(int value) {
        this.val = value;
    }

    @Override
    public int calcDistance(Number obj1) {

        return Math.abs(val - obj1.intValue());
    }

    @Override
    public int compareTo(Number o) {

        return val.compareTo(o.intValue());
    }


    @Override
    public int intValue() {
        return val;
    }

    @Override
    public long longValue() {
        return 0;
    }

    @Override
    public float floatValue() {
        return 0;
    }

    @Override
    public double doubleValue() {
        return 0;
    }

    @Override
    public String toString() {
        return  val + "";
    }
}