import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by jakubnarloch on 10.04.15.
 */
public class LargestRectangleinHistogram {

    public int largestRectangleArea(int[] height) {

        if (height == null || height.length == 0) {
            return 0;
        }

        final Deque<Integer> stack = new LinkedList<>();
        int max = 0;
        int ind = 0;
        while(ind < height.length) {
            if(stack.isEmpty() || height[ind] >= height[stack.peek()]) {
                stack.push(ind++);
            } else {
                int h = height[stack.pop()];
                max = Math.max(max, stack.isEmpty() ? ind * h : (ind - stack.peek() - 1) * h);
            }
        }

        while(!stack.isEmpty()) {
            int h = height[stack.pop()];
            max = Math.max(max, stack.isEmpty() ? ind * h : (ind - stack.peek() - 1) * h);
        }
        return max;
    }

    public int largestRectangleArea2(int[] height) {

        // input: the array of heights of the histogram
        // output: the maximum area of the rectangle
        // edge cases: the height is null, the height is empty, the height contains single element
        // assumptions: can the height be negative ?
        // approaches: O(N ^ 2)

        if (height == null || height.length == 0) {
            return 0;
        }

        int max = 0;
        for (int ind = 0; ind < height.length; ind++) {

            int lo = ind - 1;
            int hi = ind + 1;

            while (lo >= 0 && height[lo] >= height[ind]) {
                lo--;
            }
            while (hi < height.length && height[hi] >= height[ind]) {
                hi++;
            }

            final int len = (hi - lo - 1);
            max = Math.max(max, len * height[ind]);
        }
        return max;
    }

    public static void main(String[] args) {

        LargestRectangleinHistogram largestRectangleinHistogram = new LargestRectangleinHistogram();
//        System.out.println(largestRectangleinHistogram.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
//        System.out.println(largestRectangleinHistogram.largestRectangleArea(new int[]{1}));
        System.out.println(largestRectangleinHistogram.largestRectangleArea(new int[]{1, 1, 100, 1, 1}));
    }
}
