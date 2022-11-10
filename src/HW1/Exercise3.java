package HW1;

public class Exercise3 {

    public static void main(String[] args) {
        int a = 2147483647;
        byte b = 127;

        System.out.println(0B10111); // Binary
        System.out.println(0345); // Octal
        System.out.println(0xABCD); // Hex
        System.out.println(1 / 3); // Int division
        System.out.println(1 / 3.0); // Double division
        System.out.println(1.0 / 3); // Double Division
        System.out.println(1.0f / 3.0F); // Float division
        System.out.println(123.123E-2); // Scientific notation
        System.out.println(a); // Not sure what you want me to say here it's a variable.
        System.out.println(b); // Same as above except it's a byte.
        b = (byte) (b + 1); // Byte overflow.
        System.out.println(b); // ^
        a = (int) (a + 1); // Integer overflow
        System.out.println(a); // ^
        b = (byte) ((-b) + 127); // Causes an overflow and goes to -1.
        System.out.println(b); // ^
        a = (int) ((-a) + 2147483647); // Same as last one.
        System.out.println(a); // ^
        a = 2147483647;
        b = 127;
        b = (byte) (b + 1270); // Overflow
        System.out.println(b); // ^
        a = (int) (a + 2147483647); // Overflow
        System.out.println(a); // ^
    }
}
