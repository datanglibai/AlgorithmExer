package miscs;

public class DecToHex{

    public static String transform (int number)
    {
        if (number == 0) return "0";
        String[] remainders = new String[]{"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
        String result = "";
        while(number > 0)
        {
            result = remainders[number % 16] + result;
            number = number / 16;
        }
        System.out.println(result);
        return result;

    }

    public static void main(String args[])
    {
        transform(16);
        transform(256);
        transform(10);
        transform(23); //17
    }
}