package week1.components.canvas;

public class CanvasMapper {
    public static int mapXjToXp(int xj, int width) {
        return xj;
    }

    public static int mapYjToYp(int yj, int height) {
        return height - 1 - yj;
    }

    public static int mapYpToYj(int yp, int height) {
        return height - 2 - yp;
    }

    public static int mapXpToXj(int xp, int width) {
        return xp - 1;
    }
}
