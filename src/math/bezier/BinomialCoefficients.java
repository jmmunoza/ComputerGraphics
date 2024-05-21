package math.bezier;

public class BinomialCoefficients {
    public int n;
    public int k;

    public BinomialCoefficients(int n, int k){
        this.n = n;
        this.k = k;
    }
    public int Factorial(int a){
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial = factorial * i;
        }
        return factorial;
    }
    public double Coefficient(){
        return Factorial(n)/(Factorial(k)*Factorial(n-k));
    }
}