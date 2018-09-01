package myenum.i;

/**
 * Created by andilyliao on 16-10-29.
 */
abstract class Season {
    private String type="";
    public static Season Spring= new Season("spring") {
        @Override
        public void xxx() {
            System.out.println("xxxx");
        }
    };
    @Override
    public String toString() {
        switch (this.type){
            case "spring":
                return "spring";
            case "summer":
                return "summer";
            case "fall":
                return "fall";
            case "winter":
                return "winter";
            default:
                return "";
        }
    }
    private Season(String type){
        this.type=type;
    }
    abstract public  void xxx();
}

public class MySeason{
    public static void main(String[] args) {
        System.out.println(Season.Spring);
        Season s=Season.Spring;
        s.xxx();
//        switch (s.toString()){
//            case Season.FALL.toString():
//                break;
//        }
    }

}
