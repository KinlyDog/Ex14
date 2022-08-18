public class Level1 {
    static String[] ma = new String[100];
    static int i = 0;

    static StringBuilder bld = new StringBuilder();
    static boolean flag = false;

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
                // ??? simple, please
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
                flag = true;

                break;

            case 5:
                if (ma[i + 1] != null) {
                    i++;
                }

                bld.replace(0, bld.length(), ma[i]);
                break;

            default:
                return "";
        }

        return bld.toString();
    }

    public static void main(String[] args) {
        BastShoe("9");
        BastShoe("1 Привет");
        BastShoe("1 , Мир!");
        BastShoe("1 ++");
        BastShoe("2 2");
        BastShoe("4");
        BastShoe("4");
        BastShoe("1 *");
        BastShoe("4");
        BastShoe("4");
        BastShoe("4");
        System.out.println(BastShoe("3 6"));
        BastShoe("2 100");
        BastShoe("1 Привет");
        BastShoe("1 , Мир!");
        BastShoe("1 ++");
        BastShoe("4");
        BastShoe("4");
        BastShoe("5");
        BastShoe("4");
        BastShoe("5");
        BastShoe("5");
        BastShoe("5");
        BastShoe("5");
        BastShoe("4");
        BastShoe("4");
        BastShoe("2 2");
        BastShoe("4");
        BastShoe("5");
        BastShoe("5");
        BastShoe("5");
    }
}
