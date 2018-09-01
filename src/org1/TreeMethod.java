package org1;

import java.util.Scanner;

/**
 * Created by jingbao on 18-1-30.
 */
public class TreeMethod {
    public static SortTree makeTree(SortTree root){
        System.out.println("是否建立该节点，0=否");
        int flag=new Scanner(System.in).nextInt();
        if(flag==0) {
            System.out.println("已经退出或返回");
            root= null;
        }else{
            root=new SortTree();
            root.setElement(flag);
            System.out.print("开始建立左孩子,请输入数据");
            root.setLeft(makeTree(root.getLeft()));
            System.out.print("开始建立右孩子,请输入数据");
            root.setRight(makeTree(root.getRight()));
        }
        return root;
    }
    public static SortTree insert(SortTree root,int element){
        if(root!=null){
            if(element<root.getElement()){
                if(root.getLeft()==null){
                    SortTree son=new SortTree();
                    son.setElement(element);
                    root.setLeft(son);
                }else{
                    insert(root.getLeft(),element);
                }

            }else if(element>root.getElement()){
                if(root.getRight()==null){
                    SortTree son=new SortTree();
                    son.setElement(element);
                    root.setRight(son);
                }else{
                    insert(root.getRight(),element);
                }

            }else {
                System.out.println("节点以存在");
            }

        }
        return root;


    }

    public static void inorder(SortTree root){
        if(root!=null){
            if(root.getLeft()!=null){
                inorder(root.getLeft());
            }
            System.out.println(root.getElement());
            if(root.getRight()!=null){
                inorder(root.getRight());
            }
        }

    }

    public static SortTree findMin(SortTree root){
        SortTree minTree=null;
        if(root==null){
            return null;
        }else if(root.getLeft()==null){
            return root;

        }
        return findMin(root.getLeft());

    }
    public static SortTree findMax(SortTree root){
        SortTree maxTree=null;
        if(root==null){
            return null;
        }else if(root.getRight()==null){
            return root;

        }
        return findMax(root.getRight());

    }
    public static SortTree remove(SortTree root,int element){
        //boolean result=false;
        if(root==null){
            return root;

        }else if(root.getElement()==element){
            if(root.getLeft()==null&root.getRight()!=null){
                root.setElement(root.getRight().getElement());
                //SortTree son=findMin(root.getRight());
                root.setRight(remove(root.getRight(),root.getRight().getElement()));
                return root;

            }else if(root.getLeft()!=null&root.getRight()==null){
                root.setElement(root.getLeft().getElement());
                //SortTree son=findMin(root.getRight());
                root.setLeft(remove(root.getLeft(),root.getLeft().getElement()));
                return root;

            }else if(root.getLeft()!=null&root.getRight()!=null){
                root.setElement(findMin(root.getRight()).getElement());
                SortTree son=findMin(root.getRight());
                root.setRight(remove(root.getRight(),son.getElement()));
                //son=;
                System.out.println("remove:"+root.getElement());
                return root;

            }else{
                root=null;
                return root;
            }
            //result=true;
        }
        if(root.getElement()>element){
            root.setLeft(remove(root.getLeft(),element));

        }
        if (root.getElement()<element){
            root.setRight(remove(root.getRight(),element));
        }
        return root;

    }

    public static boolean seekNode(SortTree root,int element){
        boolean result=false;
        if(root==null){
            return result;

        }else if(root.getElement()==element){
            result=true;
        }
        if(root.getElement()>element){
            return seekNode(root.getLeft(),element);

        }
        if (root.getElement()<element){
            return seekNode(root.getRight(),element);
        }
        return result;

    }
}
