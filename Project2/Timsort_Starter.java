import java.util.ArrayList;
import java.util.Stack;

public class Timsort_Starter implements TimsortADT{
    private Stack<TimsortNumber> s;
    private ArrayList<Integer> list;
    private ArrayList<TimsortNumber> runs;
    private int minRun;

    public Timsort_Starter(ArrayList<Integer> a, int minRun) {
        s = new Stack<>();
        this.list = a;
        this.minRun = minRun;
        runs = new ArrayList<>();
    }

    /**
     * Method to identify the number of ascending or descending values
     * If descending, swap to make ascending (first with last, second with second to last, etc
     */
    public int run(ArrayList<Integer> list, int first, int last) throws InvalidTimsortException {
        //TODO: Implement method
        // When determining runCount (in createRuns), you must consider both an ascending and a descending run
        // If the run is ascending, just return the length of the run
        // If the run is descending, first determine the length of the run. Then, convert the run to ascending order
        // and return the length of the run
        // I personally had issues when the list size was 2 or less and had to handle this case separately
        // ERROR CHECKING: If first is greater than last throw an InvalidTimsortException

        return 0;    //DELETE ONCE METHOD IMPLEMENTED
    }


    /**
     * Method to create runs, pushing on stack
     *
     * calls run method
     */
    public void createRuns() {
        //TODO: Implement method
        // 1. Call the run method which returns the number of elements
        // in this run.  If the run WAS descending, it is NOW ascending as it was updated in the "run" method
        // .
        // 2. Now, check that the length of this run (i.e., runCount) meets the minimum length requirement (minRun).
        // But be careful as you will need two checks. The first check was just described.
        // The second check is to verify whether you have enough elements left in your list to even meet the minimum
        // length (i.e., consider (remaining-runCount)). If this is less than the minimum length requirement (minRun),
        // you don't have enough elements left in your list to meet the minimum length requirement.
        // .
        // First check: I didn't meet the minimum length but I do have enough remaining elements to meet this
        // minimum so just binary sort where the "last" argument sent to binarySort is (first+minRun)
        // Second check: I didn't meet the minimum length but I ALSO don't have enough remaining elements to meet
        // this minimum so binary sort where the "last" argument sent to binarySort is (first+remaining)
        // .
        // 3. For the sake of testing purposes, we will have an ArrayList of runs (i.e., "runs") AND a stack of runs (i.e., "s" where each element is a run)
        // The ArrayList allows us to easily check the runs that are in the stack. We also need
        // the stack because it is actually doing all the work of sorting.
        // So, first re-instantiate tempList (you must re-set the list for each run which means re-instantiating each time).
        // Then, add this element to the "runs" ArrayList and push to "s" Stack
        // The tempList to add/push is from "list" - "first" up to "first+runCount"
        // NOTE: first is inclusive, but (first+runCount) is exclusive
        // .
        // 4. mergeCollapse (the method will check if stack greater than 3)
        // .
        // 5. Update "first" and "remaining" values
        // .
        // 6. Done creating sorted runs, including mergeCollapsing along the way
        // Call mergeForceCollapse to merge all runs into just 1 run.

        //Initial variables that may be used
        int first = 0, last=list.size()-1;
        int remaining = last-first+1;
        ArrayList<Integer> tempList;
        int runCount;




    }

    /**
     * Method that collapses stack size to enforce Tim Sort Invariants
     *
     * calls merge and binarySort
     */
    public void mergeCollapse() {
        // TODO: Continue mergeCollapsing until both invariants are met OR the stack is less than 3
        //  Evaluate whether stack violates these two INVARIANTS:
        //         1. If length(z) > length(x) + length(y)
        //         2. If length(y) > length(x)
        //   .
        //  VIOLATION of Invariant 1: length(z) <= length(x) + length(y)
        //          If length(x) <  length(y)  merge x & y
        //          If length(x) >= length(y) merge y & z
        //  VIOLATION of Invariant 2: length(y) <= length(x)
        //        merge x & y

        TimsortNumber x, y, z;



     }
    /**
     * Method that pops remaining stack contents such that there is just 1 element
     * left - the sorted ArrayList
     */
    public void mergeForceCollapse() {
        // TODO: Pop stack twice and merge, pushing back on stack. Continue until stack size is just 1
        //   Your list is sorted!
        while(s.size() > 1) {
            s.push(merge(s.pop(), s.pop()));
        }
    }

    /**
     * Method that merges two lists
     * @param tim1
     * @param tim2
     * @return
     */
    public TimsortNumber merge(TimsortNumber tim1, TimsortNumber tim2) {
        ArrayList<Integer> list1, list2, temp;
        temp = new ArrayList<>();
        int first, last, count1=0, count2=0;

        //Ensure that the size of list1 is smaller than (or equal to) the size of list2
        if(tim1.getList().size() <= tim2.getList().size()){
            list1 = tim1.getList();
            list2 = tim2.getList();
        }
        else{
            list1 = tim2.getList();
            list2 = tim1.getList();

        }

        //Determine the first and last indexes for the original list
        //This information is needed to
        // 1. Correct the original list
        // 2. Create a new TimsortNumber object to return (will be pushed on stack)
        if(tim1.getFirst() < tim2.getFirst()) {
            first = tim1.getFirst();
            last = tim2.getLast();
        }
        else {
            first = tim2.getFirst();
            last = tim1.getLast();
        }

        //Binary search longer list (list2) to determine where smaller list's (list1) first & last elements should be inserted into the new list
        int location1 = binarySearch(list2, list1.get(0), 0, list2.size()-1);
        int location2 = binarySearch(list2, list1.get(list1.size()-1), 0, list2.size()-1);

        //Add longer list's (list2) elements to temp list up to the first location
        for(int i = 0; i < location1; i++) {
            temp.add(list2.get(i));
        }

        //Add shorter list's (list1) first element to temp list
        temp.add(location1, list1.get(0));


        //Already populated list's first element but now have to merge middle of both lists (list1 & list2)
        //Need to define the starting index for both lists.
        //For list 1: count1 should be set to 1 -> accounts for first element already populated in temp list
        //            should traverse up to NEXT TO LAST element -> iterate as long as < size()-1
        //For list 2: count2 set to location1
        //            should traverse up to location2. Everything after location2 should be
        //            populated with list2's remaining elements, if there are any
        count1 = 1;
        count2 = location1;
        while(count1 < (list1.size()-1) && count2 < location2){
            if(list1.get(count1) < list2.get(count2)) {
                temp.add(list1.get(count1++));
            }
            else {
                temp.add(list2.get(count2++));
            }
        }


        //Must check that both lists have been fully traversed. If not, remaining elements must be added to temp list
        //list1 up to its size()-1
        //list2 up to location2
        while(count1 < (list1.size()-1)) {
            temp.add(list1.get(count1++));
        }
        while(count2 < location2) {
            temp.add(list2.get(count2++));
        }

        //Add shorter list's (list1) last element to temp list
        temp.add(list1.get(list1.size()-1));

        //Finish adding the  longer list (list2) elements to temp list -> < list2.size()
        for(int i = location2; i < list2.size(); i++) {
            temp.add(list2.get(i));
        }

        //Finally, replace instance variable "list" with the updated temp list
        //NOTE:  only replace list from index first to last
        int count = 0;
        for(int i = first; i < last; i++) {
            list.set(i, temp.get(count++));
        }

        return new TimsortNumber(first, last, temp);
    }

    /**
     * Method binarySort that uses binary search to determine where target value should be inserted
     * Insertion sort used to insert element
     * @param list
     * @param first
     * @param last
     * @param start
     */
    public void binarySort(ArrayList<Integer> list, int first, int last, int start) {
        int location, target, move;

        while(start < last){
            move = start-1;
            target = list.get(start);

            // find location where target should be inserted
            location = binarySearch(list, target, first, start);

            // Move all elements after location to create space for target
            while (move >= location) {
                list.set((move+1), list.get(move));
                move--;
            }
            list.set((move+1), target);
            start++;
        }
    }

    /**
     * Method binarySearch finds a target value in a list using a decrease-and-conquer approach
     * @param a
     * @param target
     * @param first
     * @param last
     * @return
     */
    public int binarySearch(ArrayList<Integer> a, int target, int first, int last)
    {
        if (last <= first)
            return (target > a.get(first))?  (first + 1): first;

        int mid = (first + last)/2;

        if(target == a.get(mid))
            return mid+1;

        if(target > a.get(mid))
            return binarySearch(a, target, mid+1, last);
        return binarySearch(a, target, first, mid-1);
    }

    /**
     * Method prints values for one run
     * @param list
     * @param first
     * @param last
     * @return
     */
    public String printRange(ArrayList<Integer> list, int first, int last) {
        String output = "";
        while(first < last) {
            output += list.get(first++) + " ";
        }
        return output;
    }

    /**
     * Method that prints "runs" ArrayList
     * @return
     */
    public String printRuns() {
        String output = "";
        for(int i = 0; i < runs.size(); i++) {
            //output += "Run " + i + ":  ";
            for(int j = 0; j < runs.get(i).getList().size(); j++) {
                output += runs.get(i).getList().get(j) + " ";
            }
            //output += "(first = " + runs.get(i).getFirst() + " ; last = " + runs.get(i).getLast() + ")";
            output += "\n";
        }
        return output;
    }

    /**
     * Method that prints the contents of the stack, preserving the original order of the stack
     * @return
     */
    public String printStack() {
        String output = "";
        TimsortNumber temp;
        Stack<TimsortNumber> tempStack = new Stack<>();
        while (!s.isEmpty()) {
            temp = s.pop();
            output += printRange(temp.getList(), 0, temp.getList().size()) + "\n";
            tempStack.push(temp);
        }
        //Return contents to stack
        while(!tempStack.isEmpty()) {
            s.push(tempStack.pop());
        }
        return output;
    }

    /**
     * Method used to test mergeCollapse and mergeForceCollapse
     * @param t
     */
    public void pushStack(TimsortNumber t) {
        s.push(t);
    }
}
