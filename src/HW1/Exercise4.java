package HW1;

import java.util.Random;
import java.util.Scanner;

public class Exercise4 {

    private static final int PRICE_MON = 100;
    private static final int PRICE_KEYBOARD = 50;
    private static final int PRICE_MOUSE = 35;
    private static final int PRICE_CPU = 500;
    private static final int PRICE_RAM = 400;
    private static final int PRICE_SSD = 200;
    private static final double SALES_TAX = .072;

    public static void linEq(int a, int b, int c,
                             int d, int e, int f) {
        int x = e * d - b * f / a * d - b * c;
        int y = a * f - e * c / a * d - b * c;

        System.out.println("X: " + x + " Y: " + y);
    }

    public static void shop(int mon, int key, int mouse,
                            int cpu, int ram, int ssd) {
        System.out.printf("%-10s\t%2d\t$%8d\n", "Monitor",
                mon, mon * PRICE_MON);
        System.out.printf("%-10s\t%2d\t$%8d\n", "Keyboard",
                key, key * PRICE_KEYBOARD);
        System.out.printf("%-10s\t%2d\t$%8d\n", "Mouse",
                mouse, mouse * PRICE_MOUSE);
        System.out.printf("%-10s\t%2d\t$%8d\n", "CPU",
                cpu, cpu * PRICE_CPU);
        System.out.printf("%-10s\t%2d\t$%8d\n", "RAM",
                ram, ram * PRICE_RAM);
        System.out.printf("%-10s\t%2d\t$%8d\n", "SSD",
                ssd, ssd * PRICE_SSD);
        int sub = mon * PRICE_KEYBOARD +
                key * PRICE_KEYBOARD +
                mouse * PRICE_MOUSE +
                cpu * PRICE_CPU +
                ram * PRICE_RAM +
                ssd * PRICE_SSD;
        System.out.printf("%-16s$%8d\n", "Subtotal:", sub);

        System.out.printf("%-16s$%8.2f\n", "Tax:", sub *
                SALES_TAX);
        System.out.printf("%-16s$%8.2f\n", "Total:", sub *
                (SALES_TAX + 1));
    }

    public static void drive() {
        int sum = 0;

        while (sum <= 1000) {
            int rand = new Random().nextInt(99 - 10) + 10;

            System.out.println(rand == 60 ? "LEFT TURN" :
                    rand == 50 ? "RIGHT TURN" : "STRAIGHT");
            sum += rand;
        }
    }

    public static void roots(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.printf("%d: Sqrt %4.2f: Cbrt: %4.2f\n",
                    i, Math.sqrt(i), Math.cbrt(i));
        }
    }

    public static int[] getInputs(String... queries) {
        Scanner scan = new Scanner(System.in);
        int index = 0;

        int[] outputs = new int[queries.length];
        for (String query : queries) {
            System.out.print("Enter parameter " + query);
            outputs[index] = scan.nextInt();
            index++;
        }

        return outputs;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int input = 0;

        while (input != 5) {
            // Java 15 feature IDK which
            // java version you want us to use.
            // Text block the same thing as
            // "This is a\n" + "text block also"
            System.out.print(
                    """
                            Option 1: Linear Equations.
                            Option 2: Shopping.
                            Option 3: Directions.
                            Option 4: Roots.
                            Option 5: Quit.
                            Enter an option:\040""");
            input = scan.nextInt();
            System.out.println();
            int[] outputs;
            switch (input) {
                case 1:
                    outputs = getInputs("A: ", "B: ", "C: "
                            , "D: ", "E: ", "F: ");
                    linEq(outputs[0], outputs[1], outputs[2],
                            outputs[3], outputs[4], outputs[5]);
                    break;
                case 2:
                    outputs = getInputs("Monitors: ",
                            "Keyboards: ", "Mice: ", "CPU: ",
                            "RAM: ", "SSD: ");
                    shop(outputs[0], outputs[1], outputs[2],
                            outputs[3], outputs[4], outputs[5]);
                    break;
                case 3:
                    drive();
                    break;
                case 4:
                    outputs = getInputs("Enter n: ");
                    roots(outputs[0]);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Incorrect option " +
                            "please enter another.");
            }
        }
        System.out.println("Thank you! Exiting.");
    }
}
