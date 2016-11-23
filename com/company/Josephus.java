package com.company;


public class Josephus {
    CircularQueue q1 = new CircularQueue();
    CircularQueue q2 = new CircularQueue();
    Queue removedQ = new Queue();
    public void josephus(int[] data, int m)
    {
        //init queue
        for (int i =0 ; i < data.length; i++)
        {
            q1.enqueue(data[i]);
        }

        int step = 1;
        //System.out.println(!((q1.size() == 1 && q2.isEmpty()) || (q2.size() == 1 && q1.isEmpty())));
        while (!(q1.size() == 1 && q2.isEmpty())){
            //if (q1.size() < m ) break;
            if(step == m)
            {
                System.out.println(q1.dequeue());
                //removedQ.enqueue(q1.dequeue());
                step = 1;
            }
            else
            {
                q2.enqueue(q1.dequeue());
                step ++;
            }
            if(q1.isEmpty())
            {
                //exchange queue
                CircularQueue temp = q1;
                q1 = q2;
                q2 = temp;
            }
        }

        System.out.println(q1.dequeue());

    }
}