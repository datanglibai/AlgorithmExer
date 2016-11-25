package com.company;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {

        int[] data = new int[]{5,6,7,8,2,3,4,9,1,0};
        Sort.quick(data, 0, data.length-1);
        for(int i = 0; i< data.length; i++)
        System.out.println(data[i]);

        //int[] a = new int[]{1,2,3,4,5,6,0,-1,-2,-3,-4,-5,-6,-7,-8,-9,-10,-11};
        //System.out.println(ThreeSumFast.count(a));

         //Josephus jp = new Josephus();

        //jp.josephus(data, 3);

        //readAsArray("data.txt");
        //System.out.println(Main.class.getClassLoader().getResource("data.txt"));

        //Fibonacci.main(new String[]{});
        //System.out.println(binomial(10,8,0.2));

        //System.out.println(Evaluator.Evaluate("( 123 + ( ( 1 + 5 ) + ( 6 - 7 ) ) )"));


        //System.out.println(mystery(3,11));
        System.out.println("5 is prime? " + isPrime(5));
        System.out.println("8 is prime? " + isPrime(8));


        Scanner in = new Scanner(System.in);
        String inp = in.nextLine();
        int i = in.nextInt();
        System.out.println(inp + " , " + i);
    }

    public static double binomial(int N, int k, double p)
    {
        if ((N == 0) || (k < 0)) return 1.0;
        return (1.0 - p) * binomial(N-1, k, 0) + p*binomial(N-1, k-1, 0);
    }


    public static String number2Binary(int number)
    {
        String s = "";
        for (int n = 56; n > 0; n /= 2)
            s = (n % 2) + s;
        System.out.println(s);
        return s;
    }

    public static int mystery(int a, int b)
    {
        //this actually is a multiply operation.
        if (b == 0)     return 0;
        if (b % 2 == 0) return mystery(a+a, b/2);
        return mystery(a+a, b/2) + a;
    }
    private static boolean isPrime(int n)
    {
        if(n < 2 ) return false;
        for(int i = 2; i*i < n; i++)
        { if (n % i == 0) return false; }
        return true;
    }

    private static void testFibonacci(int N)
    {
        for (int i = 0; i < N; i++)
            System.out.println(N + " " + Fibonacci.FastF(N));

        for (int i = 0; i < N; i++)
            System.out.println(N + " " + Fibonacci.SlowF(N));
    }

    public static ArrayList readAsArray(String filename){
        InputStream input = Main.class.getClassLoader().getResourceAsStream(filename);
        BufferedReader myReader=new BufferedReader(new InputStreamReader(input));
        System.out.println("Read by BufferedReader:");
        ArrayList al = new ArrayList();
        myReader.lines().forEach(i -> al.add(Integer.parseInt(i)));
        System.out.println(al);
        return al;
        /*
        System.out.println("Read by Scanner");
        Scanner dataArray = new Scanner(input);
        ArrayList arr = new ArrayList();

        while(dataArray.hasNextInt())
        {
            arr.add(dataArray.nextInt());
        }
        System.out.println(arr);

        return arr;
        */

    }
}
