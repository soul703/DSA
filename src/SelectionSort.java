import java.util.Arrays;

public class SelectionSort {
    private int[] selectionSort(int[] n) {
        if (n.length <= 1) return n;

        for (int i = 0; i <= n.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n.length; j++) {
                if (n[j] < n[min]) min = j;
            }
            if (min != i) {
                int temp = n[i];
                n[i] = n[min];
                n[min] = temp;
            }
        }
        return n;
    }

    private int[] selectionSortOptimized(int[] n) {
        int left = 0, right = n.length - 1;
        while (left < right) {
            int minIndex = left;
            int maxIndex = right;

            for (int i = left; i <= right; i++) {
                if (n[i] < n[minIndex]) minIndex = i;
                if (n[i] > n[maxIndex]) maxIndex = i;
            }

            // Đưa min ra đầu
            int temp = n[left];
            n[left] = n[minIndex];
            n[minIndex] = temp;

            // Nếu maxIndex bị ảnh hưởng do đổi min thì cập nhật lại
            if (maxIndex == left) maxIndex = minIndex;

            // Đưa max ra cuối
            temp = n[right];
            n[right] = n[maxIndex];
            n[maxIndex] = temp;

            left++;
            right--;
        }
        return n;
    }

    public class MergeSort {
        public static void mergeSort(int[] arr, int left, int right) {
            if (left < right) {
                int mid = (left + right) / 2;

                // Sắp xếp nửa trái
                mergeSort(arr, left, mid);
                // Sắp xếp nửa phải
                mergeSort(arr, mid + 1, right);

                // Trộn hai nửa
                merge(arr, left, mid, right);
                System.out.println("Sau khi trộn [" + left + ", " + right + "]: "
                        + Arrays.toString(Arrays.copyOfRange(arr, left, right + 1)));
            }
        }

        private static void merge(int[] arr, int left, int mid, int right) {
            // Tạo mảng tạm
            int n1 = mid - left + 1;
            int n2 = right - mid;
            int[] L = new int[n1];
            int[] R = new int[n2];

            for (int i = 0; i < n1; i++) L[i] = arr[left + i];
            for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];
            System.out.println(Arrays.toString(L));
            System.out.println(Arrays.toString(R));
            // Trộn
            int i = 0, j = 0, k = left;
            while (i < n1 && j < n2) {
                if (L[i] <= R[j]) {
                    arr[k++] = L[i++];
                } else {
                    arr[k++] = R[j++];
                }
            }

            // Sao chép phần còn lại
            while (i < n1) arr[k++] = L[i++];
            while (j < n2) arr[k++] = R[j++];
        }

    }
    private static void radixSort(int[] arr){
        int max = Arrays.stream(arr).max().orElse(-1);
        if(max == -1) return;
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
            System.out.println("Sau khi sắp xếp theo exp=" + exp + ": " + Arrays.toString(arr));
        }

    }
    private static void countingSort(int[] arr , int exp){
        int[] output = new int[arr.length];
        int[] count = new int[10];
        for(int i = 0 ; i < arr.length; i++){
            int n = (arr[i]/exp)%10;
            count[n]++;
        }
        for(int i = 1;i < 10 ; i++){
            count[i]+=count[i-1];
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        // Sao chép về arr
        System.arraycopy(output, 0, arr, 0, arr.length);
    }
private static void bubleSort(int[] arr){
        for(int i = 0 ; i < arr.length-1;i++){
            boolean sotr = false;
            for(int j = 0;j<arr.length-1;j++ ){
                if(arr[j]>arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] =temp;
                    sotr = true;
                }
            }
            if(!sotr) break;
        }
}
private void insertSort(int[] arr){
        for(int i = 1; i < arr.length;i++){
            int a =arr[i];
            int index = i;
            while (index>0 && arr[index-1]>a){
                arr[index] =arr[index-1];
                index--;
            }
            arr[index] =a;
        }
}
    void main() {
        int[] n = {30, 51, 121, 81, 53, 84, 37};
//        int[] m = selectionSort(n);
//        System.out.println(Arrays.toString(m));
//        System.out.println(Arrays.toString(selectionSortOptimized(n)));

        System.out.println(Arrays.toString(n));
//        radixSort(n);
   //     bubleSort(n);
        insertSort(n);
        System.out.println(Arrays.toString(n));
    }
}
