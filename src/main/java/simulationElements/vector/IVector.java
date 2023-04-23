package simulationElements.vector;

public interface IVector {
    double abs();
    double cdot(IVector vector);
    double[] getComponents();
    void show();
}
