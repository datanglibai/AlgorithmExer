package com.company;

import java.util.Random;

public class SortCompare
{

    public static double time(String alg, Comparable[] a)
    {
        StopWatch timer = new StopWatch();
        timer.start();
        if (alg.equals("Insertion")) SortGeneral.insertion(a);
        if (alg.equals("Selection")) SortGeneral.selection(a);
       // if (alg.equals("Shell")) Shell.sort(a);
        if (alg.equals("Merge")) SortGeneral.merge(a);
        if (alg.equals("Quick")) SortGeneral.quick(a, 0, a.length - 1);
        //if (alg.equals("Heap")) Heap.sort(a);
        timer.stop();
        return timer.getElapsedTime();
    }


    public static double timeRandomInput(String alg, int N, int T)
    {  // Use alg to sort T random arrays of length N.
        double total = 0.0;
        Double[] a = new Double[N];
        Random rdm = new Random();
        double MAX = 2.0;
        for (int t = 0; t < T; t++)
        {  // Perform one experiment (generate and sort an array).
            for (int i = 0; i < N; i++)
                a[i] = rdm.nextDouble();
            total += time(alg, a);
        }
        return total;
    }

    public static double timeAscendingInput(String alg, int N, int T)
    {  // Use alg to sort T random arrays of length N.
        double total = 0.0;
        Double[] a = new Double[N];

        double initial = 2.0;
        for (int t = 0; t < T; t++)
        {  // Perform one experiment (generate and sort an array).
            for (int i = 0; i < N; i++)
                a[i] = initial + 1.0 * i;
            total += time(alg, a);
        }
        return total;
    }

    public static double timeDescendingInput(String alg, int N, int T)
    {  // Use alg to sort T random arrays of length N.
        double total = 0.0;
        Double[] a = new Double[N];

        double initial = 2000000.0;
        for (int t = 0; t < T; t++)
        {  // Perform one experiment (generate and sort an array).
            for (int i = 0; i < N; i++)
                a[i] = initial - 1.0 * i;
            total += time(alg, a);
        }
        return total;
    }

    public static double timeEqualInput(String alg, int N, int T)
    {  // Use alg to sort T random arrays of length N.
        double total = 0.0;
        Double[] a = new Double[N];

        double initial = 2000.0;
        for (int t = 0; t < T; t++)
        {  // Perform one experiment (generate and sort an array).
            for (int i = 0; i < N; i++)
                a[i] = initial;
            total += time(alg, a);
        }
        return total;
    }

    public static void main(String[] args)
    {
        String alg1 = args[0];
        String alg2 = args[1];
        int N = Integer.parseInt(args[2]);
        int T = Integer.parseInt(args[3]);
        double t1 = timeRandomInput(alg1, N, T); // total for alg1
        double t2 = timeRandomInput(alg2, N, T); // total for alg2
        System.out.printf("For %d random Doubles\n    %s is", N, alg1);
        System.out.printf(" %.1f times faster than %s\n", t2/t1, alg2);
    }
}