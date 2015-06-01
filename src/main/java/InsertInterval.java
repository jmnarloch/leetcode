import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by jakubnarloch on 14.04.15.
 */
public class InsertInterval {

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

        // input: the list of intervals - of size N, the new interval to insert
        // output: the altered list
        // edge cases: intervals is null or empty, new interval is null
        // assumptions: alter/modify the input list, create new one and use extra space?
        // approaches: O(N lg N) where N is intervals size + O(N) space

        if (intervals == null) {
            return null;
        } else if (newInterval == null) {
            return intervals;
        } else if (intervals.size() == 0) {
            return Collections.singletonList(newInterval);
        }

        // guaranties O(1) time access to specific index
        List<Interval> list = new ArrayList<>(intervals);
        final int lo = 0;
        final int hi = list.size() - 1;
        // insertion to be in range <0, N - 1>
        int insertion = binarySearch(intervals, lo, hi, newInterval);

        if (insertion == list.size()) {
            list.add(newInterval);
        } else if (!canMerge(newInterval, list.get(insertion))) {
            list.add(insertion, newInterval);
        } else {
            Interval merged = merge(list, insertion, newInterval);
            int j = insertion + 1;
            while (j < list.size() && canMerge(merged, list.get(j))) {
                merged = merge(list, j, merged);
                j++;
            }

            List<Interval> tmp = new ArrayList<>(list.size());
            for (int ind = 0; ind < insertion; ind++) {
                tmp.add(list.get(ind));
            }
            tmp.add(merged);
            for (int ind = j; ind < list.size(); ind++) {
                tmp.add(list.get(ind));
            }
            list = tmp;
        }

        return list;
    }

    private Interval merge(List<Interval> list, int index, Interval newInterval) {
        Interval inter = list.get(index);

        return new Interval(Math.min(inter.start, newInterval.start), Math.max(inter.end, newInterval.end));
    }

    private boolean canMerge(Interval inter1, Interval inter2) {

        return inter1.end >= inter2.start;
    }

    private int binarySearch(List<Interval> intervals, int lo, int hi, Interval target) {

        while (lo <= hi) {
            final int mid = lo + (hi - lo) / 2;
            final Interval inter = intervals.get(mid);
            if (target.start >= inter.start && target.start <= inter.end) {
                return mid;
            } else if (target.start < inter.start) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public String toString() {
            return "[" + start +
                    ", " + end +
                    ']';
        }
    }

    public static void main(String[] args) {

        List<Interval> ex1 = Arrays.<Interval>asList(new Interval(1, 3), new Interval(6, 9));
        List<Interval> ex2 = Arrays.<Interval>asList(new Interval(1, 2), new Interval(3, 5), new Interval(6, 7),
                new Interval(8, 10), new Interval(12, 16));
        List<Interval> ex3 = Arrays.<Interval>asList(new Interval(1, 5));

        InsertInterval insertInterval = new InsertInterval();
//        System.out.println(insertInterval.insert(ex1, new Interval(2, 5)));
//        System.out.println(insertInterval.insert(ex2, new Interval(4, 9)));
        System.out.println(insertInterval.insert(ex3, new Interval(6, 8)));
        System.out.println(insertInterval.insert(ex3, new Interval(0, 3)));
        System.out.println(insertInterval.insert(ex3, new Interval(0, 0)));

    }
}
