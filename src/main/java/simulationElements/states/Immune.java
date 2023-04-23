package simulationElements.states;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import simulationElements.Individual.Individual;

public class Immune extends States{
    public String name = "Immune";
    public Immune(Individual individual) {
        super(individual);
        color = Color.BLUE;
    }

    @Override
    public boolean input(boolean input) {
        return false;
    }

    @Override
    public boolean output() {
        return false;
    }

    @Override
    public States nextState() {
        return this;
    }

    public String getName(){
        return name;
    }
    @Override
    public void collosion(Individual other) {

    }

    @Override
    public boolean secondPassed() {
        return false;
    }
}
