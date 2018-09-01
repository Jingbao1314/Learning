package dijkatra;

/**
 * Created by jingbao on 18-5-18.
 */
public class MyProcess {
    private int[] max=null;
    private int []need=null;
    private int []allocation=null;

    public int[] getMax() {
        return max;
    }

    public void setMax(int[] max) {
        this.max = max;
    }

    public int[] getNeed() {
        return need;
    }

    public void setNeed(int[] need) {
        this.need = need;
    }

    public int[] getAllocation() {
        return allocation;
    }

    public void setAllocation(int[] allocation) {
        this.allocation = allocation;
    }

    public MyProcess(int[] max, int[] need, int []allocation){
        this.max=max;
        this.need=need;
        this.allocation=allocation;
    }


}
