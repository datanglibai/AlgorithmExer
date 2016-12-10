package com.company;

import java.util.*;
import java.io.*;
import miscs.*;

public class Main {

    public static void main(String[] args) {

        //another test case
        //char[] pre2 = {'A','B','C','D','F','E'};
        //char[] in2 = {'B','A','D','F','C','E'};

        BuildTreeByIteration builder = new BuildTreeByIteration();
        builder.dlr_pre = new char[] {'G','D','A','F','E','M','H','Z'};
        builder.ldr_in = new char[] {'A','D','E','F','G','H','M','Z'};
        builder.lrd_back = new char[] {'A','E','F','D','H','Z','M','G'};
        int length = builder.ldr_in.length;
        BuildTreeByIteration.TreeNode root1 = builder.calBackByPreAndIn(0, 0, length, "main" );
        BuildTreeByIteration.TreeNode root2 = builder.calPreByBackAndIn(length - 1, length -1, length, "main" );



        //int[] data = new int[5];
        //Permutation.permutation(data, 0, 5);
        //testHeapSort();

        //DecToHex.transform(16);
        //DecToHex.transform(256);
        // DecToHex.transform(10);
        //DecToHex.transform(23); //F7

        //testBinaryNode();
        //sortcompare(new String[]{"Insertion", "Selection", "50", "100"});
        //doubleTesting();

        //testSelectionSort();

        //int[] brokenEggs = new int[]{0,0,0,0,0,0,0,0,1,1,1,1,1,1};
        //System.out.println(ThrowingEggs.brokenF_lgN(brokenEggs));
        //System.out.println(ThrowingEggs.brokenF_lgF(brokenEggs));
        //Comparable<Integer>[] data = new Integer[]{5,6,7,8,2,3,4,9,1,0,15};
        //SortGeneral.merge(data);
        //SortGeneral.show(data);
        //Sort.bubble(data);
        //for(int i = 0; i< data.length; i++)
        //System.out.println(data[i]);

        //int[] a = new int[]{1,2,3,4,5,6,0,-1,-2,-3,-4,-5,-6,-7,-8,-9,-10,-11};
        //System.out.println(ThreeSumFast.count(a));

         //Josephus jp = new Josephus();

        //jp.josephus(data, 3);

        //readAsArray("data.txt");
        //System.out.println(Main.class.getClassLoader().getResource("data.txt"));

        //Fibonacci.main(new String[]{});
        //System.out.println(binomial(10,8,0.2));

        //System.out.println(Evaluator.Evaluate("( 123 + ( ( 1 + 5 ) + ( 6 - 7 ) ) )"));


        //System.out.println(mystery(3,11));
/*        System.out.println("5 is prime? " + isPrime(5));
        System.out.println("8 is prime? " + isPrime(8));


        Scanner in = new Scanner(System.in);
        String inp = in.nextLine();
        int i = in.nextInt();
        System.out.println(inp + " , " + i);*/
    }

    public static void testBinaryNode(){
        System.out.println();
        int[] arr = new int[]{23,54,1,65,9,3,100};
        BinaryNode root = new BinaryNode(arr[0], null, null);
        for(int i=1; i<arr.length; i++){
            root.addChild(arr[i]);
        }
        int height = BinaryNode.height(root);
        System.out.println(height);
        BinaryNode.ldrIterate(root);
        System.out.println();
        BinaryNode.dlrIterate(root);
        System.out.println();
        BinaryNode.lrdIterate(root);
        System.out.println();
        BinaryNode.levelIterate(root);
    }

    public static void testSelectionSort()
    {
        String[] a = readAsStringArray("stringdata.txt");
        SortGeneral.insertion(a);
        assert SortGeneral.isSorted(a);
        SortGeneral.show(a);
    }

    public static void sortcompare(String[] sorts)
    {
        String alg1 = sorts[0];
        String alg2 = sorts[1];
        int N = Integer.parseInt(sorts[2]);
        int T = Integer.parseInt(sorts[3]);
        double t1 = SortCompare.timeRandomInput(alg1, N, T); // total for alg1
        double t2 = SortCompare.timeRandomInput(alg2, N, T); // total for alg2
        System.out.printf("For %d random Doubles\n    %s is", N, alg1);
        System.out.printf(" %.1f times faster than %s\n", t2/t1, alg2);

        t1 = SortCompare.timeAscendingInput(alg1, N, T); // total for alg1
        t2 = SortCompare.timeAscendingInput(alg2, N, T); // total for alg2
        System.out.printf("For %d ascending Doubles\n    %s is", N, alg1);
        System.out.printf(" %.1f times faster than %s\n", t2/t1, alg2);

        t1 = SortCompare.timeDescendingInput(alg1, N, T); // total for alg1
        t2 = SortCompare.timeDescendingInput(alg2, N, T); // total for alg2
        System.out.printf("For %d descending Doubles\n    %s is", N, alg1);
        System.out.printf(" %.1f times faster than %s\n", t2/t1, alg2);

        t1 = SortCompare.timeEqualInput(alg1, N, T); // total for alg1
        t2 = SortCompare.timeEqualInput(alg2, N, T); // total for alg2
        System.out.printf("For %d equal Doubles\n    %s is", N, alg1);
        System.out.printf(" %.1f times faster than %s\n", t2/t1, alg2);

    }

    public static void testHeapSort()
    {
        //String[] a = new String[] {"jhfg","abc","this","is","a","quextion"};
        Integer[] a = new Integer[] {5,7,3,8,9,1,2};
        Heap.show(a);
        Heap.sort(a);
        Heap.show(a);

    }

    public static void doubleTesting()
    {
        for (int N = 50; N < 2147483647; N += N)
        {  // Print time for problem size N.
            double time = DoublingTest.timeTrial(N);
            System.out.printf("%7d %5.1f\n", N, time);

        }
    }

    public static double binomial(int N, int k, double p)
    {
        if ((N == 0) || (k < 0)) return 1.0;
        return (1.0 - p) * binomial(N-1, k, 0) + p*binomial(N-1, k-1, 0);
    }


    public static String number2Binary(int number)
    {
        String s = "";
        for (int n = 56; n > 0; n /= 2)
            s = (n % 2) + s;
        System.out.println(s);
        return s;
    }

    public static int mystery(int a, int b)
    {
        //this actually is a multiply operation.
        if (b == 0)     return 0;
        if (b % 2 == 0) return mystery(a+a, b/2);
        return mystery(a+a, b/2) + a;
    }
    private static boolean isPrime(int n)
    {
        if(n < 2 ) return false;
        for(int i = 2; i*i < n; i++)
        { if (n % i == 0) return false; }
        return true;
    }

    private static void testFibonacci(int N)
    {
        for (int i = 0; i < N; i++)
            System.out.println(N + " " + Fibonacci.FastF(N));

        for (int i = 0; i < N; i++)
            System.out.println(N + " " + Fibonacci.SlowF(N));
    }

    public static ArrayList readAsArray(String filename){
        InputStream input = Main.class.getClassLoader().getResourceAsStream(filename);
        BufferedReader myReader=new BufferedReader(new InputStreamReader(input));
        System.out.println("Read by BufferedReader:");
        ArrayList al = new ArrayList();
        myReader.lines().forEach(i -> al.add(Integer.parseInt(i)));
        System.out.println(al);
        return al;
        /*
        System.out.println("Read by Scanner");
        Scanner dataArray = new Scanner(input);
        ArrayList arr = new ArrayList();

        while(dataArray.hasNextInt())
        {
            arr.add(dataArray.nextInt());
        }
        System.out.println(arr);

        return arr;
        */

    }

    public static String[] readAsStringArray(String filename){
        InputStream input = Main.class.getClassLoader().getResourceAsStream(filename);
        BufferedReader myReader=new BufferedReader(new InputStreamReader(input));
        System.out.println("Read by BufferedReader:");
        Object[] al = myReader.lines().toArray();
        String[] result = new String[al.length];
        for (int i = 0; i< al.length; i++) {
            result[i] = String.valueOf(al[i]);
        }
        return result;
        /*
        System.out.println("Read by Scanner");
        Scanner dataArray = new Scanner(input);
        ArrayList arr = new ArrayList();

        while(dataArray.hasNextInt())
        {
            arr.add(dataArray.nextInt());
        }
        System.out.println(arr);

        return arr;
        */

    }
}
