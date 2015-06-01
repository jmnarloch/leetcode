import java.util.Arrays;

/**
 * Created by jakubnarloch on 07.04.15.
 */
public class MaxPointsonaLine2 {

    private static final double EPS = 1E-4;

    public int maxPoints(Point[] points) {

        // input: the array of points
        // output: the max number of colinear points
        // edge cases: the points is null, the points is empty, the points contain only one element
        // test cases: there are no colinear points, random points, points create the horizontal line,
        //             all points are colinear, random input
        // assumptions: can use extra memory, points will not contain nulls

        if (points == null || points.length == 0) {
            return 0;
        } else if (points.length == 1) {
            return 1;
        }

        final double[] slopes = new double[points.length];
        int max = 0;

        for (Point point : points) {

            for (int ind = 0; ind < points.length; ind++) {
                slopes[ind] = slope(point, points[ind]);
            }

            Arrays.sort(slopes);

            int ind = 1;
            int dup = 1;

            while (ind < slopes.length && slopes[ind] == Double.NEGATIVE_INFINITY) {
                ind++;
                dup++;
            }
            max = Math.max(max, dup);
            int comp = ind - 1;
            while (ind < slopes.length) {
                while (ind < slopes.length && compare(slopes[ind], slopes[comp])) {
                    ind++;
                }
                max = Math.max(max, ind - comp + dup);

                if(Double.isFinite(slopes[comp])) {
                    comp = binarySearch(slopes, comp, ind - 1, slopes[comp] + EPS);
                } else {
                    comp++;
                }
                ind = comp + 1;
            }
        }
        return max;
    }

    private int binarySearch(double[] data, int lo, int hi, double key) {

        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(data[mid] == key) {
                return mid;
            } else if(data[mid] < key) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }

    private boolean compare(double s1, double s2) {
        return Math.abs(s1 - s2) < EPS || (s1 == s2);
    }

    private double slope(Point that, Point other) {

        if (equals(that, other)) {

            return Double.NEGATIVE_INFINITY;
        } else if (other.x == that.x) {

            return Double.POSITIVE_INFINITY;
        } else {
            return (other.y - that.y) / (double) (other.x - that.x);
        }
    }

    private boolean equals(Point that, Point other) {

        return that.y == other.y && that.x == other.x;
    }

    static class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    public static void main(String[] args) {

//        Point[] points = new Point[] {
//                new Point(0, 0),
//                new Point(-1, -1),
//                new Point(2, 2),
//        };

        Point[] points = new Point[]{
                new Point(4, 0),
                new Point(4, 1),
                new Point(4, 5),
        };

//        Point[] points = new Point[] {
//                new Point(0, 0),
//                new Point(0, 0)
//        };

//        Point[] points = new Point[]{
//                new Point(1, 1),
//                new Point(1, 1),
//                new Point(2, 2),
//                new Point(2, 2)
//        };

//        Point[] points = new Point[] {
//                new Point(0, 0),
//                new Point(0, 0),
//                new Point(1, 1),
//        };

        MaxPointsonaLine2 maxPoints = new MaxPointsonaLine2();
        System.out.println(maxPoints.maxPoints(points));
    }
}
