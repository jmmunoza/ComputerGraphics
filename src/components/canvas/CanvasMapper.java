package components.canvas;

public class CanvasMapper {
    public static double mapXjToXp(double xj, double width) {
        return xj - (width / 2);
    }

    public static double mapYjToYp(double yj, double height) {
        return (height / 2) - yj;
    }

    public static double mapYpToYj(double yp, double height) {
        return (height / 2) - yp;
    }

    public static double mapXpToXj(double xp, double width) {
        return xp + (width / 2);
    }
}
