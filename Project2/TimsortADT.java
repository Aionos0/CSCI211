import java.util.ArrayList;

public interface TimsortADT {
    public void createRuns();
    public int run(ArrayList<Integer> list, int first, int last);
    public TimsortNumber merge(TimsortNumber tim1, TimsortNumber tim2);
    public void mergeCollapse();
    public void mergeForceCollapse();

}
