package academy.pocu.comp2500.lab8;

import java.util.ArrayList;

public class Sprinkler extends SmartDevice implements ISprayable {
    private ArrayList<Schedule> schedules = new ArrayList<>();
    private static final int SPRAYED_VOLUME = 15;
    private Planter planter;
    private int sprinklerTick;

    public void addSchedule(Schedule schedule) {
        this.schedules.add(schedule);
    }

    public int getSprinklerTick() {
        return sprinklerTick;
    }

    @Override
    public void onInstalled(Planter planter) {
        planter.addSprayDevices(this);
        this.sprinklerTick = planter.getPlanterTick();
    }

    @Override
    public void spray(Planter planter) {
        if (planter == null) {
            return;
        }
        sprinklerTick = planter.getPlanterTick();
        this.planter = planter;
        onTick();
        if (isOn()) {
            planter.setWaterAmount(planter.getWaterAmount() + SPRAYED_VOLUME);
        }
    }

    @Override
    public void onTick() {
        super.addCurrentTick();
        if (schedules.size() == 0) {
            if (super.isOn()) {
                super.setOff();
                super.resetCurrentTick();
            }

            return;
        }

        if (schedules.get(0).getSprinklerStartTick() <= sprinklerTick) {
            if (!super.isOn() && sprinklerTick == schedules.get(0).getSprinklerStartTick()) {
                super.setOn();
                super.resetCurrentTick();
            }

            if (getTicksSinceLastUpdate() == schedules.get(0).getTickCounter()) {
                schedules.remove(0);
                int size = schedules.size();
                for (int i = 0; i < size; i++) {
                    if (schedules.get(0).getSprinklerStartTick() < sprinklerTick) {
                        schedules.remove(schedules.get(0));
                    } else {
                        break;
                    }
                }
            }
        } else {
            if (super.isOn()) {
                super.resetCurrentTick();
            }
            super.setOff();
        }


        if (planter == null) {
            sprinklerTick++;
        }

    }

}
