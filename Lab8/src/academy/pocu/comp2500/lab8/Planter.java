package academy.pocu.comp2500.lab8;

import java.util.ArrayList;

public class Planter {
    private int waterLevel;
    ArrayList<SmartDevice> devices = new ArrayList<>();
    ArrayList<Sprinkler> sprayDevices = new ArrayList<>();
    ArrayList<Drainer> drainDevices = new ArrayList<>();
    ArrayList<IWaterDetectable> waterDetects = new ArrayList<>();

    public Planter(int waterLevel) {
        this.waterLevel = waterLevel;
    }

    public void setWaterLevel(int waterLevel) {
        this.waterLevel = Math.max(waterLevel, 0);
    }

    public void addSprayDevices(Sprinkler sprinkler) {
        this.sprayDevices.add(sprinkler);
    }

    public void addDrainDevices(Drainer drainer) {
        this.drainDevices.add(drainer);
    }

    public int getWaterLevel() {
        return waterLevel;
    }

    public void installSmartDevice(SmartDevice device) {
        device.onInstalled(this);
        devices.add(device);
    }

    public void tick() {
        for (var drainDevice : drainDevices) {
            drainDevice.detect(this.waterLevel);
        }

        for (var drainDevice : drainDevices) {
            drainDevice.drain(this);
        }

        for (var sprayDevice : sprayDevices) {
            sprayDevice.spray(this);
            waterLevel = waterLevel - 2;
        }


        if (waterLevel < 0) {
            waterLevel = 0;
        }

    }
}
