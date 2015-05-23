import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

/**
 *
 */
public class KthLargestElementinanArray {

    public int findKthLargest(int[] nums, int k) {

        final int N = nums.length;
        Arrays.sort(nums);
        return nums[N - k];
    }

    public int findKthLargest2(int[] nums, int k) {

        final PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int val : nums) {
            pq.offer(val);

            if(pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

    public int findKthLargest3(int[] nums, int k) {

        shuffle(nums);
        k = nums.length - k;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            final int j = partition(nums, lo, hi);
            if(j < k) {
                lo = j + 1;
            } else if (j > k) {
                hi = j - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }

    private int partition(int[] a, int lo, int hi) {

        int i = lo;
        int j = hi + 1;
        while(true) {
            while(i < hi && less(a[++i], a[lo]));
            while(j > lo && less(a[lo], a[--j]));
            if(i >= j) {
                break;
            }
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private static void exch(int[] a, int i, int j) {
        final int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private boolean less(int v, int w) {
        return v < w;
    }

    private void shuffle(int a[]) {

        final Random random = new Random();
        for(int ind = 1; ind < a.length; ind++) {
            final int r = random.nextInt(ind + 1);
            exch(a, ind, r);
        }
    }

    public static void main(String[] args) {

        KthLargestElementinanArray largestElementinanArray = new KthLargestElementinanArray();
//        System.out.println(largestElementinanArray.findKthLargest(new int[] {3,2,1,5,6,4}, 2));
//        System.out.println(largestElementinanArray.findKthLargest2(new int[]{3, 2, 1, 5, 6,4}, 2));
//        System.out.println(largestElementinanArray.findKthLargest3(new int[]{3, 2, 1, 5, 6,4}, 2));
        int[] nums = createArr(200000);
        reverse(nums);
        System.out.println(largestElementinanArray.findKthLargest3(nums, nums.length / 2));
    }

    private static void reverse(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while(lo < hi) {
            exch(nums, lo++, hi--);
        }
    }

    private static int[] createArr(int n) {
        final int[] nums = new int[n];
        for(int ind = 1; ind <= n; ind++) {
            nums[ind - 1] = ind;
        }
        return nums;
    }
}
