package simulationElements.TimeFlow;

import javafx.animation.AnimationTimer;
import simulationElements.arena.Arena;
import simulationElements.arena.Snapshot;

import java.util.ArrayList;

public class TimeFlow extends AnimationTimer {
    Arena arena;
    ArrayList<Snapshot> snapshots;
    private long framesps = 25L;
    private long interval = 1000000000L / framesps;
    private long last = 0;

    public TimeFlow(Arena arena, ArrayList<Snapshot> snapshots){
        this.arena = arena;
        this.snapshots = snapshots;
    }

    @Override
    public void handle(long now) {
        if(now - last > interval){
            arena.move();
            Snapshot tmp = arena.getSnapshot();

            if(tmp != null){
                snapshots.add(tmp);
            }

            last = now;
        }
    }

    public ArrayList<Snapshot> getSnapshots(){
        return snapshots;
    }
}