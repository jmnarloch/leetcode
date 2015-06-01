/**
 * Created by jakubnarloch on 12.03.15.
 */
public class ClimbingStairs {

    public int climbStairs(int n) {

        if(n <= 2) {
            return n;
        }

        int prev = 1;
        int curr = 2;
        for(int k = 3; k <= n; k++) {
            int next = curr + prev;
            prev = curr;
            curr = next;
        }
        return curr;
    }

    public static void main(String[] args) {

        ClimbingStairs climbingStairs = new ClimbingStairs();

        System.out.println(climbingStairs.climbStairs(1));
        System.out.println(climbingStairs.climbStairs(2));
        System.out.println(climbingStairs.climbStairs(3));
        System.out.println(climbingStairs.climbStairs(4));
        System.out.println(climbingStairs.climbStairs(5));
    }
}
