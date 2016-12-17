package com.company;
import java.util.*;

public class SequentialSearchST<Key, Value>
{
    private Node first;
    private int size = 0;
    private class Node
    {  // linked-list node
        // first node in the linked list
        Key key;
        Value val;
        Node next;
        public Node(Key key, Value val, Node next)
        {
            this.key  = key;
            this.val  = val;
            this.next = next;
        } }
    public Value get(Key key)
    {  // Search for key, return associated value.
        for (Node x = first; x != null; x = x.next)
            if (key.equals(x.key))
                return x.val;    // search hit
        return null;           // search miss
    }
    public void put(Key key, Value val)
    {  // Search for key. Update value if found; grow table if new.
        for (Node x = first; x != null; x = x.next)
            if (key.equals(x.key))
            {  x.val = val; return;  }      // Search hit: update val.
        first = new Node(key, val, first); // Search miss: add new node.
        size++;
    }

    public boolean contains(Key key)
    {
        for (Node x = first; x != null; x = x.next)
            if (key.equals(x.key))
                return true;
        return false;
    }

    public Object[] keys()
    {
        ArrayList<Key> results = new ArrayList<Key>();
        for (Node x = first; x != null; x = x.next)
        {
             results.add(x.key);
        }

        return results.toArray();

    }

    public static void testItself()
    {
        int minlen = 2;
        String[] testdata = Main.readAsStringArray("stringdata.txt");
        SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
        for (int i =0; i < testdata.length; i++)
        {
            String word = testdata[i];
            if (word.length() < minlen) continue;  // Ignore short keys.
            if (!st.contains(word)) st.put(word, 1);
            else                    st.put(word, st.get(word) + 1);

        }
        // Find a key with the highest frequency count.
        String max = "";
        st.put(max, 0);
        for (Object word : st.keys())
            if (st.get(String.valueOf(word)) > st.get(max))
                max = String.valueOf(word);
        System.out.println(max + " " + st.get(max));
    }

    public static void main(String[] args) {
       testItself();
    }
}