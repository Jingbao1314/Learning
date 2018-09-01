package rbtree;

/**
 * Created by jingbao on 18-5-15.
 */
public class TreeMothed {
    public static RedBtree add(RedBtree oldTree,RedBtree newTree){
        if(oldTree!=null){
            if(oldTree.getData()>newTree.getData()){
                if(oldTree.getLiftNode()==null){
                    oldTree.setLiftNode(newTree);
                }else {
                    add(oldTree.getLiftNode(),newTree);
                }
            }else {
                if(oldTree.getRightNode()==null){
                    oldTree.setRightNode(newTree);
                }else {
                    add(oldTree.getRightNode(),newTree);
                }

            }
        }
        balance(oldTree);
        return oldTree;

    }
    public static boolean balance(RedBtree redBtree){
        boolean flag=true;
        return flag;
    }

    public static void mark(RedBtree redBtree){
    }
}
