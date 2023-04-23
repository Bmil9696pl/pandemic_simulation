package simulationElements.states;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import simulationElements.Individual.Individual;

public class Healthy extends States{
    public String name = "Healthy";
    private int timer;
    private boolean hasBeenInfectedThisRound;

    public Healthy(Individual individual) {
        super(individual);
        timer = 3 * 25;
        hasBeenInfectedThisRound = false;
        color = Color.GREEN;
    }

    @Override
    public boolean input(boolean input) {
        if(input==false){
            return false;
        } else{
            return true;
        }
    }

    @Override
    public boolean output() {
        return false;
    }

    @Override
    public States nextState() {
        if(timer > 0){
            if(!hasBeenInfectedThisRound){
                timer -= 1;
                hasBeenInfectedThisRound = true;
            }
            return this;
        }
        return new Infected(individual);
    }

    public String getName(){
        return name;
    }
    @Override
    public void collosion(Individual other) {

    }

    @Override
    public boolean secondPassed() {
        if(hasBeenInfectedThisRound){
            hasBeenInfectedThisRound = false;
        } else {
            timer = 3;
        }
        return false;
    }
}
