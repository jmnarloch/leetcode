import java.util.Arrays;

/**
 * Created by jakubnarloch on 05.03.15.
 */
public class RemoveElement {

    public int removeElement(int[] A, int elem) {

        int len = 0;
        for(int ind = 0; ind < A.length; ind++) {
            if(A[ind] == elem) {
                continue;
            }
            exch(A, ind, len++);
        }
        return len;
    }

    private void exch(int[] a, int i, int j) {

        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {

        RemoveElement removeElement = new RemoveElement();
        int[] a = {1, 2, 2, 3, 4, 5};
        int len =removeElement.removeElement(a, 2);
        System.out.println(Arrays.toString(a));
        System.out.println(len);
    }
}
