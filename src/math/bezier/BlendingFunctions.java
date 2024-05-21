package math.bezier;

import java.lang.Math;

public class BlendingFunctions {
    public int n;
    public int k;
    public double u;

    public BlendingFunctions(int k, int n, double u){
        this.n = n;
        this.k = k;
        this.u = u;
    }
    
    public double BEZ(){
        double C = new BinomialCoefficients(n, k).Coefficient();
        return C * Math.pow(u, k) * Math.pow((1 - u),(n - k));
    }
}
