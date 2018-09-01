package myenum.ii;
public class GenderTest {
	public static void main(String[] args) {
		Gender g = Gender.FEMALE;//Enum.valueOf(Gender.class , "FEMALE");
		g.name = "aaa";
		System.out.println(g + " is: " + g.name);
	}
}
