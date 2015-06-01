import java.util.Arrays;

/**
 * Created by jakubnarloch on 29.03.15.
 */
public class Candy {

    public int candy(int[] ratings) {

        // input: the array of ratings
        // output: the minimal number of candies
        // edge cases: rating is null, rating is empty

        if(ratings == null || ratings.length == 0) {
            return 0;
        }

        int sum = 0;
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);

        for(int ind = 1; ind < ratings.length; ind++) {
            if(ratings[ind] > ratings[ind - 1]) {
                candies[ind] = candies[ind - 1] + 1;
            }
        }

        for(int ind = ratings.length - 2; ind >= 0; ind--) {
            if(ratings[ind] > ratings[ind + 1] && candies[ind] <= candies[ind + 1]) {
                candies[ind] = candies[ind + 1] + 1;
            }
        }

        for(int ind = 0; ind < ratings.length; ind++) {
            sum += candies[ind];
        }
        return sum;
    }
}
