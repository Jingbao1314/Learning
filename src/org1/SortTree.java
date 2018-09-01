package org1;

/**
 * Created by jingbao on 18-1-30.
 */
public class SortTree {
    private SortTree left;
    private SortTree right;
    private int element;

    public SortTree getLeft() {
        return left;
    }

    public void setLeft(SortTree left) {
        this.left = left;
    }

    public SortTree getRight() {
        return right;
    }

    public void setRight(SortTree right) {
        this.right = right;
    }

    public int getElement() {
        return element;
    }

    public void setElement(int element) {
        this.element = element;
    }
    public SortTree(){}
}
