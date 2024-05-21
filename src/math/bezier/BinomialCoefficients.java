package math.bezier;

import math.factorial.Factorial;

public class BinomialCoefficients {
    public static double find(int n, int k) {
        return (double) Factorial.find(n) / (Factorial.find(k) * Factorial.find(n - k));
    }
}