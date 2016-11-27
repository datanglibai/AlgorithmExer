package  com.company;

import java.util.ArrayList;

public class UnionFind {

    private int[] id;     // access to component id (site indexed)
    private int count;    // number of components

    public UnionFind(int N) {  // Initialize component id array.
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        return id[p];
    }

    public void union(int p, int q) {  // Put p and q into the same component.
        int pID = find(p);
        int qID = find(q);
        // Nothing to do if p and q are already in the same component.
        if (pID == qID) return;
        // Rename p’s component to q’s name.
        for (int i = 0; i < id.length; i++)
            if (id[i] == pID) id[i] = qID;
        count--;
    }

    public static void test() {  // Solve dynamic connectivity problem on StdIn.
        pair[] pairs = generateConnections(20);
        UnionFind uf = new UnionFind(pairs.length);
        for (int i = 0; i < pairs.length; i++)
        {
            int p = pairs[i].x;
            int q = pairs[i].y;
            if (uf.connected( p, q))continue;  // Ignore if connected.
             uf.union(p, q);                    // Combine components
            System.out.println(p + " " + q);       //   and print connection.
        }
        System.out.println(uf.count()+" components");
    }

    public static pair[] generateConnections(int N)
    {
        //random generate N connections for testing.
        return new pair[]{};
    }

    class pair{
        public int x;
        public int y;
        pair(int a, int b){
            x =a;
            y =b;
        }
    }
}



