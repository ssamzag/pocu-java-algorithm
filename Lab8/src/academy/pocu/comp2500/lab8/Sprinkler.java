package academy.pocu.comp2500.lab8;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Sprinkler extends SmartDevice implements ISprayable {
    private ArrayList<Schedule> schedules = new ArrayList<>();
    private static int sprayedVolume = 15;
    private Planter planter;
    private int counter;

    public void addSchedule(Schedule schedule) {
        this.schedules.add(schedule);
    }

    @Override
    public void spray(Planter planter) {
        if (isOn()) {
            planter.setWaterAmount(sprayedVolume);
        }
    }

    @Override
    public int getTicksSinceLastUpdate() {
        return super.currentTick;
    }

    @Override
    public boolean isOn() {
        if (schedules.size() == 0) {
            return false;
        }

        if (schedules.get(0).getSprinklerStartTick() <= super.currentTick) {
            if (schedules.get(0).getTickCounter() > counter) {
                counter++;

                return true;
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
                counter = 0;
                return false;
            }
        }
        return true;
    }

    @Override
    public void onTick() {
        super.currentTick++;
        if (isOn()) {
            spray(planter);
        }

    }

}
