import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by jakubnarloch on 10.04.15.
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {

        // input: the integer - the number of parentheses
        // output: the list of the combinations
        // edge cases: the n is non-positive
        // examples: 1 - (), 2 - [(()), ()()]

        if (n <= 0) {
            return Collections.emptyList();
        }

        List<String> result = new ArrayList<>();
        List<Integer> diffs = new ArrayList<>();

        result.add("");
        diffs.add(0);

        for (int i = 0; i < 2 * n; i++) {
            final List<String> combinations = new ArrayList<>();
            final List<Integer> combinationsDiff = new ArrayList<>();

            for (int j = 0; j < result.size(); j++) {
                final String comb = result.get(j);
                final int diff = diffs.get(j);

                if(i < 2 * n - 1) {
                    combinations.add(comb + "(");
                    combinationsDiff.add(diff + 1);
                }

                if(diff > 0 && i < 2 * n - 1 || diff == 1 && i == 2 * n - 1) {
                    combinations.add(comb + ")");
                    combinationsDiff.add(diff - 1);
                }
            }
            result = new ArrayList<>(combinations);
            diffs = new ArrayList<>(combinationsDiff);
        }

        return result;
    }

    public static void main(String[] args) {

        GenerateParentheses generateParentheses = new GenerateParentheses();
        System.out.println(generateParentheses.generateParenthesis(2));
    }
}
