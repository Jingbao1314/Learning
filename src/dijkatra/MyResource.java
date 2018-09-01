package dijkatra;

/**
 * Created by jingbao on 18-5-18.
 */
public class MyResource {
    private int length=0;
    private int[] resource=null;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int[] getResource() {
        return resource;
    }

    public void setResource(int[] resource) {
        this.resource = resource;
    }

    public MyResource(int [] resource){
        this.resource=resource;
    }
    public int[] updata(int address,int value){
        resource[address]=value;
        return resource;
    }

}
