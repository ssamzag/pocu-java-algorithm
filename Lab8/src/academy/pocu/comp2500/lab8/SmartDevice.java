package academy.pocu.comp2500.lab8;

public abstract class SmartDevice {
    protected int currentTick;
    protected Planter planter;

    public boolean isOn() {
        return false;
    }

    public void onTick() {

    }

    public int getTicksSinceLastUpdate() {
        return currentTick;
    }

}
