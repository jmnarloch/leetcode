import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by jakubnarloch on 04.04.15.
 */
public class TwoSumIII {

    // #1 using an array O(1) O(N ^ 2) / O(N)
    // #2 using sorted array O(N) O(N lg N)
    // #3 binary search tree O(lg N) O(N lg N)
    // #4 hash map O(1) O(N)

    private final Map<Integer, Integer> numbers = new HashMap<Integer, Integer>();

    public void add(int number) {
        final int count = numbers.containsKey(number) ? numbers.get(number) : 0;
        numbers.put(number, count + 1);
    }

    public boolean find(int value) {
        for(Map.Entry<Integer, Integer> entry : numbers.entrySet()) {
            final int num = entry.getKey();
            if((num << 1) == value) {
                return numbers.get(num) >= 2;
            } else if(numbers.containsKey(value - num)) {
                return true;
            }
        }
        return false;
    }
}
