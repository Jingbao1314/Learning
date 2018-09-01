package rbtree;

/**
 * Created by jingbao on 18-5-15.
 */
public class RedBtree {
    private RedBtree fNode;
    private RedBtree liftNode;
    private RedBtree rightNode;
    private static final int clore=1;//red=0;   black=1;
    private int data;
    private int rNodeCount;
    private int lNodeCount;

    public RedBtree getfNode() {
        return fNode;
    }

    public void setfNode(RedBtree fNode) {
        this.fNode = fNode;
    }

    public int getrNodeCount() {
        return rNodeCount;
    }

    public void setrNodeCount(int rNodeCount) {
        this.rNodeCount = rNodeCount;
    }

    public int getlNodeCount() {
        return lNodeCount;
    }

    public void setlNodeCount(int lNodeCount) {
        this.lNodeCount = lNodeCount;
    }

    public RedBtree getLiftNode() {
        return liftNode;
    }

    public void setLiftNode(RedBtree liftNode) {
        this.liftNode = liftNode;
    }

    public RedBtree getRightNode() {
        return rightNode;
    }

    public void setRightNode(RedBtree rightNode) {
        this.rightNode = rightNode;
    }

    public static int getClore() {
        return clore;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
