import java.util.*;

public class PointCover {

    // Mỗi đoạn phủ biểu diễn bằng lớp Pair đơn giản
    static class Interval {
        double left, right;

        Interval(double left, double right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "[" + left + ", " + right + "]";
        }
    }
    private  List<double[]> pointcover2(double[] x) {
        List<double[]> result = new ArrayList<>();
        int i = 0;
        int n = x.length;
        while (i < n) {
            double l = x[i];
            double r = x[i] + 1.0;
            result.add(new double[]{l,r});
            i++;
            for (int j = i; j < n; j++) {
                if (x[j] < r) i++;
            }
        }
        return result;
    }
    private List<Interval> pointcover(double[] n){
        List<Interval> result = new ArrayList<>();
        int i = 0;
        int size = n.length;
        while (i<size){
            double l = n[i];
            double r = n[i]+1.0;
            result.add(new Interval(l,r));
              // tạo đoạn mới
            i++;

            // bỏ qua các điểm đã được phủ bởi đoạn [l, r]
            while (i < size && n[i] <= r) {
                i++;
            }
        }
        return result;
    }
    void main(){
        double[] points = {0.1, 0.4, 0.8, 1.5, 1.8, 2.3};

        List<Interval> intervals = pointcover(points);
        System.out.println("Các đoạn phủ tối thiểu:");
        for (Interval interval : intervals) {
            System.out.println(interval);
        }

        System.out.println("Tổng số đoạn: " + intervals.size());
        List<double[]> arr = pointcover2(points);
        for (double[] x : arr){
            System.out.println(Arrays.toString(x));
        }
    }
}