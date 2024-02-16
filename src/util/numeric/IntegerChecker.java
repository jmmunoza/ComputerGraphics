package util.numeric;

public class IntegerChecker {
    public static boolean isStringAnInteger(String text) {
        try {
            Integer.parseInt(text);
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }

        return true;
    }
}
