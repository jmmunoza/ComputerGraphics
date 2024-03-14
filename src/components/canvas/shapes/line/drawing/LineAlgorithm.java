package components.canvas.shapes.line.drawing;

public enum LineAlgorithm {
    BRESENHAM("Bresenham");

    private final String value;

    LineAlgorithm(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
