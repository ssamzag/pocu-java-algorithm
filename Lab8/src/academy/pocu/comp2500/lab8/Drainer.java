package academy.pocu.comp2500.lab8;

public class Drainer extends SmartDevice implements IWaterDetectable, IDrainable {
    private static final int DISPLACEMENT = 7;
    private int detectWaterLevel;
    private final int displacementStartStandard;
    private int waterLevel;

    public Drainer(int displacementStartStandard) {
        this.displacementStartStandard = displacementStartStandard;
    }

    public int getDisplacementStartStandard() {
        return this.displacementStartStandard;
    }

    @Override
    public void onInstalled(Planter planter) {
        planter.addDrainDevices(this);
    }

    @Override
    public void onTick() {
        super.currentTick++;
    }

    @Override
    public void drain(Planter planter) {
        if (planter == null) {
            return;
        }
        onTick();

        if (planter.getWaterAmount() >= this.displacementStartStandard) {
            if (!super.isOn()) {
                super.isOn = true;
                super.currentTick = 1;
            }

            planter.setWaterAmount(planter.getWaterAmount() - DISPLACEMENT);
        } else if (super.isOn()) {
            super.isOn = false;
            super.currentTick = 1;
        }

    }

    @Override
    public void detect(int waterLevel) {
        detectWaterLevel = waterLevel;
    }
}
