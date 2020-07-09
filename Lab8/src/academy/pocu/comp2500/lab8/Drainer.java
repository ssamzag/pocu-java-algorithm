package academy.pocu.comp2500.lab8;

public class Drainer extends SmartDevice implements IWaterDetectable, IDrainable{
    private static int DISPLACEMENT = 7;
    private Planter planter;

    private int displacementStartStandard;

    public Drainer(int displacementStartStandard) {
        this.displacementStartStandard = displacementStartStandard;
    }

    public int getDisplacementStartStandard() {
        return this.displacementStartStandard;
    }

    @Override
    public void onTick() {
        detect(planter.getWaterAmount());
    }

    @Override
    public void drain(Planter planter) {

    }

    @Override
    public void detect(int waterLevel) {
        if (waterLevel >= this.displacementStartStandard)) {
            drain(planter);
        }
    }
}
