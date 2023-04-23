package simulationElements.states;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import simulationElements.Individual.Individual;
import simulationElements.vector.Vector;

import java.util.Random;

public class Infected extends States {
    public String name = "Infected";
    boolean symptoms;
    int timer;

    public Infected(Individual individual){
        super(individual);
        color = Color.RED;
        Random random = new Random();
        symptoms = random.nextBoolean();
        timer = random.nextInt(20, 31) * 25;
    }

    @Override
    public boolean input(boolean input) {
        return false;
    }

    @Override
    public boolean output() {
        if(symptoms){
            return true;
        } else {
            Random random = new Random();
            return random.nextBoolean();
        }
    }

    @Override
    public States nextState() {
        return new Immune(individual);
    }

    public String getName(){
        return name;
    }

    @Override
    public void collosion(Individual other) {
        if(other.getState() == "Healthy") {
            double X = individual.getPosition()[0] - other.getPosition()[0];
            double Y = individual.getPosition()[1] - other.getPosition()[1];
            Vector vector = new Vector(X, Y);
            if (vector.abs() < 7) {
                other.changeState();
            }
        }
    }

    @Override
    public boolean secondPassed() {
        if(timer == 0){
            return true;
        } else {
            timer -= 1;
        }
        return false;
    }
}
