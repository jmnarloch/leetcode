/**
 * Created by jakubnarloch on 05.03.15.
 */
public class MajorityElement {

    public int majorityElement(int[] num) {

        // input: the array A of integers N: N >= 0
        // output: the leader
        // assumptions: the array integers will be non-negative
        // edges cases: A is null, A is empty, A has one element, A does not have a leader

        int candidate = num[0];
        int occurrences = 1;

        for(int ind = 1; ind < num.length; ind++) {

            if(num[ind] == candidate) {
                occurrences++;
            } else {
                occurrences--;
            }

            if(occurrences == 0) {
                candidate = num[ind];
                occurrences = 1;
            }
        }

        int count = 0;
        for(int ind = 0; ind < num.length; ind++) {
            if(num[ind] == candidate) {
                count++;
            }
        }

        if(2 * count <= num.length) {
            // this is an error situation - there is no leader
        }

        return candidate;
    }

    public static void main(String[] args) {

    }
}
