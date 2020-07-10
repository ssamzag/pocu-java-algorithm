package academy.pocu.comp2500.lab8;

import java.util.ArrayList;

public class Sprinkler extends SmartDevice implements ISprayable {
    private ArrayList<Schedule> schedules = new ArrayList<>();
    private Schedule schedule;
    private static final int SPRAYED_VOLUME = 13;

    private int counter;

    public void addSchedule(Schedule schedule) {
        this.schedules.add(schedule);
    }

    @Override
    public void spray(Planter planter) {
        if (planter == null) {
            return;
        }
        planter.setWaterAmount(planter.getWaterAmount() + SPRAYED_VOLUME);

    }

    @Override
    public boolean isOn() {
        if (schedules.size() == 0 || currentTick == 0) {
            return false;
        }

        return schedules.get(0).getSprinklerStartTick() < this.counter;
    }

    @Override
    public void onTick() {
        super.currentTick++;
        counter++;

        if (isOn()) {
            if (schedules.get(0).getTickCounter() + schedules.get(0).getSprinklerStartTick() >= counter) {
                if (schedules.get(0).getSprinklerStartTick() + 1 == counter) {
                    super.currentTick = 1;
                }
                spray(super.planter);
            } else {
                schedules.remove(0);
                for (var schedule : schedules) {
                    if (schedule.getSprinklerStartTick() < counter) {
                        schedules.remove(schedule);
                    } else {
                        break;
                    }
                }
                super.currentTick = 1;
            }
        }

    }

}
