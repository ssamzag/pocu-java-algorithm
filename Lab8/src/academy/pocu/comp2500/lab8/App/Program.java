package academy.pocu.comp2500.lab8.app;

import academy.pocu.comp2500.lab8.Drainer;
import academy.pocu.comp2500.lab8.Planter;
import academy.pocu.comp2500.lab8.Schedule;
import academy.pocu.comp2500.lab8.Sprinkler;

public class Program {
    public static void main(String[] args) {
        //made me
        {
            Sprinkler sprinkler = new Sprinkler();

            sprinkler.addSchedule(new Schedule(3, 4));
            Planter planter = new Planter(0);
            planter.installSmartDevice(sprinkler);

            int[] expectedWaterAmount = new int[]{
                    0, 0, 0, 0, 13, 26, 39, 52, 50, 48
            };

            int[] sprinklerTicksSinceLastUpdate = new int[]{
                    0, 1, 2, 3, 1, 2, 3, 4, 1, 2
            };

            boolean[] expectedIsOn = new boolean[]{
                    false, false, false, false, true, true, true, true, false, false
            };


            for (int i = 0; i < expectedWaterAmount.length; ++i) {
                //System.out.println(i);
                assert (expectedWaterAmount[i] == planter.getWaterAmount());
                assert (sprinklerTicksSinceLastUpdate[i] == sprinkler.getTicksSinceLastUpdate());
                assert (expectedIsOn[i] == sprinkler.isOn());
                //System.out.println(drainer.getTicksSinceLastUpdate());
                planter.tick();
            }
        }


        {

            Sprinkler sprinkler = new Sprinkler();

            sprinkler.addSchedule(new Schedule(0, 1));
            sprinkler.addSchedule(new Schedule(1, 1));
            sprinkler.addSchedule(new Schedule(2, 1));
            sprinkler.addSchedule(new Schedule(3, 1));
            Planter planter = new Planter(0);
            planter.installSmartDevice(sprinkler);

            int[] expectedWaterAmount = new int[]{
                    0, 13, 11, 24, 22, 20
            };

            int[] sprinklerTicksSinceLastUpdate = new int[]{
                    0, 1, 1, 1, 1, 2
            };

            boolean[] expectedIsOn = new boolean[]{
                    false, true, false, true, false, false
            };

            for (int i = 0; i < expectedWaterAmount.length; ++i) {
                //System.out.println(i);
                assert (expectedWaterAmount[i] == planter.getWaterAmount());
                assert (sprinklerTicksSinceLastUpdate[i] == sprinkler.getTicksSinceLastUpdate());
                assert (expectedIsOn[i] == sprinkler.isOn());
                //System.out.println(drainer.getTicksSinceLastUpdate());
                planter.tick();
            }

        }

//        {
//            Sprinkler sprinkler = new Sprinkler();
//            sprinkler.addSchedule(new Schedule(1, 4));
//            sprinkler.addSchedule(new Schedule(5, 1));
//
//            Sprinkler sprinkler2 = new Sprinkler();
//            sprinkler2.addSchedule(new Schedule(5, 2));
//
//            Sprinkler sprinkler3 = new Sprinkler();
//            sprinkler3.addSchedule(new Schedule(5, 2));
//
//
//            Drainer drainer1 = new Drainer(40);
//            Drainer drainer2 = new Drainer(40);
//
//            Planter planter = new Planter(0);
//
//            planter.installSmartDevice(sprinkler);
//            planter.installSmartDevice(sprinkler2);
//            //planter.installSmartDevice(sprinkler3);
//            planter.installSmartDevice(drainer1);
//            planter.installSmartDevice(drainer2);
//
//            boolean[] expectedIsOn = new boolean[] {
//                    false, false, true,true,true,
//                    true,true, true, true, false,
//                    false, false, false, false};
//
//            int[] expectedWaterAmount = new int[]{
//                    0, 0, 13, 26, 39,
//                    52, 66, 80, 64, 48,
//                    32, 30, 28, 26};
//
//            int[] sprinklerTicksSinceLastUpdate = new int[]{
//                    0, 1, 1,2,3,
//                    4,1,2,3,4,
//                    5,6,7,8,9};
//            int[] sprinklerTicksSinceLastUpdate2 = new int[]{
//                    0, 1, 2,3,4,
//                    5,1,2,1,2,
//                    3,4,5,6,7};
//
//            int[] sprinklerTicksSinceLastUpdate3 = new int[]{
//                    0, 1, 2,3,4,
//                    5,1,2,1,2,
//                    3,4,5,6,7};
//
//            int[] drainerTicksSinceLastUpdate = new int[]{
//                    0,1,2,3,4,
//                    5,1,2,3,4,
//                    5,1, 2,3, 4,5,6};
//
//            for (int i = 0; i < expectedWaterAmount.length; ++i) {
//                assert (expectedWaterAmount[i] == planter.getWaterAmount());
//                assert (sprinklerTicksSinceLastUpdate[i] == sprinkler.getTicksSinceLastUpdate());
//                assert (sprinklerTicksSinceLastUpdate2[i] == sprinkler2.getTicksSinceLastUpdate());
//                assert (drainerTicksSinceLastUpdate[i] == drainer2.getTicksSinceLastUpdate());
//                planter.tick();
//                if (i == 7) {
//                    Sprinkler sprinkler4 = new Sprinkler();
//                    sprinkler4.addSchedule(new Schedule(6, 2));
//                    planter.installSmartDevice(sprinkler4);
//                }
//            }
//        }
//        {
//            Sprinkler sprinkler = new Sprinkler();
//            sprinkler.addSchedule(new Schedule(0, 1));
//            sprinkler.addSchedule(new Schedule(1, 1));
//            boolean[] expectedIsOn = new boolean[]{false, true, false};
//            int[] sprinklerTicksSinceLastUpdate = new int[]{0, 1, 1};
//            for (int i = 0; i < expectedIsOn.length; ++i) {
//                //System.out.println(i);
//                assert (expectedIsOn[i] == sprinkler.isOn());
//                assert (sprinklerTicksSinceLastUpdate[i] == sprinkler.getTicksSinceLastUpdate());
//                sprinkler.onTick();
//            }
//        }
//        {
//            Sprinkler sprinkler = new Sprinkler();
//            sprinkler.addSchedule(new Schedule(2, 5));
//            sprinkler.addSchedule(new Schedule(4, 8));
//            sprinkler.addSchedule(new Schedule(3, 4));
//            sprinkler.addSchedule(new Schedule(12, 2));
//            boolean[] expectedIsOn = new boolean[]{false, false, false, true, true, true, true,
//                    true, false, false, false, false, false, false, false};
//            int[] sprinklerTicksSinceLastUpdate = new int[]{0, 1, 2, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 6, 7};
//            for (int i = 0; i < expectedIsOn.length; ++i) {
//                //System.out.println(i);
//                assert (expectedIsOn[i] == sprinkler.isOn());
//                assert (sprinklerTicksSinceLastUpdate[i] == sprinkler.getTicksSinceLastUpdate());
//                sprinkler.onTick();
//            }
//        }

        {
            Planter planter = new Planter(50);

            assert (planter.getWaterAmount() == 50) : "50 아님";

            planter.tick();
            assert (planter.getWaterAmount() == 48) : "48 아님";
            planter.tick();
            assert (planter.getWaterAmount() == 46) : "46 아님";
        }
        {
            Sprinkler sprinkler = new Sprinkler();

            sprinkler.addSchedule(new Schedule(0, 4));
            sprinkler.addSchedule(new Schedule(2, 3));
            sprinkler.addSchedule(new Schedule(6, 4));

            boolean[] expectedIsOn = new boolean[]{false, true, true, true, true, false, false,
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
                assert (expectedWaterAmount[i] == planter.getWaterAmount());
                assert (sprinklerTicksSinceLastUpdate[i] == sprinkler.getTicksSinceLastUpdate());
                assert (drainerTicksSinceLastUpdate[i] == drainer.getTicksSinceLastUpdate());
                planter.tick();
            }
        }
    }
}