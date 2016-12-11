package com.company;

//root is min, every time remove min that means the left is larger, so it can be used for TOP M problems.

public class MinPQ<Key extends Comparable<Key>>
{
    private Key[] pq;             // heap-ordered complete binary tree, index from 1, 0 is not used.
    private int N = 0;            //    in pq[1..N] with pq[0] unused
    public MinPQ(int maxN)
    {
        pq = (Key[]) new Comparable[maxN+1];
    }
    public boolean isEmpty()
    {
        return N == 0;
    }

    public int size()
    {
        return N;
    }

    public void insert(Key v)
    {
        pq[++N] = v;
        swim(N);
    }

    public Key delMin()
    {
        Key min = pq[1];
        exch(1, N--);
        pq[N+1] = null;
        sink(1);
        return min;
    }

    private boolean less(int i, int j)
    {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j)
    {

        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    private void swim(int k)
    {
        //the children of the node at position k in a heap are at positions 2k and 2k+1.
        while (k > 1 && !less(k/2, k))
        {
            exch(k/2, k);
            k = k/2;
        }
    }

    public static void show(Comparable[] a) {
        System.out.println();
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ",");
        }
        System.out.println();
    }

    private void sink(int k){
        //the children of the node at position k in a heap are at positions 2k and 2k+1.
        while (2*k <= N)
        {
            int j = 2*k;
            if (j < N && !less(j, j+1)) j++; // pick the less one to do exchange since this is a min root heap
            if (less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }
}