package com.company;

public class BinaryNode {

    public int value;//current value
    public BinaryNode lChild;//left child
    public BinaryNode rChild;//right child

    public BinaryNode(int value, BinaryNode l, BinaryNode r){
        this.value = value;
        this.lChild = l;
        this.rChild = r;
    }

    public BinaryNode getLChild() {
        return lChild;
    }

    public BinaryNode getRChild() {
        return rChild;
    }

    public int getValue() {
        return value;
    }

    public static int height(BinaryNode node){
        if (node == null) return 0;
        int hl = 1;
        int hr = 1;
        hl += height(node.getLChild());
        hr += height(node.getRChild());
        return hl > hr ? hl : hr;
    }

    //sorted is middle order
    //start from left, then root, then right
    public static void ldrIterate(BinaryNode node){
        if(node == null) return;

        ldrIterate(node.getLChild());
        System.out.print(node.getValue() + " ");
        ldrIterate(node.getRChild());

    }

    //pre traverse, start from root, then left, then right
    public static void dlrIterate(BinaryNode node)
    {
        if(node == null) return;

        System.out.print(node.getValue() + " ");
        dlrIterate(node.getLChild());
        dlrIterate(node.getRChild());
    }

    //back travers, start from left, then right, then root
    public static void lrdIterate(BinaryNode node)
    {
        if(node == null) return;

        lrdIterate(node.getLChild());
        lrdIterate(node.getRChild());
        System.out.print(node.getValue() + " ");

    }
    private static void levelIterate(BinaryNode node, int level, Queue<BinaryNode>[] queues)
    {
        if(node == null) return;
        if(BinaryNode.height(node) == level) {
            if(queues[level-1] == null) queues[level -1] = new Queue<BinaryNode>();
            queues[level - 1].enqueue(node);
        }levelIterate(node.getLChild(), level -1, queues);
        levelIterate(node.getRChild(), level -1, queues);
    }

    public static void levelIterate(BinaryNode node){
        int height = BinaryNode.height(node);
        Queue<BinaryNode>[] queues = new Queue[height];
        levelIterate(node, height, queues);
        for(int i = height - 1; i >= 0; i--)
        {
            while(!queues[i].isEmpty()) {
                System.out.print(queues[i].dequeue().getValue() + " ");
            }
            System.out.println();
        }
    }


    //O( nlog(n) )
    public void addChild(int n){
        if(n<value){
            if(lChild!=null){
                lChild.addChild(n);
            }
            else{
                lChild = new BinaryNode(n, null, null);
            }
        }
        else{
            if(rChild!=null){
                rChild.addChild(n);
            }
            else{
                rChild = new BinaryNode(n, null, null);
            }
        }
    }

    //test case.
    public static void main(String[] args){
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
}