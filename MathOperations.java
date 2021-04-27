public class MathOperations {
    // Function which implements adding of fractions
    public static Fraction add(Fraction one, Fraction two){
        Fraction three = new Fraction();
        int numOne = (one.getNumerator() * two.getDenominator());
        int numTwo = (two.getNumerator() * one.getDenominator());
        int denom = (one.getDenominator() * two.getDenominator());
        three.setNumerator(numOne + numTwo);
        three.setDenominator(denom);
        three.reduce();
        return three;
    }

    // Function which inverts a fraction
    public static Fraction invert(Fraction one){
        Fraction two = new Fraction();
        int tempN = one.getNumerator();
        int tempD = one.getDenominator();
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