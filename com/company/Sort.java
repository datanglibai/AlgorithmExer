package com.company;

public class Sort {
    public static void bubble(int[] a)
    {
        boolean swap = false;
        for (int i = 0; i< a.length -1; i++) {
            if( i!=0 && !swap) break;
            for (int j = i; j < a.length; j++) {
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                    swap = true;
                }
            }
        }
    }

    public static void quick(int[] a, int low, int high)
    {
        if(low >= high) return;
        int k = partition(a, low, high);
        quick(a, low, k-1);
        quick(a, k+1, high);
    }

    private static int partition(int[] a, int low, int high)
    {
        //sample: {5,6,7,8,2,3,4,9,1,0};
        int k = a[low];
        while (low < high) {
            while ( a[high] >= k && high > low)
                  high--;
            a[low] = a [high];
            while (a[low] <= k && high > low)
                low++;
            a[high] = a[low];
        }
        a[low] = k;
       return low;
    }


    public static void merge(int[] a)
    {
        for (int i = 0; i< a.length -1; i++)
            for(int j=i; j< a.length; j++)
            {
                if(a[i] > a[j])
                {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
    }

}