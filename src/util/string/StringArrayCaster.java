package util.string;

public class StringArrayCaster {
    public static int[] castToToIntArray(String[] textArray) {
        int[] numberArray = new int[textArray.length];

        for (int i = 0; i < textArray.length; i++) {
            String text = textArray[i];

            numberArray[i] = Integer.parseInt(text);
        }

        return numberArray;
    }
}
