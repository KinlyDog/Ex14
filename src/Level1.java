public class Level1 {
    static String[] ma = new String[1000];
    static int i = 0;

    static StringBuilder str = new StringBuilder();
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

        String com = command.substring(index);
        int strLen = str.length();

        ma[i] = str.toString();

        int strNum = 0;
        if (n == 2 || n == 3) {
            strNum = Integer.parseInt(com);
        }

        if (reset && (n == 1 || n == 2)) {
            resetHistory();
        }

        switch (n) {
            case 1:
                i++;
                str.append(com);
                break;

            case 2:
                i++;
                if (strNum > strLen) strNum = strLen;

                str.delete(strLen - strNum, strLen);
                break;

            case 3:
                if (strNum >= strLen) return "";

                return String.valueOf(str.charAt(strNum));

            case 4:
                if (i != 0) i--;

                reset = true;

                str.replace(0, str.length(), ma[i]);
                break;

            case 5:
                if (ma[i + 1] != null) i++;

                str.replace(0, str.length(), ma[i]);
                break;

            default:
                return "";
        }

        return str.toString();
    }
}
