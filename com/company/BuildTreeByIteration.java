package com.company;



public class BuildTreeByIteration
{
     char[] rdl;
     char[] dlr;

    public TreeNode calByDrlAndRdl_length(int preIndex, int leftpos, int length, String branch)
    {
        char x = leftpos< rdl.length ? rdl[leftpos] : ' ';
        char y = preIndex < rdl.length ? dlr[preIndex] : ' ';
        System.out.println(branch + " : " + x + " , " + y  + " ,  " + length);

        if(length <= 0)
            return null;

        TreeNode node = new TreeNode();
        node.value = dlr[preIndex];
        int rootIndex = 0;
        for(rootIndex = leftpos;rootIndex < leftpos + length; rootIndex++)
        {
            if(rdl[rootIndex] == dlr[preIndex]) {
                break;
            }
        }
        int lenleft = rootIndex - leftpos;
        node.lChild = calByDrlAndRdl_length(preIndex + 1, leftpos, lenleft, "left");
        int lenright = length - lenleft - 1;
        node.rChild = calByDrlAndRdl_length(preIndex + lenleft + 1,  rootIndex + 1, lenright, "right");

        System.out.println(dlr[preIndex]);
        return  node;

    }

    public class TreeNode
    {
        char value;
        TreeNode lChild;
        TreeNode rChild;
    }

    public static void main(String[] args) {

        //another test case
        //char[] pre2 = {'A','B','C','D','F','E'};
        //char[] in2 = {'B','A','D','F','C','E'};

        BuildTreeByIteration builder = new BuildTreeByIteration();
        builder.dlr = new char[]{'G', 'D', 'A', 'F', 'E', 'M', 'H', 'Z'};
        builder.rdl = new char[]{'A', 'D', 'E', 'F', 'G', 'H', 'M', 'Z'};
        BuildTreeByIteration.TreeNode root = builder.calByDrlAndRdl_length(0, 0, builder.dlr.length, "main");
    }

    }