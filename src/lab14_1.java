import java.util.*;

public class lab14_1 {
    private static List<Integer> optimal_sequence(int n) {
        List<Integer> sequence = new ArrayList<Integer>();
        while (n >= 1) {
            sequence.add(n);
            if (n % 3 == 0) {
                n /= 3;
            } else if (n % 2 == 0) {
                n /= 2;
            } else {
                n -= 1;
            }
        }
        Collections.reverse(sequence);
        return sequence;
    }
    private static int optimal_sequence2(int n) {
        int[] arr2 = new int[n+1];
        int[] arr = new int[n+1];
        Arrays.fill(arr,n+1);
        arr[1]= 0;
        arr2[1] = -1;
        for(int i =2 ; i < arr.length;i++) {
            arr[i] = arr[i-1] +1;
            arr2[i] = i-1;
            if (i % 2 == 0 && arr[i / 2] + 1 < arr[i]) {
                arr[i] = arr[i / 2] + 1;
                arr2[i] = i / 2;
            }

            // Trường hợp chia 3
            if (i % 3 == 0 && arr[i / 3] + 1 < arr[i]) {
                arr[i] = arr[i / 3] + 1;
                arr2[i] = i / 3;
            }

        }
        List<Integer>  arr3 = new ArrayList<>();
        int cur = n;
        while (cur !=-1) {
         arr3.add(cur);
         cur =arr2[cur];
        }
        Collections.reverse(arr3);
        arr3.stream().forEach(integer -> System.out.print(integer +" :"));
        return arr[n];
    }

    public static void main(String[] args) {
        System.out.println(optimal_sequence(10));
        System.out.println(optimal_sequence2(10));
    }
}


