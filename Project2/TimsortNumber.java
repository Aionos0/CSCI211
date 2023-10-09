import java.util.ArrayList;

public class TimsortNumber {
    int first;
    int last;
    ArrayList<Integer> list;

    public TimsortNumber(int first, int last, ArrayList<Integer> list) {
        this.first = first;
        this.last = last;
        this.list = list;

    }
    public int getFirst() {
        return first;
    }
    public void setFirst(int first) {
        this.first = first;
    }
    public int getLast() {
        return last;
    }
    public void setLast(int last) {
        this.last = last;
    }
    public ArrayList<Integer> getList() {
        return list;
    }
    public void setList(ArrayList<Integer> list) {
        this.list = list;
    }

}
