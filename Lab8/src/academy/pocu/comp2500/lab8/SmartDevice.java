package academy.pocu.comp2500.lab8;

public abstract class SmartDevice {
    protected int currentTick;
    protected boolean isOn;

    public boolean isOn() {
        return isOn;
    }

    public void onTick() {

    }

    public int getTicksSinceLastUpdate() {
        return currentTick;
    }

    public void onInstalled(Planter planter) {

    }

}
