package work01;

/**
 * 
 * @author Chan Thongjerm 63130500019
 */
public final class Utilitor {

    public static String testString(String value) {
        if (value == null) {
            throw new NullPointerException("Value must not be null.");
        } else if (value.isBlank()) {
            throw new IllegalArgumentException("Value must not be blank.");
        }
        return value;
    }

    public static double testPositive(double value) {
        if (value > 0) {
            return value;
        } else {
            throw new IllegalArgumentException("Value must be positive.");
        }
    }

    public static long computeIsbn10(long isbn10) {
        // Variables to keep track of the calculation
        long checkDigit = 0;
        int multiplier = 2;

        // Iterate through the digits of the ISBN-10 from right to left
        while (isbn10 > 0) {
            long digit = isbn10 % 10; // Get the rightmost digit
            checkDigit += digit * multiplier; // Multiply the digit by the current multiplier and add it to the running total
            multiplier++; // Increment the multiplier for the next digit
            isbn10 /= 10; // Remove the rightmost digit from the ISBN-10
        }

        // Calculate the check digit as the remainder when the total is divided by 11
        checkDigit = (11 - (checkDigit % 11)) % 11;

        return checkDigit;
    }
}
