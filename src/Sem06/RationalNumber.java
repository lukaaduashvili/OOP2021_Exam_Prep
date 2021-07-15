package Sem06;

public class RationalNumber {
    private int num;
    private int denum;

    public RationalNumber(int num, int denum) {
        this.num = num;
        this.denum = denum;
    }

    public RationalNumber(int num) {

    }

    public RationalNumber(RationalNumber number) {
        num = number.num;
        denum = number.denum;
    }

    public RationalNumber add(RationalNumber a) {
        return null;
    }

    public RationalNumber multiply(RationalNumber a) {
        return null;
    }

    @Override
    public int hashCode() {
        return Integer.valueOf(num).hashCode() & Integer.valueOf(denum).hashCode();
    }
}
