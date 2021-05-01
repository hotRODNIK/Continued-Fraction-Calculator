import java.math.BigInteger;

public class MathOperations {
    // Function which implements adding of fractions
    public static Fraction add(Fraction one, Fraction two){
        Fraction three = new Fraction();
        BigInteger numOne = (one.getNumerator().multiply(two.getDenominator()));
        BigInteger numTwo = (two.getNumerator().multiply(one.getDenominator()));
        BigInteger denom = (one.getDenominator().multiply(two.getDenominator()));
        three.setNumerator(numOne.add(numTwo));
        three.setDenominator(denom);
        return three;
    }

    // Function which inverts a fraction
    public static Fraction invert(Fraction one){
        Fraction two = new Fraction();
        BigInteger tempN = one.getNumerator();
        BigInteger tempD = one.getDenominator();
        two.setDenominator(tempN);
        two.setNumerator(tempD);
        return two;
    }

    // Function which checks if a fraction is zero
    public static boolean equalZero(Fraction one){
        return (one.getNumerator().equals(new BigInteger("0")));
    }
}
