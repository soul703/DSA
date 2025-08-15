import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.*;

public class optimalSummands {
    private static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<Integer>();
        int sum = 0;
        int i = 1;
        while((sum + i)<=n){
            summands.add(i);
            sum+=i;
            i++;
        }
        if(sum!=n) {
            summands.remove(summands.size()-1);
            summands.add(i+(n-sum));
        }
        return summands;
    }
    int algorithm(int[] a) {
        Arrays.sort(a);
        for(int i = 0 ,j = a.length-1;i<j;i++,j--){
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    for(int i = 1 ; i <=a.length;i++){
        a[i-1] += i;
    }
    return Arrays.stream(a).max().orElse(-1);
    }
    void main() {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        List<Integer> summands = optimalSummands(n);
//        System.out.println(summands.size());
//        for (Integer summand : summands) {
//            System.out.print(summand + " ");
//        }

    }
}