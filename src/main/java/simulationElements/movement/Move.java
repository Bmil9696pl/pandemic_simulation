package simulationElements.movement;

import javafx.scene.layout.Pane;
import simulationElements.Individual.Individual;
import simulationElements.vector.Vector;

import java.util.Random;

public class Move implements IMove{
    private double X;
    private double Y;

    public Move(double x,double y){
        X = x;
        Y = y;
    }

    @Override
    public boolean move(Pane pane){
        Random rand = new Random();
        Vector vect = randVector();
        double tempx = X, tempy = Y;
        X = X + vect.getComponents()[0];
        Y = Y + vect.getComponents()[1];

        if(X > pane.getWidth() || Y > pane.getHeight() || Y < 0 || X < 0){
            if(rand.nextBoolean()){
                return true;
            } else {
                do{
                    X = tempx;
                    Y = tempy;
                    vect = randVector();
                    X = X + vect.getComponents()[0];
                    Y = Y + vect.getComponents()[1];
                } while(X > pane.getWidth() || Y > pane.getHeight() || Y < 0 || X < 0);
                return false;
            }
        }
        return false;
    }

    private Vector randVector(){
        Vector vect = new Vector(0,0);
        Random rand = new Random();
        vect.setX(rand.nextDouble(-2.5,2.5));
        do{
            vect.setY(rand.nextDouble(-2.5,2.5));
        }while(vect.abs() > 2.5);
        return vect;
    }

    public double[] getCoord(){
        return new double[] {X, Y};
    }
}
