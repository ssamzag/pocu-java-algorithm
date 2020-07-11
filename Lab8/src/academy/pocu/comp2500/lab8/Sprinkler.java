package academy.pocu.comp2500.lab8;

import java.util.ArrayList;

public class Sprinkler extends SmartDevice implements ISprayable {
    private ArrayList<Schedule> schedules = new ArrayList<>();
    private static final int SPRAYED_VOLUME = 15;

    private int counter;

    public void addSchedule(Schedule schedule) {
        this.schedules.add(schedule);
    }

    @Override
    public void onInstalled(Planter planter) {
        planter.addSprayDevices(this);
    }

    @Override
    public void spray(Planter planter) {
        if (planter == null) {
            return;
        }

        onTick();
        if (isOn()) {
            planter.setWaterAmount(planter.getWaterAmount() + SPRAYED_VOLUME);
        }
    }

    @Override
    public void onTick() {
        super.currentTick++;
        counter++;

        if (schedules.size() == 0) {
            return;
        }

        if (schedules.get(0).getSprinklerStartTick() < counter) {

            if (!super.isOn()) {
                super.isOn = true;
                super.currentTick = 1;
            }
            if (currentTick > schedules.get(0).getTickCounter()) {
                if (super.isOn()) {
                    super.isOn = false;
                    super.currentTick = 1;
                }
                schedules.remove(0);
                int size = schedules.size();
                for (int i = 0; i < size; i++) {
                    if (schedules.get(0).getSprinklerStartTick() < counter) {
                        schedules.remove(schedules.get(0));
                    } else {
                        break;
                    }
                }
            }
        }
    }

}
