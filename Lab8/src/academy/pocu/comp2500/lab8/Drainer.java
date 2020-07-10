package academy.pocu.comp2500.lab8;

public class Drainer extends SmartDevice implements IWaterDetectable, IDrainable {
    private static final int DISPLACEMENT = 7;

    private final int displacementStartStandard;

    public Drainer(int displacementStartStandard) {
        this.displacementStartStandard = displacementStartStandard;
    }

    public int getDisplacementStartStandard() {
        return this.displacementStartStandard;
    }

    @Override
    public void onTick() {
        super.currentTick++;
        if (planter == null) {
            return;
        }
        detect(planter.getWaterAmount());
    }

    @Override
    public void drain(Planter planter) {
        planter.setWaterAmount(planter.getWaterAmount() - DISPLACEMENT);

        if (planter.getWaterAmount() < this.displacementStartStandard) {
            super.currentTick = 1;
        }
    }

    @Override
    public void detect(int waterLevel) {
        if (waterLevel >= this.displacementStartStandard) {
            drain(planter);
        }
    }
}
