import java.util.ArrayList;
import java.util.Random;

public class TimsortDriver {

    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(18);
        list1.add(12);
//		list1.add(9);
//		list1.add(6);
//		list1.add(13);
//		list1.add(14);
//		list1.add(1);
//		list1.add(12);
//		//list1.add(13);
//		list1.add(15);
//		list1.add(24);

        Timsort s1 = new Timsort(list1, 3);
        s1.createRuns();
        int count1 = s1.run(list1, 0, list1.size()-1);
        //System.out.println("Count is " + count1);
        //String output1 = s1.printRange(list1, 0, count1);
        //System.out.println(output1);

        System.out.println("Current List.....");
        for(int i = 0; i < list1.size(); i++) {
            System.out.print(list1.get(i) + "  ");
        }


        System.out.println("\nPrinting Runs for List 1....");
        String result = s1.printRuns();
        System.out.println(result);

        System.out.println("\nPrinting List 1 from Stack.......");
        result = s1.printStack();
        System.out.println(result);
		/*
		System.out.println("\nSorting.....");
		s1.binarySort(list1, 0, list1.size(), 4);
		for(int i = 0; i < list1.size(); i++) {
			System.out.print(list1.get(i) + "  ");
		}
		*/
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(18);
        list2.add(12);
        list2.add(9);
        list2.add(7);
        list2.add(10);
        list2.add(11);
        list2.add(2);
        list2.add(9);
        list2.add(15);
        list2.add(3);
        list2.add(-1);
        list2.add(12);
        list2.add(20);
        list2.add(22);
        list2.add(1);
        Timsort s2 = new Timsort(list2, 3);
        s2.createRuns();

        System.out.println("\n----------------------");
        System.out.println("\nPrinting Runs for List 2 (size is " + list2.size() + ")....");
        result = s2.printRuns();
        System.out.println(result);

        System.out.println("\nPrinting List 2 from Stack.......");
        result = s2.printStack();
        System.out.println(result);

        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(22);
        list3.add(12);
        list3.add(15);
        list3.add(24);

        Timsort s3 = new Timsort(list3, 3);
        s3.createRuns();
        System.out.println("\n----------------------");
        System.out.println("\nPrinting Runs for List 3 (size is " + list3.size() + ")....");
        result = s3.printRuns();
        System.out.println(result);

        Random gen = new Random();
        ArrayList<Integer> list4 = new ArrayList<>();
        for (int i = 0; i < 100; i++){
            list4.add((gen.nextInt(101) - 50));
        }
        Timsort s4 = new Timsort(list4, 4);
        s4.createRuns();
        System.out.println("\n----------------------");
        System.out.println("\nPrinting Runs for List 4 (size is " + list4.size() + ")....");
        result = s4.printRuns();
        System.out.println(result);

        System.out.println("\nPrinting List 4 from Stack.......");
        result = s4.printStack();
        System.out.println(result);

    }

}
