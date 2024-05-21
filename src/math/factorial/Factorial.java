package math.factorial;

public class Factorial {
    public static int find(int n) {
        int f = 1;

        for (int i = 1; i <= n; i++) {
            f *= i;
        }

        return f;
    }
}
