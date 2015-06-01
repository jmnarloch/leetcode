import java.util.*;

/**
 * Created by jakubnarloch on 07.04.15.
 */
public class RestoreIPAddresses {

    public List<String> restoreIpAddresses(String s) {

        // input: the string representation of ip address
        // output: the possible ip addresses that can be generated
        // edge cases: s is null, s is empty
        // test cases:
        // assumptions: use extra memory, the input string consist only from digits

        if(s == null || s.length() == 0) {
            return Collections.emptyList();
        }

        final List<String> results = new ArrayList<String>();
        final Deque<String> stack = new LinkedList<String>();
        restoreIpAddresses(s, 0, stack, results);
        return results;
    }

    private void restoreIpAddresses(String digits, int index, Deque<String> stack, List<String> results) {

        if(stack.size() > 4) {
            return;
        }

        if(index == digits.length() && stack.size() == 4) {
            String result = toString(stack);
            results.add(result);
            return;
        }

        for(int len = Math.min(2, digits.length() - 1 - index); len >= 0; len--) {
            int ind = index;
            int ip = 0;
            StringBuilder part = new StringBuilder();
            while(ind <= index + len) {
                ip = 10 * ip + digits.charAt(ind) - '0';
                part.append(digits.charAt(ind));
                ind++;
            }

            if(ip >= 0 && ip <= 255 && (part.charAt(0) != '0' || (part.charAt(0) == '0' && part.length() == 1))) {
                stack.addLast(part.toString());
                restoreIpAddresses(digits, index + len + 1, stack, results);
                stack.removeLast();
            }
        }
    }

    private String toString(Deque<String> stack) {

        StringBuilder builder = new StringBuilder();
        int index = 0;
        for(String val : stack) {
            if(index != 0) {
                builder.append('.');
            }
            builder.append(val);
            index++;
        }
        return builder.toString();
    }

    public static void main(String[] args) {

        RestoreIPAddresses restoreIPAddresses = new RestoreIPAddresses();
        System.out.println(restoreIPAddresses.restoreIpAddresses("25525511135"));
        System.out.println(restoreIPAddresses.restoreIpAddresses("0000"));
        System.out.println(restoreIPAddresses.restoreIpAddresses("010010"));
    }
}
