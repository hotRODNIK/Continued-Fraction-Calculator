import java.math.BigInteger;
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String [] args) {
        // Initialize variables
        Fraction r = new Fraction();
        Fraction i = new Fraction();
        Fraction out, f;
        ArrayList seq = new ArrayList();

        try (Scanner s = new Scanner(System.in)) {
            // Read in input from the user
            System.out.println("Welcome to the Continued Fraction Calculator for Rational Numbers\n" +
                    "Please enter a Numerator => ");
            r.setNumerator(new BigInteger(s.next()));
            System.out.println("Please enter a Denominator => ");
            r.setDenominator(new BigInteger(s.next()));
            out = r;

            // Calculate the continued fraction representation
            while (!MathOperations.equalZero(r)){
                i.setNumerator(new BigInteger(r.toIntegerDivisionString()).negate());
                i.setDenominator(new BigInteger("1"));
                f = MathOperations.add(r, i);
                seq.append(i.getNumerator().negate());
                if (!f.getNumerator().equals(new BigInteger("0"))){
                    r = MathOperations.invert(f);
                }
                else{
                    r = f;
                }
            }

            // Output the results
            System.out.println("The Continued Fraction Representation of " + out.toString() + ", in decimal notation, " +
                    out.toDecimal() + " is " + seq.toString() + ".");
            System.out.println(seq.dumpContents());
        } catch (NumberFormatException e) {
            System.out.println("Invalid Input - Make Sure Your Input Strings are Formatted Correctly!!!");
        } catch (Exception e) {
            // Should never go into this block
            System.out.println("Fatal Error");
        }
    }
}
