import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String [] args) {
        // Initialize variables
        Fraction r;
        Fraction i = new Fraction();
        Fraction out, f;
        ArrayList seq = new ArrayList();

        try (Scanner s = new Scanner(System.in)) {
            // Read in input from the user
            System.out.println("Welcome to the Continued Fraction Calculator for Rational Numbers\n" +
                    "Please enter a Decimal Representation => ");
            r = parseFraction(s.next());
            out = r;

            // Calculate the continued fraction representation
            while (!MathOperations.equalZero(r)){
                i.setNumerator(-((long) Math.floor(r.toDecimal())));
                i.setDenominator(1);
                f = MathOperations.add(r, i);
                seq.append(-(i.getNumerator()));
                if (f.getNumerator() != 0){
                    r = MathOperations.invert(f);
                }
                else{
                    r = f;
                }
            }

            // Output the results
            System.out.println("The Continued Fraction Representation of " + out + ", in decimal notation, " +
                    out.toDecimal() + " is " + seq + ".");
        } catch (InputMismatchException e) {
            System.out.println("Invalid Input - Make Sure Your Input Strings are Formatted Correctly!!!");
        } catch (Exception e) {
            // Should never go into this block
            System.out.println("Fatal Error");
        }
    }

    // It's not perfect, but it won't allow any characters not from 0-9, - or .
    // Determines sign by counting number of minus signs which means it
    // interprets something like 4-------5 as -45
    // 4-----w5 would be discarded, so it has a bit of flexibility for odd inputs
    public static Fraction parseFraction(String input){
        int length = input.length();
        int decCount = 0;
        long num = 0, denom;
        boolean sign = false;
        char[] temp = new char[length];
        Fraction f = new Fraction();

        // Check for valid input
        for (int i = 0; i < length; i++){
            switch (input.charAt(i)) {
                case '0': case '1': case '2': case '3':
                case '4': case '5': case '6': case '7':
                case '8': case '9': case '.': case '-':
                    break;
                default:
                    System.out.println("Invalid Input String");
                    throw new InputMismatchException();
            }
        }

        for (int i = 0; i < length; i++){
            if (input.charAt(i) == '-')
                sign = !sign;
            else if (input.charAt(i)  >= '0' && input.charAt(i) <= '9')
                temp[i] = input.charAt(i);
            else if (input.charAt(i) == '.'){
                if (decCount < 1) {
                    temp[i] = input.charAt(i);
                    decCount++;
                }
                else{
                    System.out.println("Invalid Input String");
                    throw new InputMismatchException();
                }
            }
        }

        // Construct a fraction from the input
        decCount = 0;

        for (int i = 0; i < length; i++){
            if (temp[i] >= '0' && temp[i] <= '9'){
                num = (num * 10L) + getInt(temp[i]);
                if (decCount >= 1){
                    decCount++;
                }
            }
            else if (temp[i] == '.')
                decCount++;
        }
        decCount -= 1;

        if (sign)
            num = -num;

        if (decCount == 0)
            denom = 1;
        else{
            denom = power(10, decCount);
        }

        f.setNumerator(num);
        f.setDenominator(denom);

        return f;
    }

    public static int getInt(char in){
        if (in == '0')
            return 0;
        else if (in == '1')
            return 1;
        else if (in == '2')
            return 2;
        else if (in == '3')
            return 3;
        else if (in == '4')
            return 4;
        else if (in == '5')
            return 5;
        else if (in == '6')
            return 6;
        else if (in == '7')
            return 7;
        else if (in == '8')
            return 8;
        else if (in == '9')
            return 9;
        else
            return -1;
    }

    public static long power(long x, long y){
        long result = 1;

        for (int i = 1; i <= y; i++)
            result = result * x;

        return result;
    }
}
