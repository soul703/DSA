
import java.util.*;
import java.util.stream.Collectors;

public class CoveringSegments {

    private static int[] optimalPoints(Segment[] segments) {
        Arrays.sort(segments,Comparator.comparing(segment -> segment.end));

        List<Integer> points = new ArrayList<>();
        int lastPoint = -1;

        for (Segment s : segments) {
            if (lastPoint < s.start || lastPoint > s.end) {
                lastPoint = s.end;
                points.add(lastPoint);
            }
        }
        return points.stream().mapToInt(Integer::intValue).toArray();

        }

    private static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
 void main() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        int[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}
