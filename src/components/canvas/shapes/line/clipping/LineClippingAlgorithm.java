package components.canvas.shapes.line.clipping;

public enum LineClippingAlgorithm {
    COHEN_SUTHERLAND("Cohen-Sutherland"),
    LIANG_BARSKY("Liang-Barsky");

    private final String value;

    LineClippingAlgorithm(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
