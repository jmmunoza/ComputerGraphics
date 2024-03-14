package components.canvas.shapes.line.clipping;

public class LineClippingResult {
    public int x1;
    public int y1;
    public int x2;
    public int y2;
    public boolean draw;

    public LineClippingResult(int x1, int y1, int x2, int y2, boolean draw) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.draw = draw;
    }

    public static LineClippingResult onSuccess(int x1, int y1, int x2, int y2) {
        return new LineClippingResult(x1, y1, x2, y2, true);
    }

    public static LineClippingResult onFailure() {
        return new LineClippingResult(0, 0, 0, 0, false);
    }
}
