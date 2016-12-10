package com.company;

public class BalancedBinaryNode
{
    int value;
    BalancedBinaryNode lChild;
    BalancedBinaryNode rChild;

    int factor;

    public static int height(BalancedBinaryNode node){
        if (node == null) return 0;
        int hl = 1, hr = 1;
        hl += height(node.lChild);
        hr += height(node.rChild);
        return hl > hr ? hl : hr;
    }

    public static int getFactor(BalancedBinaryNode node)
    {
         if (node == null) return 0;
         node.factor = height(node.lChild) - height(node.rChild);
        return node.factor;

    }

    public BalancedBinaryNode addChild(BalancedBinaryNode node){
        if (node.value < value)
        {
            if (lChild == null) lChild = node;
            else {
                lChild = lChild.addChild(node);
            }
        }

        if (node.value > value)
        {
            if (rChild == null) rChild = node;
            else {
                rChild = rChild.addChild(node);
            }
        }
        //BalancedBinaryNode newPeaknode = Balance(this);
        return Balance(this);
    }

    public static BalancedBinaryNode Balance(BalancedBinaryNode node)
    {
        BalancedBinaryNode unbalanced = GetUnbalancedNode(node);
        if (unbalanced == null) return node;

        BalancedBinaryNode newPeakNode = node;
        if(unbalanced.factor == 2 && unbalanced.lChild.factor == 1)
        {
            if (unbalanced.value == node.value) newPeakNode =  unbalanced.lChild;
            rotateRight(unbalanced, unbalanced.lChild);
            return newPeakNode;
        }

        if(unbalanced.factor == -2 && unbalanced.rChild.factor == -1) {
            if (unbalanced.value == node.value) newPeakNode =  unbalanced.rChild;
            rotateLeft(unbalanced, unbalanced.rChild);
            return newPeakNode;
        }

        if(unbalanced.factor == 2 && unbalanced.lChild.factor == -1)
        {
            unbalanced.lChild = rotateLeft(unbalanced.lChild, unbalanced.lChild.rChild);;
            if (unbalanced.value == node.value) newPeakNode =  unbalanced.lChild;
            rotateRight(unbalanced, unbalanced.lChild);
            return newPeakNode;
        }

        if(unbalanced.factor == -2 && unbalanced.rChild.factor == 1) {
            unbalanced.rChild = rotateRight(unbalanced.rChild, unbalanced.rChild.lChild);
            if (unbalanced.value == node.value) newPeakNode =  unbalanced.rChild;
            rotateLeft(unbalanced, unbalanced.rChild);
            return newPeakNode;
        }

        return newPeakNode;
    }

    public static BalancedBinaryNode rotateLeft(BalancedBinaryNode center, BalancedBinaryNode rightnode)
    {
        BalancedBinaryNode temp = center;
        center = rightnode;
        temp.rChild = center.lChild;
        center.lChild = temp;
        return center;

    }

    public static BalancedBinaryNode rotateRight(BalancedBinaryNode center, BalancedBinaryNode leftnode)
    {
        BalancedBinaryNode temp = center;
        center = leftnode;
        temp.lChild = center.rChild;
        center.rChild = temp;
        return center;

    }

    public static BalancedBinaryNode GetUnbalancedNode(BalancedBinaryNode node)
    {
        if (node == null) return null;

        if (Math.abs(getFactor(node)) == 2) return node;

        BalancedBinaryNode unbalancedleft = GetUnbalancedNode(node.lChild);
        if (unbalancedleft != null ) return unbalancedleft;

        BalancedBinaryNode unbalancedright = GetUnbalancedNode(node.rChild);
        if(unbalancedright != null) return unbalancedright;

        return null;
    }

    private static void levelIterate(BalancedBinaryNode node, int level, Queue<BalancedBinaryNode>[] queues)
    {
        if(node == null) return;
        if(BalancedBinaryNode.height(node) == level) {
            if(queues[level-1] == null) queues[level -1] = new Queue<BalancedBinaryNode>();
            queues[level - 1].enqueue(node);
        }
        levelIterate(node.lChild, level -1, queues);
        levelIterate(node.rChild, level -1, queues);
    }

    public static void levelIterate(BalancedBinaryNode node){
        int height = BalancedBinaryNode.height(node);
        Queue<BalancedBinaryNode>[] queues = new Queue[height];
        levelIterate(node, height, queues);
        for(int i = height - 1; i >= 0; i--)
        {
            while(!queues[i].isEmpty()) {
                System.out.print(queues[i].dequeue().value + " ");
            }
            System.out.println();
        }
    }

    //pre traverse, start from root, then left, then right
    public static void dlrIterate(BalancedBinaryNode node)
    {
        if(node == null) return;

        System.out.print(node.value + " ");
        dlrIterate(node.lChild);
        dlrIterate(node.rChild);
    }

    public static void main(String[] args) {
        int[] a = new int[] {9,8,7,6,5,4};
        BalancedBinaryNode root = new BalancedBinaryNode();
        root.value = a[0];
        for(int i = 1; i < a.length; i++)
        {
            BalancedBinaryNode node = new BalancedBinaryNode();
            node.value = a[i];
            root = root.addChild(node);  //root might change because of tree rotate.
        }
        System.out.println("start pre iterate---");
        BalancedBinaryNode.dlrIterate(root);

        System.out.println("start level iterate---");
        BalancedBinaryNode.levelIterate(root);

    }

}