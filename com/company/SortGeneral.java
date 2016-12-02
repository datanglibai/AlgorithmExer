package com.company;

import java.util.Comparator;

public class SortGeneral
{
    public static void selection(Comparable[] a)
    {  // Sort a[] into increasing order.
        int N = a.length;               // array length
        for (int i = 0; i < N; i++)
        {  // Exchange a[i] with smallest entry in a[i+1...N).
            int min = i;                 // index of minimal entr.
            for (int j = i+1; j < N; j++)
                if (less(a[j], a[min])) min = j;
            if(i != min)
                exch(a, i, min);
        }

    }

    public static void insertion(Comparable[] a)
    {  // Sort a[] into increasing order. better performance for partial sorted array.
        int N = a.length;
        for (int i = 1; i < N; i++)
        {  // Insert a[i] among a[i-1], a[i-2], a[i-3]... ..
            for (int j = i; j > 0 && less(a[j], a[j-1]); j--)
            {
                exch(a, j, j-1);
            }
        }
    }


    public static void bubble(Comparable[] a)
    {
        boolean swap = false;
        for (int i = 0; i< a.length -1; i++) {
            if( i!=0 && !swap) break;
            for (int j = i; j < a.length; j++) {
                if (less(a[j], a[i])) {
                    exch(a, i, j);
                    swap = true;
                }
            }
        }
    }

    public static void shell(Comparable[] a)
    {
        int N = a.length;
        int h = 1;
        while (h < N/3) h = 3*h + 1; // 1, 4, 13, 40, 121, 364, 1093, ...
        while (h >= 1)
        {  // h-sort the array.
            for (int i = h; i < N; i++)
            {  // Insert a[i] among a[i-h], a[i-2*h], a[i-3*h]... .
                for (int j = i; j >= h && less(a[j], a[j-h]); j -= h)
                    exch(a, j, j-h);
            }
            h = h/3; }
    }

    public static void quick(Comparable[] a, int low, int high)
    {
        if(low >= high) return;

        int k = partition(a, low, high);
        quick(a, low, k-1);
        quick(a, k+1, high);
    }

    public static void mergeSort(Comparable[] a, int low, int high)
    {
        //this is not merge yet.
        if(low >= high) return;
        int mid = low + (high - low) / 2;
        mergeSort(a, low, mid);
        mergeSort(a, mid + 1, high);
        merge(a, low, mid, high);
    }

    public static void merge(Comparable[] a, int low, int mid, int high)
    {
        if (lessnequal(a[mid],a[mid + 1]) ) return;

        //copy array
        Comparable[] copy = new Comparable[high - low + 1];
        for (int i = 0; i< copy.length; i ++) {
            copy[i] = a[low + i];
        }

        //get less value from head of 2 sub array.
        int lowofcopy = 0, midofcopy = mid - low, highofcopy = high - low;
        int index1 = lowofcopy;
        int index2 = midofcopy + 1;
        for (int i = low; i <= high; i ++)
        {
            if(index1 <= midofcopy && index2 <= highofcopy){
                    a[i] = less(copy[index2], copy[index1])? copy[index2++] : copy[index1++];
            }
            else if(index1 <= midofcopy && index2 > highofcopy)
            {
                a[i]=copy[index1++];
            }
            else if (index1> midofcopy && index2 <= highofcopy)
            {
                a[i] = copy[index2++];
            }
        }

    }

    private static int partition(Comparable[] a, int low, int high)
    {
        //sample: {5,6,7,8,2,3,4,9,1,0};
        Comparable k = a[low];
        while (low < high) {
            while ( greaternequal(a[high],k) && high > low)
                high--;
            a[low] = a [high];
            while (lessnequal(a[low], k) && high > low)
                low++;
            a[high] = a[low];
        }
        a[low] = k;
        return low;
    }


    private static boolean less(Comparable v, Comparable w)
    {  return v.compareTo(w) < 0;  }

    private static boolean lessnequal(Comparable v, Comparable w)
    {  return v.compareTo(w) <= 0 ;  }

    private static boolean greaternequal(Comparable v, Comparable w)
    {  return v.compareTo(w) >= 0 ;  }

    private static void exch(Comparable[] a, int i, int j)
    {  Comparable t = a[i]; a[i] = a[j]; a[j] = t;  }

    public static void show(Comparable[] a)
    {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a)
    {  // Test whether the array entries are in order.
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i-1]))  return false;
        return true;
    }
}