import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by jakubnarloch on 28.03.15.
 */
public class SimplifyPath {

    public String simplifyPath(String path) {

        // input: the input string
        // output: the simplified path

        if(path == null || path.isEmpty()) {
            return path;
        }

        Deque<String> paths = new LinkedList<String>();
        String[] tokens = path.split("/");

        for(int ind = 0; ind < tokens.length; ind++) {

            if(tokens[ind].isEmpty()
                    || ".".equals(tokens[ind])) {
                // does nothing
            } else if("..".equals(tokens[ind])) {
                if(!paths.isEmpty()) {
                    paths.pollFirst();
                }
            } else {
                paths.addFirst(tokens[ind]);
            }
        }

        StringBuilder result = new StringBuilder("/");
        int ind = 0;
        while(!paths.isEmpty()) {
            if(ind != 0) {
                result.append('/');
            }
            result.append(paths.pollLast());
            ind++;
        }
        return result.toString();
    }

    public static void main(String[] args) {

        SimplifyPath simplifyPath = new SimplifyPath();
        System.out.println(simplifyPath.simplifyPath("/home/"));
        System.out.println(simplifyPath.simplifyPath("/a/./b/../../c/"));
        System.out.println(simplifyPath.simplifyPath("/home/foo/.ssh/authorized_keys/"));
        System.out.println(simplifyPath.simplifyPath("/."));
        System.out.println(simplifyPath.simplifyPath("/..."));
        System.out.println(simplifyPath.simplifyPath("/abc/..."));
    }
}
