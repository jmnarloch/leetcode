/**
 * Created by jakubnarloch on 29.03.15.
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {

        // input: the array of integers - height
        // output: the max area
        // edge cases: height is null, height is empty

        if(height == null || height.length <= 1) {
            return 0;
        }

        int max = 0;
        int lo = 0;
        int hi = height.length - 1;

        while(lo < hi) {

            max = Math.max(max, (hi - lo) * Math.min(height[lo], height[hi]));

            if(height[lo] < height[hi]) {
                lo++;
            } else {
                hi--;
            }
        }
        return max;
    }

    public static void main(String[] args) {

        ContainerWithMostWater container = new ContainerWithMostWater();
        System.out.println(container.maxArea(new int[] {1, 2, 1}));
    }
}
