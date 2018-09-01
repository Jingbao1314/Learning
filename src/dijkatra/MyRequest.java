package dijkatra;

/**
 * Created by jingbao on 18-5-18.
 */
public class MyRequest {
    private int []request=null;

    public int[] getRequest() {
        return request;
    }

    public void setRequest(int[] request) {
        this.request = request;
    }

    public MyRequest(int []request){
        this.request=request;
    }

}
