public class Level1 {
    //static String tmpStr = "";
    static String[] ma = new String[100];
    static StringBuilder bld = new StringBuilder();
    static int i = 0;
    static boolean flag = false;
    static boolean flag2 = false;

    public static String BastShoe(String command) {
        int n = Character.getNumericValue(command.charAt(0));
        int ind = command.indexOf(" ") + 1;
        String str = command.substring(ind);
        int len = bld.length();

        ma[i] = bld.toString();

        switch (n) {
            case 1:
                if (flag) {
                    ma[0] = ma[i];
                    i = 0;
                    flag = false;
                }

                bld.append(str);

                i++;
                break;

            case 2:
                if (flag) {
                    ma[0] = ma[i];
                    i = 0;
                    flag = false;

                    int t = 1;
                    while (ma[t] != null) {
                        ma[t] = null;
                        t++;
                    }
                }

                int strInt = Integer.parseInt(str);

                if (strInt > bld.length()) {
                    strInt = bld.length();
                }

                int del = bld.length() - strInt;
                bld.delete(len - strInt, len);

                i++;
                break;

            case 3:
                int strInt2 = Integer.parseInt(str);

                i++;
                return String.valueOf(bld.charAt(strInt2));

            case 4:
                if (i != 0) {
                    i--;
                }

                bld.replace(0, bld.length(), ma[i]);
                flag = true;
                break;

            case 5:
                if (ma[i + 1] != null) {
                    i++;
                }

                bld.replace(0, bld.length(), ma[i]);
                break;
        }

        return bld.toString();
    }

}
