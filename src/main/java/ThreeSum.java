import java.util.*;

/**
 *
 */
public class ThreeSum {

    public List<List<Integer>> threeSumN3(int[] num) {

        List<List<Integer>> result = new LinkedList<List<Integer>>();

        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                for (int k = j + 1; k < num.length; k++) {
                    if (num[i] + num[j] + num[k] == 0) {
                        List<Integer> values = new ArrayList<Integer>();
                        values.add(num[i]);
                        values.add(num[j]);
                        values.add(num[k]);
                        Collections.sort(values);
                        result.add(values);
                    }
                }
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum(int[] num) {

        final Set<List<Integer>> result = new HashSet<List<Integer>>();

        // sorts the array
        Arrays.sort(num);

        // iterates over the each of the element in the array
        for (int ind = 0; ind < num.length; ind++) {
            if(ind > 0 && num[ind] == num[ind - 1]) {
                continue;
            }

            partition(num, ind, result);
        }
        return new ArrayList<List<Integer>>(result);
    }

    private void partition(int[] num, int ind, Set<List<Integer>> result) {
        int lo = 0;
        int hi = num.length - 1;

        while (lo < hi) {
            if(lo == ind) {
                lo++;
                continue;
            }
            if(hi == ind) {
                hi--;
                continue;
            }

            final int sum = num[ind] + num[lo] + num[hi];
            if (sum > 0) {
                hi--;
            } else if (sum < 0) {
                lo++;
            } else {
                Integer[] values = {num[ind], num[lo], num[hi]};
                Arrays.sort(values);
                if(num[ind] == values[0]) {
                    result.add(Arrays.asList(values));
                }
                lo++;
                hi--;
            }
        }
    }

    public static void main(String[] args) {

        ThreeSum threeSum = new ThreeSum();
//        System.out.println(threeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
//        System.out.println(threeSum.threeSum(new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6}));
        System.out.println(threeSum.threeSum(new int[]{7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6}));
    }
}
