package com.company;
import java.util.Random;
import java.lang.*;


public class DoublingTest
{
    public static double timeTrial(int N)
    {  // Time ThreeSum.count() for N random 6-digit ints.
        Random rdm = new Random();
        int MAX = 1000000;
        Integer[] a = new Integer[N];
        for (int i = 0; i < N; i++)
            a[i] = rdm.nextInt(MAX);

        StopWatch timer = new StopWatch();
        timer.start();
        //int cnt = ThreeSumFast.count(a);
        SortGeneral.shell(a);
        timer.stop();
        return timer.getElapsedTime();
    }

    public static void main(String[] args)
    {  // Print table of running times.
        for (int N = 10; N < 2147483647; N += N)
        {  // Print time for problem size N.
            double time = timeTrial(N);
            System.out.printf("%7d %5.1f\n", N, time);

        }
    }
}