public class MathOperations {
    // Function which implements adding of fractions
    public static Fraction Add(Fraction one, Fraction two){
        Fraction three = new Fraction();
        int numOne = (one.getNumerator() * two.getDenominator());
        int numTwo = (two.getNumerator() * one.getDenominator());
        int denom = (one.getDenominator() * two.getDenominator());
        three.setNumerator(numOne + numTwo);
        three.setDenominator(denom);
        three.Reduce();
        return three;
    }

    // Function which inverts a fraction
    public static Fraction Invert(Fraction one){
        Fraction two = new Fraction();
        int tempN = one.getNumerator();
        int tempD = one.getDenominator();
        two.setDenominator(tempN);
        two.setNumerator(tempD);
        two.Reduce();
        return two;
    }

    // Function which checks if a fraction is zero
    public static boolean EqualZero(Fraction one){
        one.Reduce();
        return (one.getNumerator() == 0);
    }
}