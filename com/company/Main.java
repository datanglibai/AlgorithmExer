package com.company;

import java.util.Scanner;
import java.io.InputStream;
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {


        for (int N = 0; N < 50; N++)
            System.out.println(N + " " + Fibonacci.FastF(N));

        for (int N = 0; N < 50; N++)
            System.out.println(N + " " + Fibonacci.SlowF(N));

        //int[] a = new int[]{1,2,3,4,5,6,0,-1,-2,-3,-4,-5,-6,-7,-8,-9,-10,-11};
        //System.out.println(ThreeSumFast.count(a));

         //Josephus jp = new Josephus();
         //int[] data = new int[]{5,6,7,8,2,3,4,9,1,0};
        //jp.josephus(data, 3);
        //readAsArray("data.txt");
        //System.out.println(Main.class.getClassLoader().getResource("data.txt"));

        //System.out.println(Fibonacci.F(10));
        //Fibonacci.main(new String[]{});
        //System.out.println(binomial(10,8,0.2));

        //System.out.println(Evaluator.Evaluate("( 123 + ( ( 1 + 5 ) + ( 6 - 7 ) ) )"));


        //System.out.println(mystery(3,11));
        System.out.println(args.length > 0 ? args[0]:"no args");
        System.out.print("Hello World\n");
        System.out.println("5 is prime? " + isPrime(5));
        System.out.println("8 is prime? " + isPrime(8));

        int[] list = new int[]{4,5,7,9,12,34};
        System.out.println("90 index is " + indexOf(90, list));

        System.out.println("Math lib");
        System.out.printf("Pi is: %.2f", Math.PI);
        System.out.println();
        System.out.println("E is: " + Math.E);
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
        //this actually is a multiply operationn.
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

    public static int indexOf(int key, int[] a)
    {
        return indexOf(key, a, 0, a.length - 1);
    }

    private static void addInt(int i)
    {

    }

    public static int indexOf(int key, int[] a, int lo, int hi)
    {  // Index of key in a[], if present, is not smaller than lo
        //                                  and not larger than hi.

        if (lo > hi) return -1;
        int mid = lo +(hi - lo) /2;
        if (key < a[mid]) return indexOf(key, a, lo, mid - 1);
        else if (key > a[mid]) return indexOf(key, a, mid + 1, hi);
        else return mid;
    }
}
