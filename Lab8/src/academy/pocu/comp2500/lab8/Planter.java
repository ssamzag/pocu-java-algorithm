package academy.pocu.comp2500.lab8;

import java.util.ArrayList;

public class Planter {
    private int waterAmount;
    private ArrayList<Sprinkler> sprayDevices = new ArrayList<>();
    private ArrayList<Drainer> drainDevices = new ArrayList<>();


    public Planter(int waterAmount) {
        this.waterAmount = waterAmount;
    }

    public void setWaterAmount(int waterAmount) {
        this.waterAmount = Math.max(waterAmount, 0);
    }

    public void addSprayDevices(Sprinkler sprinkler) {
        this.sprayDevices.add(sprinkler);
    }

    public void addDrainDevices(Drainer drainer) {
        this.drainDevices.add(drainer);
    }

    public int getWaterAmount() {
        return waterAmount;
    }

    public void installSmartDevice(SmartDevice device) {
        device.onInstalled(this);
    }

    public void tick() {
        for (var drainDevice : drainDevices) {

            drainDevice.drain(this);
            if (waterAmount < 0) {
                waterAmount = 0;
            }
        }

        for (var sprayDevice : sprayDevices) {
            sprayDevice.spray(this);
        }

        waterAmount = waterAmount - 2;
        if (waterAmount < 0) {
            waterAmount = 0;
        }

    }
}
