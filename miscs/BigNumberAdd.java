package miscs;

/**
 * Created by wangyu on 2016/12/11.
 */
public class BigNumberAdd {
    public static String Add(String a, String b)
    {
        int length = a.length() > b.length() ? a.length() + 1 : b.length() + 1;
        char[] resultChars = new char[length];

        int posA = a.length() - 1;
        int posB = b.length() - 1;
        int posRes = resultChars.length - 1;
        int carry= 0;
        while (posA >= 0 || posB >= 0)
        {

            int x = posA >= 0 ? Character.getNumericValue(a.charAt(posA--)) : 0;
            int y = posB >= 0 ? Character.getNumericValue(b.charAt(posB--)) : 0;

            int remainder = (x + y + carry) % 10;
            resultChars[posRes--] = (char)(remainder + '0');
            carry = (x + y + carry) / 10;
        }

        if (carry == 1)
            resultChars[posRes] = (char)(carry + '0');

        String result = removeLeadingZero(resultChars);

        return result;
    }

    public static String removeLeadingZero(char[] numberChars)
    {
        char[] result = new char[numberChars.length];
        int index = 0;
        boolean start = false;
        for (int i = 0; i < numberChars.length; i++)
        {
            if (numberChars[i] != '0' && numberChars[i] != 0 && start == false)
                start = true;
            if (start)
            {
                result[index++] = numberChars[i];
            }
        }
        //if (index < result.length) result[index] = '\0';
        String s = String.valueOf(result);
        return s.substring(0, index);
    }

    public static void main(String args[]) {
        System.out.println(Add("12345", "7"));
        System.out.println(Add("123", "999"));
        System.out.println(Add("000123", "123"));
        System.out.println(Add("1", "0"));
    }

}
