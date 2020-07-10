package academy.pocu.comp2500.lab8;

import java.util.ArrayList;

public class Planter {
    private int waterAmount;
    ArrayList<SmartDevice> devices = new ArrayList<>();

    public Planter(int waterAmount) {
        this.waterAmount = waterAmount;
    }

    public void setWaterAmount(int waterAmount) {
        this.waterAmount = waterAmount;
    }

    public int getWaterAmount() {
        return waterAmount;
    }

    public void installSmartDevice(SmartDevice device) {
        device.planter = this;
        devices.add(device);
    }

    public void tick() {
        for (var device : devices) {
            device.onTick();
        }
    }
}
