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
        {
            Sprinkler sprinkler = new Sprinkler();

            sprinkler.addSchedule(new Schedule(3, 2));
            sprinkler.addSchedule(new Schedule(2, 3));
            sprinkler.addSchedule(new Schedule(6, 4));

            boolean[] expectedIsOn = new boolean[]{false, false, false, false, true, true, false,
                    true, true, true, true, false, false};

            for (int i = 0; i < expectedIsOn.length; ++i) {
                assert (expectedIsOn[i] == sprinkler.isOn());
                sprinkler.onTick();
            }
        }

        {
            Sprinkler sprinkler = new Sprinkler();

            sprinkler.addSchedule(new Schedule(3, 20));
            Drainer drainer = new Drainer(50);

            Planter planter = new Planter(0);
            planter.installSmartDevice(sprinkler);
            planter.installSmartDevice(drainer);

            int[] expectedWaterAmount = new int[]{0, 0, 0, 0, 13, 26, 39, 52, 58, 64,
                    70, 76, 82, 88, 94, 100, 106, 112, 118, 124,
                    130, 136, 142, 148, 139, 130, 121, 112, 103, 94,
                    85, 76, 67, 58, 49, 47, 45, 43, 41, 39,
                    37, 35, 33, 31, 29, 27, 25, 23, 21, 19};

            int[] sprinklerTicksSinceLastUpdate = new int[]{0, 1, 2, 3, 1, 2, 3, 4, 5, 6,
                    7, 8, 9, 10, 11, 12, 13, 14, 15, 16,
                    17, 18, 19, 20, 1, 2, 3, 4, 5, 6,
                    7, 8, 9, 10, 11, 12, 13, 14, 15, 16,
                    17, 18, 19, 20, 21, 22, 23, 24, 25, 26};
            int[] drainerTicksSinceLastUpdate = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 1, 2,
                    3, 4, 5, 6, 7, 8, 9, 10, 11, 12,
                    13, 14, 15, 16, 17, 18, 19, 20, 21, 22,
                    23, 24, 25, 26, 27, 1, 2, 3, 4, 5,
                    6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

            for (int i = 0; i < expectedWaterAmount.length; ++i) {
                assert (expectedWaterAmount[i] == planter.getWaterLevel());
                assert (sprinklerTicksSinceLastUpdate[i] == sprinkler.getTicksSinceLastUpdate());
                assert (drainerTicksSinceLastUpdate[i] == drainer.getTicksSinceLastUpdate());
                planter.tick();
            }
        }
    }
}
