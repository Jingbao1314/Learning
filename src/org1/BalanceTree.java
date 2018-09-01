package org1;

import java.util.Scanner;

/**
 * Created by jingbao on 18-1-29.
 */
public class BalanceTree {
    private BalanceTree LetfTree;
    private BalanceTree RightTree;
    private int LeftDeep=0;
    private int RightDeep=0;
    private int flag=0;
    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getLeftDeep() {
        return LeftDeep;
    }

    public void setLeftDeep(int leftDeep) {
        LeftDeep = leftDeep;
    }

    public int getRightDeep() {
        return RightDeep;
    }

    public void setRightDeep(int rightDeep) {
        RightDeep = rightDeep;
    }

    public BalanceTree getLetfTree() {
        return LetfTree;
    }

    public void setLetfTree(BalanceTree letfTree) {
        LetfTree = letfTree;
    }

    public BalanceTree getRightTree() {
        return RightTree;
    }

    public void setRightTree(BalanceTree rightTree) {
        RightTree = rightTree;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public static BalanceTree addNode(BalanceTree root,int num){
        System.out.println("输入NULL计为空");
        String flag=new Scanner(System.in).next();
        num=num+1;
        if(flag.equals("NULL")) {
             root= null;
        }else{
            root=new BalanceTree();
            root.setData(flag);
            addNode(root.getLetfTree(),num);
            addNode(root.getRightTree(),num);
        }
        return root;
    }

    public static void main(String[] args) {

    }

}
