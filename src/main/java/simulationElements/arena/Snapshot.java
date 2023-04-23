package simulationElements.arena;

import simulationElements.Individual.Individual;

import java.util.ArrayList;

public class Snapshot {
    private Arena arena;
    ArrayList<Individual> individuals;

    public Snapshot(Arena arena,ArrayList<Individual> individuals){
        this.arena = arena;
        ArrayList<Individual> temp = new ArrayList<>(individuals);
        this.individuals = new ArrayList<>();
        this.individuals.addAll(temp);
    }

    public void restore(){
        arena.setIndividuals(individuals);
    }
}
