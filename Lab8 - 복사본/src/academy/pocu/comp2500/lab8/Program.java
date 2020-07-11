package academy.pocu.comp2500.lab8;

public class Program {

    public static void main(String[] args) {
        {
            Sprinkler sprinkler = new Sprinkler();
            sprinkler.addSchedule(new Schedule(0, 1));
            sprinkler.addSchedule(new Schedule(1, 1));
            boolean[] expectedIsOn = new boolean[]{false, true, false};
            int[] sprinklerTicksSinceLastUpdate = new int[]{0, 1, 1};
            for (int i = 0; i < expectedIsOn.length; ++i) {
                //System.out.println(i);
                assert (expectedIsOn[i] == sprinkler.isOn());
                assert (sprinklerTicksSinceLastUpdate[i] == sprinkler.getTicksSinceLastUpdate());
                sprinkler.onTick();
            }
        }
        {
            Sprinkler sprinkler = new Sprinkler();
            sprinkler.addSchedule(new Schedule(2, 5));
            sprinkler.addSchedule(new Schedule(4, 8));
            sprinkler.addSchedule(new Schedule(3, 4));
            sprinkler.addSchedule(new Schedule(12, 2));
            boolean[] expectedIsOn = new boolean[]{false, false, false, true, true, true, true,
                    true, false, false, false, false, false, false, false};
            int[] sprinklerTicksSinceLastUpdate = new int[]{0, 1, 2, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 6, 7};
            for (int i = 0; i < expectedIsOn.length; ++i) {
                //System.out.println(i);
                assert (expectedIsOn[i] == sprinkler.isOn());
                assert (sprinklerTicksSinceLastUpdate[i] == sprinkler.getTicksSinceLastUpdate());
                sprinkler.onTick();
            }
        }
    }
}
