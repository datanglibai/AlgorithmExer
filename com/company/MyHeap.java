package com.company;

public class MyHeap
{
    //this is my implementation.
    public static void myHeapSort(Comparable[] pq)
    {
        //create heap
        Comparable[] temp = new Comparable[pq.length];
        for(int i = 0; i< temp.length; i ++)
        {
            temp[i] = pq[i];
            swim(temp, i);
        }
        show(temp);

        //sort heap
        int n = temp.length - 1;
        while(n >= 0)
        {
            exch(temp, 0, n--);
            sink(temp, 0, n);
        }
        show(temp);
    }

    private static void sink(Comparable[] pq, int k, int n) {
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && less(pq, j, j+1)) j++;
            if (!less(pq, k, j)) break;
            exch(pq, k, j);
            k = j;
        }
    }

    private static void swim(Comparable[] a, int k)
    {
        while (k >= 0 && less(a, k/2, k))
        {
            exch(a, k/2, k);
            k = k/2;
        }
    }

    private static boolean less(Comparable[] pq, int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private static void exch(Comparable[] pq, int i, int j) {
        Comparable swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }

    // print array to standard output
    public static void show(Comparable[] a) {
        System.out.println();
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ",");
        }
        System.out.println();
    }

}