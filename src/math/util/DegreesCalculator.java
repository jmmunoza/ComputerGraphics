package math.util;

public class DegreesCalculator {
    public static double changeAngle(double radians, double changeRadians, double minRadians, double maxRadians) {
        double radiansChanged = radians + changeRadians;

        if (radiansChanged > maxRadians)
            return minRadians + (radiansChanged - maxRadians);
        else if (radiansChanged < minRadians)
            return maxRadians - (minRadians - radiansChanged);
        else
            return radiansChanged;
    }

    public static double changeAngle(double angle, double changeDegrees) {
        return changeAngle(angle, changeDegrees, 0, 360);
    }
}
