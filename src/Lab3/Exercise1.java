package Lab3;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Exercise1 {

    private static final List<String> SEPARATE_CASES = Arrays.asList(
            "+=", "-=", "*=", "/=", "i++", "i--", "++i", "--i");
    private static int first, second;
    private static double output = 0;
    private static String uInput;

    public static void addition() {
        output = first + second;
    }

    public static void subtraction() {
        output = first - second;
    }

    public static void multiplication() {
        output = first * second;
    }

    public static void division() {
        validDen();
        output = first * second;
    }

    public static void modulo() {
        validDen();
        output = first % second;
    }

    public static void plusEquals() {
        output += first;
    }

    public static void minusEquals() {
        output -= first;
    }

    public static void timesEquals() {
        output *= first;
    }

    public static void divEquals() {
        validDen();
        output /= first;
    }

    public static void postInc() {
        output++;
    }

    public static void postDec() {
        output--;
    }

    public static void preInc() {
        ++output;
    }

    public static void preDec() {
        --output;
    }

    public static void validDen() {
        if (second == 0) {
            second = first;
            first = 0;
        }
    }

    public static void displayMenu() {
        System.out.println("""
                Addition: +
                Subtraction: -
                Multiplication: *
                Division: /
                Modulo: %
                PlusEquals: +=
                MinusEquals: -=
                TimesEquals: *=
                DivEquals: /=
                PostInc: i++
                PostDec: i--
                PreInc: ++i
                PostDec: --i
                Quit: q""");
    }

    public static boolean getInput() {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter operator: ");
        uInput = s.nextLine();

        System.out.print("Enter First Number: ");
        first = s.nextInt();
        System.out.print("Enter Second Number: ");
        second = s.nextInt();

        return validate();
    }

    public static boolean validate() {

        switch (uInput) {
            case "+" -> addition();
            case "-" -> subtraction();
            case "*" -> multiplication();
            case "/" -> division();
            case "%" -> modulo();
            case "+=" -> plusEquals();
            case "-=" -> minusEquals();
            case "*=" -> timesEquals();
            case "/=" -> divEquals();
            case "i++" -> postInc();
            case "i--" -> postDec();
            case "++i" -> preInc();
            case "--i" -> preDec();
            case "q" -> System.exit(0);
            default -> {
                System.out.println("Incorrect input.");
                return false;
            }
        }
        return true;
    }

    public static void print() {
        if (SEPARATE_CASES.contains(uInput)) {
            System.out.println("Result of " + uInput +
                    " " + first + " = " + output);
            return;
        }

        System.out.println("Result of " + first + " "
                + uInput + " " + second + " = " + output);
    }

    public static void main(String[] args) {
        while (true) {
            displayMenu();

            if (!getInput())
                continue;
            print();
        }
    }
}
