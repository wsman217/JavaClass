package Lab4;

import java.util.Scanner;

public class Exercise1 {

    public static int getTotal() {
        Scanner s = new Scanner(System.in);
        System.out.print("How many numbers would you like to generate: ");
        return s.nextInt();
    }

    public static int[] getRandoms(int n) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = (int) (Math.random() * (999 - 100) + 100);
        }

        return nums;
    }

    public static int reverse(int num) {
        StringBuilder build = new StringBuilder("" + num);
        return Integer.parseInt(build.reverse().toString());
    }

    public static boolean palindrome(int num) {
        return num == reverse(num);
    }
    public static void main(String[] args) {
        int[] nums = getRandoms(getTotal());

        for (int num : nums) {
            System.out.println(num + " is " + (palindrome(num) ? "a palindrome." : "not a palindrome."));
        }
    }
}
