package org1;

/**
 * Created by jingbao on 18-1-26.
 */
public class Stack {
    private int[] number=new int[100];
    private String[] expression=new String[100];
    public static int N_flag=0;
    public static int S_flag=0;

    public int[] getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number[N_flag]=number;
        N_flag++;

    }

    public String[] getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression[S_flag] = expression;
        S_flag++;
    }
}
