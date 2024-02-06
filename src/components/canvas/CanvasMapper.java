package components.canvas;

public class CanvasMapper {
    public static int mapXjToXp(int xj, int width) {
        return xj - (width / 2);
    }

    public static int mapYjToYp(int yj, int height) {
        return (height / 2) - yj;
    }

    public static int mapYpToYj(int yp, int height) {
        return (height / 2) - yp;
    }

    public static int mapXpToXj(int xp, int width) {
        return xp + (width / 2);
    }
}
