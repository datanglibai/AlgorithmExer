package miscs;

public class Permutation
{
    public static void permutation(int[] a, int pos, int n)
    {
        if (pos == n)
        {
            System.out.println();
            for (int i=0; i < n; i++)
            {
                System.out.print(a[i]);
            }
            return;
        }

        for (int j =0 ; j < n; j++)
        {
            if(exists(a, j, pos))
                continue;
            a[pos] = j;
            permutation(a, pos+1, n);
        }



    }
    public static boolean exists(int[] a, int k, int pos)
    {
        for (int i =0 ; i<pos; i ++)
        {
            if (a[i] == k) return true;
        }
        return false;
    }
}