package math.parametricequation;

public class LineSegmentSolveResult {
    public double u1;
    public double u2;
    public boolean success;

    private LineSegmentSolveResult(double u1, double u2) {
        this.u1 = u1;
        this.u2 = u2;
        success = true;
    }

    private LineSegmentSolveResult() {
        this.u1 = 0;
        this.u2 = 0;
        success = false;
    }

    public static LineSegmentSolveResult success(double u1, double u2) {
        return new LineSegmentSolveResult(u1, u2);
    }

    public static LineSegmentSolveResult failed() {
        return new LineSegmentSolveResult();
    }
}
