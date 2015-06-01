/**
 * Created by jakubnarloch on 05.03.15.
 */
public class CompareVersionNumbers {

    public int compareVersion1(String version1, String version2) {

        if(version1 == null && version2 == null) {
            return 0;
        }

        do {
            if(version1.isEmpty() && version2.isEmpty()) {
                return 0;
            }

            int dotIndex1 = version1.indexOf('.');
            int dotIndex2 = version2.indexOf('.');

            int v1 = getNumber(version1, dotIndex1);
            int v2 = getNumber(version2, dotIndex2);

            if (v1 < v2) {
                return -1;
            } else if (v1 > v2) {
                return 1;
            } else {
                version1 = rest(version1, dotIndex1);
                version2 = rest(version2, dotIndex2);
            }
        }while(true);
    }

    private int getNumber(String version, int dotIndex) {
        if(version.isEmpty()) {
            return 0;
        }
        String value = version;
        if(dotIndex != -1) {
            value = version.substring(0, dotIndex);
        }
        return Integer.parseInt(value);
    }

    private String rest(String version, int dotIndex) {
        if(version.isEmpty()) {
            return version;
        }

        if(dotIndex == -1) {
            return "";
        }
        return version.substring(dotIndex + 1);
    }

    public int compareVersion(String version1, String version2) {

        if(version1 == null && version2 == null) {
            return 0;
        }
        if(version1.isEmpty() && version2.isEmpty()) {
            return 0;
        }

        int v1 = getNumber(version1);
        int v2 = getNumber(version2);

        if(v1 < v2) {
            return -1;
        } else if(v1 > v2) {
            return 1;
        } else {
            return compareVersion(rest(version1), rest(version2));
        }
    }

    private int getNumber(String version) {
        if(version.isEmpty()) {
            return 0;
        }

        int dotIndex = version.indexOf('.');
        String value = version;
        if(dotIndex != -1) {
            value = version.substring(0, dotIndex);
        }
        return Integer.parseInt(value);
    }

    private String rest(String version) {
        if(version.isEmpty()) {
            return version;
        }

        int dotIndex = version.indexOf('.');
        if(dotIndex == -1) {
            return "";
        }
        return version.substring(dotIndex + 1);
    }

    public static void main(String[] args) {

        CompareVersionNumbers cvn = new CompareVersionNumbers();
        System.out.println(cvn.compareVersion("1", "1.1"));
    }
}
