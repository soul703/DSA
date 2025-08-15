import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int mettingRoom(int[] s, int[] e) {
        List<int[]> arr = new ArrayList<>();
        for(int i = 0 ; i < s.length;i++){
            arr.add(new int[]{s[i],e[i]});
        }
        arr.sort(Comparator.comparing(a->a[1]));
        int point = -1;
        int count = 0 ;
        for(int i = 0; i < arr.size();i++){
            if(arr.get(i)[0]>=point){
                count++;
                point = arr.get(i)[1];
            }
        }
        return count;
    }
    public static void measure(Runnable task) {
        long start = System.nanoTime();
        task.run();
        long end = System.nanoTime();
        System.out.println("Thời gian chạy (ms): " + (end - start) / 1_000_000.0);
    }

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);

        }
    }
}