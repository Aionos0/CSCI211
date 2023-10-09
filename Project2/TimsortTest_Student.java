import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TimsortTest_Student {
    @Test
    public void testRuns2() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(18);
        list.add(12);
        list.add(9);
        list.add(6);
        list.add(13);
        list.add(14);
        list.add(1);
        list.add(12);
        Timsort evaluator = new Timsort(list, 4);
        evaluator.createRuns();
        assertEquals(4,evaluator.run(list, 0, list.size()-1));
    }

    @Test
    public void testRuns5() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(6);
        list.add(13);
        list.add(14);
        list.add(1);
        list.add(12);
        Timsort evaluator = new Timsort(list, 3);
        evaluator.run(list, 0, list.size()-1);
        evaluator.createRuns();
        assertEquals("1 6 12 13 14 \n",evaluator.printRuns());
    }
    @Test
    public void testRuns6() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(18);
        Timsort evaluator = new Timsort(list, 3);
        evaluator.createRuns();
        assertEquals(1,evaluator.run(list, 0, list.size()-1));
    }
    @Test
    public void testRuns9() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(18);
        list.add(12);
        Timsort evaluator = new Timsort(list, 3);
        evaluator.createRuns();
        evaluator.run(list, 0, list.size()-1);
        assertEquals("12 18 \n", evaluator.printRuns());
    }

    @Test
    public void testRuns11() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(12);
        list.add(18);
        Timsort evaluator = new Timsort(list, 3);
        evaluator.createRuns();
        evaluator.run(list, 0, list.size()-1);
        assertEquals("12 18 \n", evaluator.printRuns());
    }
    @Test
    public void testRuns12() {
        assertThrows(InvalidTimsortException.class, () -> {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(12);
            list.add(18);
            Timsort evaluator = new Timsort(list, 3);
            evaluator.createRuns();
            evaluator.run(list, list.size()-1, 0);
        });
    }


    @Test
    public void testMergeCollapse1() {
        ArrayList<Integer> list = new ArrayList<>();
        for(int num = 0; num < 12; num++)
            list.add(0);

        Timsort evaluator = new Timsort(list, 3);


        ArrayList<Integer> runZ = new ArrayList<>();
        runZ.add(4);
        runZ.add(8);
        runZ.add(10);
        runZ.add(12);
        runZ.add(15);
        runZ.add(17);
        evaluator.pushStack(new TimsortNumber(0, 6, runZ));

        ArrayList<Integer> runY = new ArrayList<>();
        runY.add(5);
        runY.add(7);
        runY.add(9);
        evaluator.pushStack(new TimsortNumber(6, 9, runY));

        ArrayList<Integer> runX = new ArrayList<>();
        runX.add(13);
        runX.add(16);
        runX.add(18);
        evaluator.pushStack(new TimsortNumber(9, 12, runX));
        evaluator.mergeCollapse();
        assertEquals("5 7 9 13 16 18 \n4 8 10 12 15 17 \n", evaluator.printStack());
    }

    @Test
    public void testMergeCollapse3() {
        ArrayList<Integer> list = new ArrayList<>();
        for(int num = 0; num < 15; num++)
            list.add(0);

        Timsort evaluator = new Timsort(list, 3);


        ArrayList<Integer> runZ = new ArrayList<>();
        runZ.add(4);
        runZ.add(8);
        runZ.add(10);
        runZ.add(12);
        runZ.add(15);
        evaluator.pushStack(new TimsortNumber(0, 5, runZ));

        ArrayList<Integer> runY = new ArrayList<>();
        runY.add(5);
        runY.add(7);
        runY.add(9);
        runY.add(17);
        evaluator.pushStack(new TimsortNumber(5, 9, runY));

        ArrayList<Integer> runX = new ArrayList<>();
        runX.add(3);
        runX.add(6);
        runX.add(11);
        runX.add(13);
        runX.add(16);
        runX.add(18);
        evaluator.pushStack(new TimsortNumber(9, 15, runX));
        evaluator.mergeCollapse();
        assertEquals("3 6 11 13 16 18 \n4 5 7 8 9 10 12 15 17 \n", evaluator.printStack());
    }

    @Test
    public void testMergeCollapse7() {
        ArrayList<Integer> list = new ArrayList<>();
        for(int num = 0; num < 15; num++)
            list.add(0);

        Timsort evaluator = new Timsort(list, 3);


        ArrayList<Integer> runZ = new ArrayList<>();
        runZ.add(4);
        runZ.add(6);
        runZ.add(8);
        runZ.add(10);
        runZ.add(12);
        runZ.add(14);
        runZ.add(15);
        runZ.add(18);
        evaluator.pushStack(new TimsortNumber(0, 8, runZ));

        ArrayList<Integer> runY = new ArrayList<>();
        runY.add(5);
        runY.add(16);
        runY.add(17);
        runY.add(19);
        evaluator.pushStack(new TimsortNumber(8, 12, runY));

        ArrayList<Integer> runX = new ArrayList<>();
        runX.add(13);
        runX.add(15);
        runX.add(18);
        evaluator.pushStack(new TimsortNumber(12, 15, runX));
        evaluator.mergeCollapse();
        assertEquals("13 15 18 \n5 16 17 19 \n4 6 8 10 12 14 15 18 \n", evaluator.printStack());
    }


    @Test
    public void testMergeCollapse9() {
        ArrayList<Integer> list = new ArrayList<>();
        for(int num = 0; num < 30; num++)
            list.add(0);

        Timsort evaluator = new Timsort(list, 3);

        ArrayList<Integer> runStackBottom = new ArrayList<>();
        runStackBottom.add(-12);
        runStackBottom.add(-1);
        runStackBottom.add(0);
        runStackBottom.add(2);
        runStackBottom.add(3);
        runStackBottom.add(6);
        runStackBottom.add(9);
        runStackBottom.add(12);
        runStackBottom.add(17);
        runStackBottom.add(25);
        evaluator.pushStack(new TimsortNumber(0, 10, runStackBottom));

        ArrayList<Integer> runZ = new ArrayList<>();
        runZ.add(4);
        runZ.add(8);
        runZ.add(10);
        runZ.add(15);
        runZ.add(27);
        evaluator.pushStack(new TimsortNumber(10, 15, runZ));

        ArrayList<Integer> runY = new ArrayList<>();
        runY.add(-5);
        runY.add(10);
        runY.add(16);
        runY.add(29);
        evaluator.pushStack(new TimsortNumber(15, 19, runY));

        ArrayList<Integer> runX = new ArrayList<>();
        runX.add(-13);
        runX.add(-2);
        runX.add(-1);
        runX.add(1);
        runX.add(9);
        runX.add(13);
        runX.add(16);
        runX.add(19);
        runX.add(21);
        runX.add(28);
        runX.add(32);
        evaluator.pushStack(new TimsortNumber(19, 30, runX));
        evaluator.mergeCollapse();
        assertEquals("-13 -2 -1 1 9 13 16 19 21 28 32 \n-12 -5 -1 0 2 3 4 6 8 9 10 10 12 15 16 17 25 27 29 \n", evaluator.printStack());
    }
    @Test
    public void testMergeForceCollapse1() {
        ArrayList<Integer> list = new ArrayList<>();
        for(int num = 0; num < 21; num++)
            list.add(0);

        Timsort evaluator = new Timsort(list, 3);
        ArrayList<Integer> run0 = new ArrayList<>();
        run0.add(-12);
        run0.add(-5);
        run0.add(0);
        run0.add(2);
        run0.add(3);
        run0.add(6);
        run0.add(9);
        run0.add(12);
        run0.add(17);
        run0.add(25);
        evaluator.pushStack(new TimsortNumber(0, 10, run0));

        ArrayList<Integer> run1 = new ArrayList<>();
        run1.add(-13);
        run1.add(-2);
        run1.add(-1);
        run1.add(1);
        run1.add(9);
        run1.add(13);
        run1.add(16);
        run1.add(19);
        run1.add(21);
        run1.add(28);
        run1.add(32);
        evaluator.pushStack(new TimsortNumber(10, 21, run1));
        evaluator.mergeForceCollapse();
        assertEquals("-13 -12 -5 -2 -1 0 1 2 3 6 9 9 12 13 16 17 19 21 25 28 32 \n", evaluator.printStack());
    }

    @Test
    public void testMergeForceCollapse3() {
        ArrayList<Integer> list = new ArrayList<>();
        for(int num = 0; num < 22; num++)
            list.add(0);

        Timsort evaluator = new Timsort(list, 3);
        ArrayList<Integer> run0 = new ArrayList<>();
        run0.add(-12);
        run0.add(-5);
        run0.add(0);
        run0.add(2);
        run0.add(3);
        run0.add(6);
        run0.add(9);
        run0.add(22);
        run0.add(23);
        run0.add(29);
        run0.add(35);
        run0.add(40);
        evaluator.pushStack(new TimsortNumber(0, 12, run0));

        ArrayList<Integer> run1 = new ArrayList<>();
        run1.add(47);
        run1.add(51);
        run1.add(55);
        run1.add(56);
        run1.add(68);
        run1.add(72);
        evaluator.pushStack(new TimsortNumber(12, 18, run1));

        ArrayList<Integer> run2 = new ArrayList<>();
        run2.add(10);
        run2.add(11);
        run2.add(19);
        run2.add(21);
        evaluator.pushStack(new TimsortNumber(18, 22, run2));

        evaluator.mergeForceCollapse();
        assertEquals("-12 -5 0 2 3 6 9 10 11 19 21 22 23 29 35 40 47 51 55 56 68 72 \n", evaluator.printStack());
    }

}