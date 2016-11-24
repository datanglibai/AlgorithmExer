package com.company;

public class Fibonacci
{
    public static long SlowF(int N)
    {
        if (N == 0) return 0;
        if (N == 1) return 1;
        return SlowF(N-1) + SlowF(N-2);
    }

    public  static  long FastF(int N)
    {
        int count = 0;
        long f = 0;
        long g = 1;
        while (count < N)
        {
            f=f+g;
            g=f-g;
            count++;
        }
        return f;
    }
    public static void main(String[] args)
    {
        for (int N = 0; N < 10; N++)
            System.out.println(N + " " + FastF(N));
    }
}
