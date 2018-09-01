package org1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jingbao on 18-1-25.
 */
public class Tree {
    private Tree lift;
    private Tree right;
    private Object data;

    public Tree getLift() {
        return lift;
    }

    public void setLift(Tree lift) {
        this.lift = lift;
    }

    public Tree getRight() {
        return right;
    }

    public void setRight(Tree right) {
        this.right = right;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    public Tree(){}
    public static Tree makeTree(String expression){
        boolean flag=true;
        int after=1;
        int before=0;
        Tree root=new Tree();
        while(flag){
            if(expression.substring(before,after).equals("+")|expression.substring(before,after).equals("-")|expression.
                    substring(before,after).equals("/")|expression.substring(before,after).equals("*")){
                String rootData=expression.substring(before,after);
                root.setData(rootData);
                flag=false;
            }else {
                after=after+1;
                before=before+1;
            }
        }
        //Tree root=new Tree();
       // String rootData=expression.substring(1,2);
        //root.setData(rootData);
        Tree lift=new Tree();
        String liftData=expression.substring(0,before);
        lift.setData(liftData);
        Tree right=new Tree();
        String rightData;
       // System.out.println("/////");
        Matcher m = Pattern.compile("[\\+\\-\\*/]").matcher(expression.substring(after,expression.length()));
        if(m.find()){
            //System.out.println("FIND");
            right=makeTree(expression.substring(after,expression.length()));
            //System.out.println(expression.substring(2,expression.length()));
        }else{
            rightData=expression.substring(after,expression.length());
           // System.out.println(rightData);
            right.setData(rightData);
        }
        root.setLift(lift);
        root.setRight(right);
        return root;
    }
    public static void inorder(Tree root){
        if(root!=null){
            //System.out.println(root.getData());
            if(root.getLift()!=null){
                inorder(root.getLift());
            }
            System.out.print(root.getData());
//            if(root.getData().equals("+")){
//                result=result+Integer.parseInt((String)root.getData());
//            }
            if(root.getRight()!=null){
                inorder(root.getRight());
            }
        }

    }
    public static void inorder(Tree root,Stack stack){
        if(root!=null){
            //System.out.println(root.getData());
            if(root.getLift()!=null){
                inorder(root.getLift(),stack);
            }
            if(root.getData().equals("+")){
                stack.setExpression("+");
            }else if(root.getData().equals("-")){
                stack.setExpression("-");
            }else if(root.getData().equals("*")){
                stack.setExpression("*");
            }else if(root.getData().equals("/")){
                stack.setExpression("/");
            }else{
                stack.setNumber(Integer.parseInt(root.getData().toString()));
            }
            if(root.getRight()!=null){
                inorder(root.getRight(),stack);
            }
        }

    }

    public static int calculation(Stack stack){
        int flag=0;
        int result=0;
        int x_flag=stack.S_flag;
        while (x_flag!=flag){
          if(stack.getExpression()[flag]!=null|stack.getExpression()[flag].equals("")){
              if(stack.getExpression()[flag].equals("*")){
                  result=stack.getNumber()[flag]*stack.getNumber()[flag+1];
                  stack.getNumber()[flag+1]=result;
                  stack.getNumber()[flag]=-1;


//                  stack.getNumber()[flag]=result;
//                  stack.getNumber()[flag+1]=0;
//                  stack.getExpression()[flag]=null;
//                  for(;flag<stack.S_flag-1;flag++){
//                      stack.getExpression()[flag]=stack.getExpression()[flag+1];
//                  }
//                  for(;flag<stack.N_flag-2;flag++){
//                      stack.getNumber()[flag+1]=stack.getNumber()[flag+2];
//                  }
//                  //stack.getExpression()[stack.S_flag-1]=null;
//                  //stack.N_flag--;
//                  //stack.S_flag--;
//                  stack.S_flag=stack.S_flag-1;
//                  stack.N_flag=stack.N_flag-1;

              }
             // System.out.println(stack.getExpression()[flag]);
              if(stack.getExpression()[flag].equals("/")){
                  result=stack.getNumber()[flag]/stack.getNumber()[flag+1];
                  stack.getNumber()[flag+1]=result;
                  stack.getNumber()[flag]=-1;
//                  stack.getNumber()[flag]=result;
//                  stack.getNumber()[flag+1]=0;
//                  stack.getExpression()[flag]=null;
//                  for(;flag<stack.S_flag-1;flag++){
//                      stack.getExpression()[flag]=stack.getExpression()[flag+1];
//                  }
//                  for(;flag<stack.N_flag-2;flag++){
//                      stack.getNumber()[flag+1]=stack.getNumber()[flag+2];
//                  }
//                  //stack.getExpression()[stack.S_flag-1]=null;
//                  //stack.N_flag--;
//                  //stack.S_flag--;
//                  stack.S_flag=stack.S_flag-1;
//                  stack.N_flag=stack.N_flag-1;

              }
              flag=flag+1;
          }
        }
        flag=0;

        while(stack.S_flag!=flag){
            if(stack.getExpression()[flag].equals("+")){
                for(int i=flag;i!=stack.S_flag;i++){
                    if (stack.getNumber()[i+1]!=-1){
                        result=stack.getNumber()[flag]+stack.getNumber()[i+1];
                        stack.getNumber()[flag]=-1;
                        stack.getNumber()[i+1]=result;
                        i=stack.S_flag-1;

                    }else{
                    }
                }
//                result=stack.getNumber()[flag]+stack.getNumber()[flag+1];
//                stack.getNumber()[flag]=0;
//                stack.getNumber()[flag+1]=result;
               // stack.getExpression()[stack.S_flag-1]=null;
                //stack.N_flag--;
                //stack.S_flag--;
                flag=flag+1;
                System.out.println("+++++++++++++");
            }else if(stack.getExpression()[flag].equals("-")){
                for(int i=flag;i!=stack.S_flag;i++){
                    if (stack.getNumber()[i+1]!=-1){
                        result=stack.getNumber()[flag]-stack.getNumber()[i+1];
                        stack.getNumber()[flag]=-1;
                        stack.getNumber()[i+1]=result;
                        i=stack.S_flag-1;

                    }else{
                    }
                }
//                result=stack.getNumber()[flag]-stack.getNumber()[flag+1];
//                stack.getNumber()[flag]=0;
//                stack.getNumber()[flag+1]=result;
                //stack.getExpression()[stack.S_flag-1]=null;
                //stack.N_flag--;
                //stack.S_flag--;
                flag=flag+1;
           }else {
                flag=flag+1;
            }
            //else if(stack.getExpression()[flag].equals("*")){
//                result=stack.getNumber()[flag]*stack.getNumber()[flag+1];
//                stack.getNumber()[flag]=0;
//                stack.getNumber()[flag+1]=result;
//                //stack.getExpression()[stack.S_flag-1]=null;
//                //stack.N_flag--;
//                //stack.S_flag--;
//                flag=flag+1;
//            }else if(stack.getExpression()[flag].equals("/")){
//                result=stack.getNumber()[flag]/stack.getNumber()[flag+1];
//                stack.getNumber()[flag]=0;
//                stack.getNumber()[flag+1]=result;
//                //stack.getExpression()[stack.S_flag-1]=null;
//                //stack.N_flag--;
//                //stack.S_flag--;
//                flag=flag+1;
//            }


        }
        //System.out.println(flag);
        return result;

    }
    public static int test(Stack stack){
        int flag=0;
        int result=0;
        while (stack.S_flag!=flag){
            if(stack.getExpression()[flag].equals("*")){
                result=stack.getNumber()[flag]*stack.getNumber()[flag+1];
                stack.getNumber()[flag]=result;
                stack.getNumber()[flag+1]=0;
                //stack.getExpression()[stack.S_flag-1]=null;
                //stack.N_flag--;
                //stack.S_flag--;
                flag=flag+1;
            }else{
                flag=flag+1;
            }
            if((stack.getExpression()[flag].equals("/"))){
                result=stack.getNumber()[flag]/stack.getNumber()[flag+1];
                stack.getNumber()[flag]=result;
                stack.getNumber()[flag+1]=0;
                //stack.getExpression()[stack.S_flag-1]=null;
                //stack.N_flag--;
                //stack.S_flag--;
                flag=flag+1;

            }else {
                flag=flag+1;

            }


        }
        return  result;

    }



    public static void main(String[] args) {
        Stack stack=new Stack();
        String expression="1*1*2+1*5-5/5-1*5-5+10-2*50/5";
        Tree root=Tree.makeTree(expression);
       //System.out.println(root.data);
       inorder(root,stack);

        System.out.println(calculation(stack));
        //System.out.println(stack.getExpression()[0]);
       //System.out.println(expression.substring(2,7));
    }
}
