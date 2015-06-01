import java.util.*;

/**
 * Created by jakubnarloch on 11.04.15.
 */
public class MergeIntervals {

    public List<Interval> merge(List<Interval> intervals) {

        // input: the list of intervals
        // output: the merged list of intervals
        // edge cases: intervals is null, intervals is empty, intervals contains single element
        // approaches: O(N lg N)

        if(intervals == null || intervals.size() == 0) {
            return Collections.emptyList();
        }

        final List<Interval> merged = new ArrayList<>();

        // sorts the intervals
        Collections.sort(intervals, new IntervalComparator());

        int ind = 0;
        Interval interval, curr;

        final Iterator<Interval> iterator = intervals.iterator();
        interval = iterator.next();

        while(iterator.hasNext()) {
            curr = iterator.next();
            if(canMerge(interval, curr)) {
                interval = merge(interval, curr);
            } else {
                merged.add(interval);
                interval = curr;
            }
        }
        merged.add(interval);
        return merged;
    }

    private Interval merge(Interval prev, Interval next) {

        return new Interval(Math.min(prev.start, next.start), Math.max(prev.end, next.end));
    }

    private boolean canMerge(Interval prev, Interval next) {
        return prev.end >= next.start;
    }

    private class IntervalComparator implements Comparator<Interval> {

        @Override
        public int compare(Interval i1, Interval i2) {
            return Integer.compare(i1.start, i2.start);
        }
    }

    static class Interval {
             int start;
             int end;
             Interval() { start = 0; end = 0; }
             Interval(int s, int e) { start = s; end = e; }

        @Override
        public String toString() {
            return "[" + start +
                    ", " + end +
                    ']';
        }
    }

    public static void main(String[] args) {

        List<Interval> intervals = Arrays.asList(
                new Interval(1, 3),
                new Interval(2, 6),
                new Interval(8, 10),
                new Interval(15, 18)
        );

        MergeIntervals merge = new MergeIntervals();
        System.out.println(merge.merge(intervals));
    }
}
