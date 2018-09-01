package myenum.i;

public class EnumTest  {

    public void judge(SeasonEnum s) {
        switch (s) {
            case SPRING:
                System.out.println("SPRING");
                break;
            case SUMMER:
                System.out.println("SUMMER");
                break;
            case FALL:
                System.out.println("FALL");
                break;
            case WINTER:
                System.out.println("WINTER");
                break;
            default:
                System.out.println("OTHER");
        }
    }

    public static void main(String[] args) {
//        for (SeasonEnum s : SeasonEnum.values()) {
//            System.out.println(s);
//        }
        EnumTest t = new EnumTest();
        t.judge(SeasonEnum.SPRING);
        t.judge(SeasonEnum.OTHER);
    }
}
