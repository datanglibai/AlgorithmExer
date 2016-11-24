package com.company;

import java.util.Arrays;
public class ThreeSumFast
{
    public static int count(int[] a)
    {  // Count triples that sum to 0.
        Arrays.sort(a);
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++)
            for (int j = i+1; j < N; j++)
                if ((a[i]+a[j] <=0) && BinarySearch.rank(-a[i]-a[j], a) > j)
                    cnt++;
        return cnt;
    }

}