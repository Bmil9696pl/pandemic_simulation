package simulationElements.arena;

import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;
import simulationElements.Individual.Individual;

import java.util.ArrayList;
import java.util.Random;

public class Arena {
    ArrayList<Individual> individuals;
    Pane pane;
    int timeToSnapshot;

    public Arena(Pane pane){
        this.individuals = new ArrayList<Individual>();
        Individual temp;
        this.pane = pane;
        timeToSnapshot = 25;
        for(int x = 0; x<50; x++){
            temp = generateIndividual();
            this.pane.getChildren().add(temp.getCircle());
            individuals.add(temp);
        }
    }

    public void move(){
        ArrayList<Individual> temp = new ArrayList<Individual>();
        boolean delete = false;
        //for (int x = 0; x<25; x++){
            for (Individual individual:
                    individuals) {
                if(individual.move(pane)){
                    temp.add(individual);
                }
                for (Individual other :
                        individuals) {
                    if(individual != other) {
                        pane.getChildren().remove(other.getCircle());
                        individual.collision(other);
                        this.pane.getChildren().add(other.getCircle());
                    }
                }
                individual.draw();
            }
            for (Individual individual :
                    temp) {
                pane.getChildren().remove(individual.getCircle());
                individuals.remove(individual);
            }
            temp.removeAll(temp);
        //}
        Individual newBoy;
        for (Individual individual :
                individuals) {
            if(individual.secondPassed()){
                pane.getChildren().remove(individual.getCircle());
                individual.changeState();
                this.pane.getChildren().add(individual.getCircle());
            }
        }
        //for(int x = 0; x<5; x++){
            newBoy = generateIndividual();
            individuals.add(newBoy);
            this.pane.getChildren().add(newBoy.getCircle());
        //}
    }
    private Individual generateIndividual(){
        double x = 0, y = 0;
        Random rand = new Random();
        int choice = rand.nextInt(0, 4);
        switch(choice){
            case 0 ->{
                x = rand.nextDouble(0, pane.getWidth());
                y = 0;
            }
            case 1 ->{
                x = 0;
                y = rand.nextDouble(0, pane.getHeight());
            }
            case 2 ->{
                x = rand.nextDouble(0,pane.getWidth());
                y = pane.getHeight();
            }
            case 3 ->{
                x = pane.getWidth();
                y = rand.nextDouble(0, pane.getHeight());
            }
        }
        return new Individual(x,y);
    }

    public void setIndividuals(ArrayList<Individual> individuals){
        //pane.getChildren().clear();
        ArrayList<Individual> temp = new ArrayList<>(individuals);
        this.individuals.clear();
        this.individuals.addAll(temp);
        for (Individual individual :
                this.individuals) {
            pane.getChildren().add(individual.getCircle());
        }
    }

    public Snapshot getSnapshot(){
        timeToSnapshot--;
        if(timeToSnapshot == 0){
            timeToSnapshot = 25;
            ArrayList<Individual> tmp = new ArrayList<>(individuals);
            return new Snapshot(this, tmp);
        }
        return null;
    }

    public ArrayList<Individual> getIndividuals(){
        return individuals;
    }

    public Pane getPane(){
        return pane;
    }
}
