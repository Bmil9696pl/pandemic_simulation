package simulationElements.Individual;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import simulationElements.movement.Move;
import simulationElements.states.Healthy;
import simulationElements.states.Infected;
import simulationElements.states.States;

import java.util.Random;

public class Individual implements IIndividual{
    States state;
    Move move;
    Circle circle;

    public Individual(double X, double Y){
        move = new Move(X,Y);
        Random rand = new Random();
        if(rand.nextInt(1,11) < 2){
            state = new Infected(this);
        } else {
            state = new Healthy(this);
        }
        circle = new Circle(5, state.getColor());
        draw();
    }

    public void draw(){
        circle.setTranslateX(move.getCoord()[0]);
        circle.setTranslateY(move.getCoord()[1]);
    }

    @Override
    public boolean move(Pane pane) {
        return move.move(pane);
    }

    public void collision(Individual other){
        state.collosion(other);
    }

    public Circle getCircle(){
        return circle;
    }

    public double[] getPosition(){
        return move.getCoord();
    }

    public String getState(){
        return state.getName();
    }

    public void changeState(){
        state = state.nextState();
        circle = new Circle(5, state.getColor());
    }

    public boolean secondPassed(){
        return state.secondPassed();
    }
}
