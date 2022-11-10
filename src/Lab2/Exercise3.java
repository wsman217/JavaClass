package Lab2;

public class Exercise3 {

    static void sum(int... nums) {
        int sum = 0;

        for (int n : nums) {
            sum += n;
        }

        double average = (double) sum / nums.length;

        System.out.printf("Sum: %d Average: %.2f\n", sum, average);
    }

    static void mult(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.printf("%5d", i * j);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        sum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        mult(15);
    }
}
