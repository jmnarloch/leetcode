import java.util.*;

/**
 * Created by jakubnarloch on 22.03.15.
 */
public class RepeatedDNASequences {

    public List<String> findRepeatedDnaSequences(String s) {

        if(s == null || s.isEmpty() || s.length() < 10) {
            return Collections.emptyList();
        }

        final List<String> results = new ArrayList<String>();
        final Set<Integer> hashes = new HashSet<Integer>(s.length());

        for(int ind = 0; ind < s.length() - 10; ind++) {

            final int hash = hashCode(s, ind, ind + 10);
            if(hashes.contains(hash)) {
                results.add(s.substring(ind, ind + 10));
            } else {
                hashes.add(hash);
            }
        }
        return results;
    }

    private int hashCode(String s, int lo, int hi) {

        int result = 0;
        for (int ind = lo; ind < hi; ind++) {
            int code = 0;
            switch (s.charAt(ind)) {
                case 'A':
                    code = 0;
                    break;
                case 'B':
                    code = 1;
                    break;
                case 'C':
                    code = 2;
                    break;
                case 'D':
                    code = 3;
                    break;
            }
            result |= code;
            result <<= 2;
        }
        return result;
    }

    public List<String> findRepeatedDnaSequences2(String s) {

        if(s == null || s.isEmpty() || s.length() < 10) {
            return Collections.emptyList();
        }

        final List<String> result = new ArrayList<String>();
        Set<String> subStrings = new HashSet<String>();

        // finds the duplicates
        for(int ind = 0; ind < s.length() - 10; ind++) {
            String sub = s.substring(ind, ind + 10);
            if(subStrings.contains(sub)) {
                result.add(sub);
            } else {
                subStrings.add(sub);
            }
        }
        return result;
    }

    public List<String> findRepeatedDnaSequences3(String s) {

        if(s == null || s.isEmpty() || s.length() < 10) {
            return Collections.emptyList();
        }

        List<String> result = new ArrayList<String>();

        String[] subStrings = new String[s.length() - 10];
        for(int ind = 0; ind < s.length() - 10; ind++) {
            subStrings[ind] = s.substring(ind, ind + 10);
        }

        Arrays.sort(subStrings);

        // finds the duplicates
        int ind = 1;
        while(ind < subStrings.length) {

            if(subStrings[ind].equals(subStrings[ind - 1])) {
                result.add(subStrings[ind]);

                while(ind < subStrings.length - 1
                        && subStrings[ind + 1].equals(subStrings[ind])) {
                    ind++;
                }
            }
            ind++;
        }
        return result;
    }

    public static void main(String[] args) {

        RepeatedDNASequences dna = new RepeatedDNASequences();
        System.out.println(dna.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }
}
