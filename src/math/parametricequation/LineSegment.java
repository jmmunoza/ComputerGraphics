package math.parametricequation;

public class LineSegment {
    public double x1;
    public double x2;
    public double y1;
    public double y2;

    public LineSegment(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public static LineSegmentSolveResult solve(LineSegment line1, LineSegment line2) {
        if (areLinesParallel(line1, line2)) {
            return LineSegmentSolveResult.failed();
        }

        double mx1 = line1.x2 - line1.x1;
        double my1 = line1.y2 - line1.y1;
        double mx2 = line2.x2 - line2.x1;
        double my2 = line2.y2 - line2.y1;

        double u2 = ((line2.y1 - line1.y1) * mx1 - (line2.x1 - line1.x1) * my1) / (mx2 * my1 - mx1 * my2);
        double u1 = (line2.x1 + u2 * mx2 - line1.x1) / mx1;

        return LineSegmentSolveResult.success(u1, u2);
    }

    public static boolean areLinesParallel(LineSegment line1, LineSegment line2) {
        return line1.slope() == line2.slope();
    }

    public double slope() {
        return (y2 - y1) / (x2 - x1);
    }

    public double getX(double u) {
        return x1 + u * (x2 - x1);
    }

    public double getY(double u) {
        return y1 + u * (y2 - y1);
    }
}
