package simulationElements.states;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import simulationElements.Individual.Individual;

public abstract class States {
    Individual individual;
    Color color;

    States(Individual individual){
        this.individual = individual;
    }

    public abstract boolean input(boolean input);

    public abstract boolean output();

    public abstract States nextState();

    public abstract String getName();
    public Color getColor(){
        return color;
    }
    public abstract void collosion(Individual other);

    public abstract boolean secondPassed();
}
