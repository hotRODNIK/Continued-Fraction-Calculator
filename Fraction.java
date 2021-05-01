public class Fraction {
    private long numerator;
    private long denominator;

    public Fraction(){
        this.numerator = 1;
        this.denominator = 1;
    }

    public void setNumerator(long numerator) {
        this.numerator = numerator;
        reduce();
    }

    public void setDenominator(long denominator) {
        if (denominator != 0) {
            this.denominator = denominator;
            reduce();
        }
    }

    public long getNumerator() {
        return numerator;
    }

    public long getDenominator() {
        return denominator;
    }

    public void reduce(){
        long gcd = getGcd(this.numerator, this.denominator);
        this.numerator = this.numerator / gcd;
        this.denominator = this.denominator / gcd;
    }

    private static long getGcd(long num, long denom){
        if (denom == 0){
            return num;
        }
        else{
            return getGcd(denom, num % denom);
        }
    }

    @Override
    public String toString(){
        return numerator + "/" + denominator;
    }

    public double toDecimal(){
        return (double) this.numerator / (double) this.denominator;
    }
}
