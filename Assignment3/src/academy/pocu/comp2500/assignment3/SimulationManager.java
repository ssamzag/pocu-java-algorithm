package academy.pocu.comp2500.assignment3;

import java.util.ArrayList;

public final class SimulationManager {
    private static SimulationManager instance;
    private ArrayList<Unit> units = new ArrayList<>();
    private int unitNoSeq;

    public static SimulationManager getInstance() {
        if (instance == null) {
            instance = new SimulationManager();
        }
        return instance;
    }

    public ArrayList<Unit> getUnits() {
        return this.units;
    }

    public void spawn(Unit unit) {
        units.add(unit);
    }

    public void registerThinkable(Unit thinkable) {

    }

    public void registerMovable(Unit movable) {

    }

    public void registerCollisionEventListener(Unit listener) {

    }

    public void update() {

    }
}