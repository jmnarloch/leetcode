import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by jakubnarloch on 06.04.15.
 */
public class GrayCode {

    public List<Integer> grayCode(int n) {

        if(n < 0) {
            return Collections.emptyList();
        }

        final List<Integer> result = new ArrayList<Integer>();
        result.add(0);

        for(int ind = 0; ind < n; ind++) {
            int inc = 1 << ind;

            for(int perm = result.size() - 1; perm >= 0; perm--) {

                result.add(result.get(perm) + inc);
            }
        }
        return result;
    }

    public static void main(String[] args) {

        GrayCode grayCode = new GrayCode();
        System.out.println(grayCode.grayCode(2));
    }
}
