import java.util.Arrays;
import java.util.Scanner;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        int n  = values.length;
        Double[][] temp = new Double[n][3];
        for(int i = 0 ;i< n;i++){
            temp[i][0] =  Double.valueOf(values[i]/weights[i]);
            temp[i][1] = Double.valueOf(values[i]);
            temp[i][2] = Double.valueOf(weights[i]);
        }
        Arrays.sort(temp,(a,b)->Double.compare(b[0],a[0]));
        System.out.println(Arrays.deepToString(temp));
        for(int i = 0 ; i <n ; i++){
            if(capacity <=0) break;
            if(capacity>=temp[i][2]){
                value+= temp[i][1];
                capacity -= temp[i][2];
            }
            else value = temp[i][0]*capacity;
        }

        return value;
    }

     void main() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
} 