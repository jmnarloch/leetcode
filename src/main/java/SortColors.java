import java.util.Arrays;

/**
 * Created by jakubnarloch on 24.03.15.
 */
public class SortColors {

    public void sortColors2(int[] A) {

        if(A == null || A.length == 0) {
            return;
        }

        int[] count = new int[3];
        for(int ind = 0; ind < A.length; ind++) {
            count[A[ind]]++;
        }

        int ind = 0;
        int num = 0;
        while(num < count.length) {

            while(count[num] > 0) {
                A[ind++] = num;
                count[num]--;
            }
            num++;
        }
    }

    public void sortColors(int[] A) {

        if(A == null || A.length == 0) {
            return;
        }

        int lt = 0;
        int i = 0;
        int gt = A.length - 1;
        int v = 1;

        while(i <= gt) {

            int cmp = Integer.compare(A[i], v);
            if(cmp < 0) {
                exch(A, i++, lt++);
            } else if(cmp > 0) {
                exch(A, i, gt--);
            } else {
                i++;
            }
        }
    }

    private void exch(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {

        SortColors sort = new SortColors();
//        int[] data = {0, 2, 1, 2, 1, 2, 1};
        int[] data = {1, 0};
        sort.sortColors(data);
        System.out.println(Arrays.toString(data));
    }
}
