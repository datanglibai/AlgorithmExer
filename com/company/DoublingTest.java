package com.company;
import java.util.Random;
import java.lang.*;


public class DoublingTest
{
    public static double timeTrial(int N)
    {  // Time ThreeSum.count() for N random 6-digit ints.
        Random rdm = new Random();
        int MAX = 1000000;
        int[] a = new int[N];
        for (int i = 0; i < N; i++)
            a[i] = rdm.nextInt(MAX);
        //Stopwatch timer = new Stopwatch();

        int cnt = ThreeSumFast.count(a);
        //return timer.elapsedTime();
        return 0;
    }
    public static void main(String[] args)
    {  // Print table of running times.
        for (int N = 250; true; N += N)
        {  // Print time for problem size N.
            double time = timeTrial(N);
            System.out.printf("%7d %5.1f\n", N, time);

        }
    }
}