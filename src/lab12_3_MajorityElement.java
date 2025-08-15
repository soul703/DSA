import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class lab12_3_MajorityElement {
    private static int getMajorityElement(int[] a, int left, int right) {
        if (left == right) {
            return -1;
        }
        if (left + 1 == right) {
            return a[left];
        }
       int mid = left + (right- left)/2;
        int leftMajor = getMajorityElement(a, left, mid);
        int rightMajor = getMajorityElement(a, mid + 1, right);
        if(leftMajor == rightMajor) return leftMajor;
        int leftCount = count(a, leftMajor, left, right);
        int rightCount = count(a, rightMajor, left, right);

        int n = right - left + 1;
        if (leftCount > n / 2) return leftMajor;
        if (rightCount > n / 2) return rightMajor;
        return -1;
    }
    private static int count(int[] a, int num, int left, int right) {
        if (num == -1) return 0;
        int cnt = 0;
        for (int i = left; i <= right; i++) {
            if (a[i] == num) cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (getMajorityElement(a, 0, a.length-1) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
