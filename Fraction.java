import java.math.BigInteger;

public class Fraction {
    private BigInteger numerator;
    private BigInteger denominator;

    public Fraction(){
        this.numerator = null;
        this.denominator = null;
    }

    public void setNumerator(BigInteger b) {
        this.numerator = b;
    }

    public void setDenominator(BigInteger b) {
        if (!b.equals(new BigInteger("0"))) {
            this.denominator = b;
        }
    }

    public BigInteger getNumerator() {
        return numerator;
    }

    public BigInteger getDenominator() {
        return denominator;
    }

    @Override
    public String toString(){
        return numerator + "/" + denominator;
    }

    public String toIntegerDivisionString(){
        return this.numerator.divide(this.denominator).toString();
    }

    public double toDecimal(){
        return this.numerator.doubleValue() / this.denominator.doubleValue();
    }
}
