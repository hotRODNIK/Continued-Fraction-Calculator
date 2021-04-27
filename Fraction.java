public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(){
        this.numerator = 1;
        this.denominator = 1;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
        Reduce();
    }

    public void setDenominator(int denominator) {
        if (denominator != 0) {
            this.denominator = denominator;
            Reduce();
        }
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void Reduce(){
        int gcd = getGcd(this.numerator, this.denominator);
        this.numerator = this.numerator / gcd;
        this.denominator = this.denominator / gcd;
    }

    private static int getGcd(int num, int denom){
        if (denom == 0){
            return num;
        }
        else{
            return getGcd(denom, num%denom);
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