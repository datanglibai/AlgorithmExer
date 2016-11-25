package com.company;

public class BinarySearch
{
    public static int rank(int key, int[] a)
    {  // Array must be sorted.
        int lo  = 0;
        int hi = a.length - 1;
        while (lo <= hi)
        {  // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if      (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else                   return mid;
        }
        return -1; }

    public static int recursiveRank(int key, int[] a)
    {
        return indexOf(key, a, 0, a.length - 1);
    }

    private static int indexOf(int key, int[] a, int lo, int hi)
    {
        if (lo > hi) return -1;
        int mid = lo +(hi - lo) /2;
        if (key < a[mid]) return indexOf(key, a, lo, mid - 1);
        else if (key > a[mid]) return indexOf(key, a, mid + 1, hi);
        else return mid;
    }
}