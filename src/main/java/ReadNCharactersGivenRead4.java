/**
 * Created by jakubnarloch on 04.04.15.
 */
public class ReadNCharactersGivenRead4 {

    public int read(char[] buf, int n) {

        int total = 0;
        int read;

//        char[] buffer = new char[4];
//        while((read = read4(buffer)) > 0) {
//            System.arraycopy(buffer, 0, buf, total, read);
//
//            total += read;
//            if(total >= n) {
//                break;
//            }
//        }
        return Math.min(total, n);

    }
}
