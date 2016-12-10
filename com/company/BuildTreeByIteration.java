package com.company;

public class BuildTreeByIteration
{
     char[] ldr_in;
     char[] dlr_pre;
     char[] lrd_back;

    public TreeNode calBackByPreAndIn(int preIndex, int leftpos, int length, String branch)
    {
        //char x = leftpos< ldr_in.length ? ldr_in[leftpos] : ' ';
        //char y = preIndex < ldr_in.length ? dlr_pre[preIndex] : ' ';
        //System.out.println(branch + " : " + x + " , " + y  + " ,  " + length);

        if(length <= 0)
            return null;

        TreeNode node = new TreeNode();
        node.value = dlr_pre[preIndex];
        int rootIndex = 0;
        for(rootIndex = leftpos;rootIndex < leftpos + length; rootIndex++)
        {
            if(ldr_in[rootIndex] == dlr_pre[preIndex]) {
                break;
            }
        }
        int lenleft = rootIndex - leftpos;
        node.lChild = calBackByPreAndIn(preIndex + 1, leftpos, lenleft, "left");
        int lenright = length - lenleft - 1;
        node.rChild = calBackByPreAndIn(preIndex + lenleft + 1,  rootIndex + 1, lenright, "right");

        System.out.println(dlr_pre[preIndex]);
        return  node;

    }

    public TreeNode calPreByBackAndIn(int backIndex, int rightpos, int length, String branch)
    {
        //get pre oder by back and in order
        char x = rightpos >= 0 ? ldr_in[rightpos] : ' ';
        char y = backIndex >= 0 ? lrd_back[backIndex] : ' ';
        System.out.println(branch + " : " + rightpos + " " + x + " , " + backIndex + " " + y  + " ,  " + length);

        if(length <= 0)
            return null;

        TreeNode node = new TreeNode();
        node.value = lrd_back[backIndex];
        int rootIndex = rightpos;
        for(rootIndex = rightpos;rootIndex > rightpos - length; rootIndex--)
        {
            if(ldr_in[rootIndex] == lrd_back[backIndex]) {
                break;
            }
        }

        System.out.println(lrd_back[backIndex]);
        int lenright =  rightpos - rootIndex;
        int lenleft = length - lenright - 1;
        node.lChild = calPreByBackAndIn(backIndex - lenright - 1,  rootIndex - 1, lenleft, "left");
        node.rChild = calPreByBackAndIn(backIndex - 1, rightpos, lenright, "right");


        return  node;

    }

    public class TreeNode
    {
        char value;
        TreeNode lChild;
        TreeNode rChild;
    }

    public static void main(String[] args) {

        //another test case for cal back by pre and in
        //char[] pre2 = {'A','B','C','D','F','E'};
        //char[] in2 = {'B','A','D','F','C','E'};

        BuildTreeByIteration builder = new BuildTreeByIteration();
        builder.dlr_pre = new char[]{'G', 'D', 'A', 'F', 'E', 'M', 'H', 'Z'};
        builder.ldr_in = new char[]{'A', 'D', 'E', 'F', 'G', 'H', 'M', 'Z'};
        builder.lrd_back = new char[] {'A','E','F','D','H','Z','M','G'};
        int length = builder.ldr_in.length;
        BuildTreeByIteration.TreeNode root1 = builder.calBackByPreAndIn(0, 0, length, "main" );
        BuildTreeByIteration.TreeNode root2 = builder.calPreByBackAndIn(length - 1, length -1, length, "main" );
    }

    }