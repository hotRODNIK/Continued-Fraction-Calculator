# Continued-Fraction-Calculator
A simple calculator which computes the simple continued fraction representation of a rational number implemented in Java.
I originally wrote this calculator a year ago, but it had some major bugs. To get around this I implemented a basic Fraction class to overcome the limitations of floating-point arithmetic, which is the foundation of this entire project.
This project also required the implementation of a basic arraylist as well as the basic logic for generating the n-tuple representation of the continued fraction as a string, i.e. the [a<sub>0</sub>; a<sub>1</sub>, a<sub>2</sub>, ... , a<sub>n</sub>] notation for the coefficients. The BigInteger branch contains a more improved implementation of the 
algorithm, as the numerator and denominator are stored as `BigInteger`. This allows for some more interesting computations, as one can compute the values for the coefficients 
of the continued fraction for "very large" rational approximations of irrational numbers, which isn't possible with standard `int` types.
