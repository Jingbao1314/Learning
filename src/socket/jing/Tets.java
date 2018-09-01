package socket.jing;

/**
 * Created by jingbao on 18-5-24.
 */
public class Tets {
    public static void main(String[] args) {
        for(int i=0;i<3;i++){
            new Client().start();
        }
    }
}
