public class Level1 {
    static String[] ma = new String[1000];
    static int i = 0;

    static StringBuilder bld = new StringBuilder();
    static boolean reset = false;

    public static void resetHistory() {
        ma[0] = ma[i];
        i = 0;
        reset = false;

        int t = 1;
        while (ma[t] != null) {
            ma[t] = null;
            t++;
        }
    }

    public static String BastShoe(String command) {
        int n = Character.getNumericValue(command.charAt(0));
        int index = command.indexOf(" ") + 1;

        String str = command.substring(index);
        int strLen = bld.length();

        ma[i] = bld.toString();

        int strNum = 0;
        if (n == 2 || n == 3) {
            strNum = Integer.parseInt(str);
        }

        if (reset && (n == 1 || n == 2)) {
            resetHistory();
        }

        switch (n) {
            case 1:
                bld.append(str);
                i++;
                break;

            case 2:
                if (strNum > strLen) {
                    strNum = strLen;
                }

                bld.delete(strLen - strNum, strLen);
                i++;
                break;

            case 3:
                if (strNum >= strLen) return "";

                return String.valueOf(bld.charAt(strNum));

            case 4:
                if (i != 0) i--;

                bld.replace(0, bld.length(), ma[i]);
                reset = true;
                break;

            case 5:
                if (ma[i + 1] != null) i++;

                bld.replace(0, bld.length(), ma[i]);
                break;

            default:
                return "";
        }

        return bld.toString();
    }
}
