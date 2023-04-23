package simulationElements.vector;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Vector implements IVector {
    private double x;
    private double y;

    public Vector(double x, double y){
        this.x = x;
        this.y = y;
    }

    @Override
    public double abs() {
        return sqrt(x*x + y*y);
    }

    @Override
    public double cdot(IVector vector) {
        return x * vector.getComponents()[0] + y * vector.getComponents()[1];
    }

    @Override
    public double[] getComponents() {
        double[] ret = new double[2];
        ret[0] = x;
        ret[1] = y;
        return ret;
    }

    @Override
    public void show() {
        System.out.println("x: " + x);
        System.out.println("y: " + y);
    }

    public void setX(double X){
        x = X;
    }

    public void setY(double Y){
        y = Y;
    }
}
