package com.company;

public class TopM
{

    public static void main(String[] args)
    {  // Print the top M lines in the input stream.
        Integer[] data = new Integer[]{6,1,8,2,9,12,56,78,13,5,20};
        int M = data.length;
        MinPQ<Integer> pq = new MinPQ<Integer>(M+1);

        for(int i = 0; i < M; i++)
        {  // Create an entry from the next line and put on the PQ.
            pq.insert(data[i]);
            if (pq.size() > M)
                pq.delMin();     // Remove minimum if M+1 entries on the PQ.
        }  // Top M entries are on the PQ.
        Stack<Integer> stack = new Stack<Integer>();
        while (!pq.isEmpty()) stack.push(pq.delMin());
        for (Integer t : stack) System.out.println(t);
    }
}