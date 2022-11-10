package Lab2;

import java.util.Scanner;

public class Exercise1 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter the radius of a circle: ");

        int r = s.nextInt();

        double area = 3.1415 * r * r;

        System.out.printf("Area = %.2f", area);
    }
}
