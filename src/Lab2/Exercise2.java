package Lab2;

import java.util.Scanner;

public class Exercise2 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter 3 numbers: ");

        int num2 = s.nextInt(), num3 = s.nextInt();

        int greatest = s.nextInt();

        if (num2 > greatest)
            greatest = num2;
        else if (num3 > greatest)
            greatest = num3;

        System.out.println("Greatest: " + greatest);
    }
}
