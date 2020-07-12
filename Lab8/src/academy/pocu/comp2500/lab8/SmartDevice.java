package academy.pocu.comp2500.lab8;

public abstract class SmartDevice {
    private int currentTick;
    private boolean isOn;

    public boolean isOn() {
        return isOn;
    }

    public void setOn() {
        this.isOn = true;
    }

    public void setOff() {
        this.isOn = false;
    }

    public void onTick() {

    }

    public int getTicksSinceLastUpdate() {
        return currentTick;
    }

    public void resetCurrentTick() {
        this.currentTick = 1;
    }

    public void addCurrentTick() {
        this.currentTick++;
    }

    public void onInstalled(Planter planter) {

    }

}
