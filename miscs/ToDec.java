package miscs;

public class ToDec
{
        public static int ToDex(String hexStr, int factor){
                int result = 0;
                for(int i = 0; i< hexStr.length(); i ++) {
                        char c = hexStr.charAt(i);
                        if( c >= 48 && c<= 57)
                        {
                                // 0 -9
                                result += (c-48)*Math.pow(factor, hexStr.length() - i - 1);

                        }
                        if (c >= 65 && c <= 70)
                        {
                                result += (c-55)*Math.pow(factor, hexStr.length() - i - 1);
                        }
                }
                System.out.println(hexStr+ " --> " + result);
                return  result;
        }

        public static void main(String args[])
        {
                ToDex("4", 16);
                ToDex("A", 16);
                ToDex("1F", 16);
                ToDex("10", 16);
                ToDex("FFF", 16);

                ToDex("10", 2);
                ToDex("1111", 2);
                ToDex("1", 2);
                ToDex("101", 2);
                ToDex("1001", 2);

        }

}