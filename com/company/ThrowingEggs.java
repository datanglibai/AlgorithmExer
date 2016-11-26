package com.company;

public class ThrowingEggs{
    public static int brokenF_lgN(int[] a)
    {
        // the data represents the broken status from 1 ~N e.g.
        // [0,0,0,0,0,0,0,1,1,1,1,1]
        int lo  = 0;
        int hi = a.length - 1;
        return binary(a, lo, hi);
    }

    public static int brokenF_lgF(int[] a)
    {
        // the data represents the broken status from 1 ~N e.g.
        // [0,0,0,0,0,0,0,1,1,1,1,1]
        int lo  = 0;
        int hi = a.length - 1;

        while (lo <= hi) {  // Key is in a[lo..hi] or not present.
            if (a[lo] == 0)
            {
                lo = lo == 0 ? 1 : lo * 2;
                if(lo > hi) return binary(a, lo/2, hi);
            }
            else
                return binary(a, lo/2, lo);

        }
        return -1;
    }

    private static int binary(int[] a, int lo, int hi)
    {
        while (lo <= hi)
        {  // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if      ( a[mid] == 1) {
                if(a[mid - 1 ] == 1)
                    hi = mid - 1;
                else
                    return mid;
            }
            else if ( a[mid] == 0) lo = mid + 1;
            else
                return mid;
        }
        return -1;
    }

}