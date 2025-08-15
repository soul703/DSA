import java.util.Arrays;
import java.util.Scanner;

public class Lab14_2 {
    static int optimalWeight(int W, int[] w) {
        Arrays.sort(w);
        for(int i =0 , j = w.length-1;i<j;i++,j--){
            int temp = w[i];
            w[i] = w[j];
            w[j] = temp;
        }
        int result = 0;
        for (int i = 0; i < w.length; i++) {
            while (result + w[i] <= W) {
                result += w[i];
            }
        }
        return result;
    }
    static int optimalWeight2(int W, int[] w) {
        int n = w.length;
        int[] maxw = new int[W+1];
        Arrays.fill(maxw,-1);
        maxw[0]=0;
        for(int i =1 ; i <= W ;i++){
            for(int weight : w ){
                if(weight>i) continue;
                if (maxw[i - weight] != -1) { // Chỉ tính nếu tồn tại nghiệm trước đó
                    maxw[i] = Math.max(maxw[i], maxw[i - weight] + weight);
                }
            }
        }
        return maxw[W];
    }
    public static void main(String[] args) {
        int[] n = {4,6,11,13,19};
        System.out.println(optimalWeight(1080,n));
        System.out.println(optimalWeight2(1080,n));
    }
}
