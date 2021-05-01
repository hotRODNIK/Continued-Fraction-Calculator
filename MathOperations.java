public class MathOperations {
    // Function which implements adding of fractions
    public static Fraction add(Fraction one, Fraction two){
        Fraction three = new Fraction();
        long numOne = (one.getNumerator() * two.getDenominator());
        long numTwo = (two.getNumerator() * one.getDenominator());
        long denom = (one.getDenominator() * two.getDenominator());
        three.setNumerator(numOne + numTwo);
        three.setDenominator(denom);
        three.reduce();
        return three;
    }

    // Function which inverts a fraction
    public static Fraction invert(Fraction one){
        Fraction two = new Fraction();
        long tempN = one.getNumerator();
        long tempD = one.getDenominator();
        two.setDenominator(tempN);
        two.setNumerator(tempD);
        two.reduce();
        return two;
    }

    // Function which checks if a fraction is zero
    public static boolean equalZero(Fraction one){
        one.reduce();
        return (one.getNumerator() == 0);
    }
}
