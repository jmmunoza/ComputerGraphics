package util.numeric;

public class IntegerArrayCaster {
    public static double[] castToDoubleArray(int[] intArray) {
        double[] doubles = new double[intArray.length];

        for (int i = 0; i < intArray.length; i++) {
            doubles[i] = intArray[i];
        }

        return doubles;
    }
}
