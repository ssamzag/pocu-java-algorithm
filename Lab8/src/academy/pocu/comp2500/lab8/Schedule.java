package academy.pocu.comp2500.lab8;

public class Schedule {
    private int sprinklerStartTick;
    private int tickCounter;

    public Schedule(int sprinklerStartTick, int tickCounter) {
        this.sprinklerStartTick = sprinklerStartTick;
        this.tickCounter = tickCounter;
    }

    public int getSprinklerStartTick() {
        return this.sprinklerStartTick;
    }

    public int getTickCounter() {
        return this.tickCounter;
    }
}
