package arithmetic;

/**
 * Created by jingbao on 18-5-17.
 */
public class Goods {
    private int value=0;
    private int weight=0;
    public Goods(int value,int weight){
        this.value=value;
        this.weight=weight;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
