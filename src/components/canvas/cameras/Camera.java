package components.canvas.cameras;

import components.canvas.listeners.CanvasKeyArrowListener;
import components.canvas.listeners.CanvasKeyListener;
import components.canvas.observers.CanvasKeyArrowObserver;
import components.canvas.observers.CanvasKeyObserver;
import components.canvas.transformations.matrixes.ProjectionMatrix;
import components.canvas.transformations.matrixes.ViewMatrix;
import math.matrix.Matrix4x4;
import math.point.Point3D;
import math.vector.Vector3D;
import math.vector.Vector4D;

public abstract class Camera implements CanvasKeyArrowListener, CanvasKeyListener {
    protected double PROJECTION_DISTANCIE = 500;
    protected Point3D position;
    protected Point3D lookAt;
    protected Vector3D up;
    private Matrix4x4 M;

    public Camera() {
        position = new Point3D(0, 0, PROJECTION_DISTANCIE * 2);
        lookAt = new Point3D(0, 0, -PROJECTION_DISTANCIE * 2);
        up = new Vector3D(0, 1, 0);

        calculateM();

        CanvasKeyArrowObserver.attachListener(this);
        CanvasKeyObserver.attachListener(this);
    }

    public Vector3D transformCoords(double x, double y, double z) {
        Vector4D v = new Vector4D(x, y, z, 1);
        Matrix4x4 M = getViewMatrix();
        Vector4D viewCoords = Matrix4x4.times(M, v);

        Matrix4x4 P = new ProjectionMatrix(-PROJECTION_DISTANCIE);
        Vector4D MPv = Matrix4x4.times(P, viewCoords);
        Vector4D result = normalizeW(MPv);


        return new Vector3D(result.x, result.y, result.z);
    }

    private Matrix4x4 getViewMatrix() {
        if (M == null) calculateM();

        return M;
    }

    public void calculateM() {
        M = new ViewMatrix(position, lookAt, up);
    }

    private Vector4D normalizeW(Vector4D v) {
        return new Vector4D(new double[]{
                v.x / v.w, v.y / v.w, v.z / v.w, 1,
        });
    }

    @Override
    public void onUpPressed() {

    }

    @Override
    public void onDownPressed() {

    }

    @Override
    public void onRightPressed() {

    }

    @Override
    public void onLeftPressed() {

    }

    @Override
    public void onKeyPressed(int code) {

    }

    public Point3D getPosition() {
        return position;
    }

    public Vector3D getUp() {
        return up;
    }

    public Point3D getLookAt() {
        return lookAt;
    }

    public double getProjectionDistance() {
        return PROJECTION_DISTANCIE;
    }

    public void lookAt(double x, double y, double z) {
        lookAt = new Point3D(x, y, z);
    }

    public void setPosition(double x, double y, double z) {
        position = new Point3D(x, y, z);
    }
}
