package myenum.i;

public enum SeasonEnum {
	AAAA(2),SPRING(2),SUMMER(2),FALL(2),WINTER(2),OTHER(2);//实质上这个是调用了以下的默认构造函数
	//AAAA(2)   相当于private SeasonEnum AAA=new SeasonEnum(2);
	SeasonEnum(int i){

	}
	/**
	 * public SeasonEnum(){}
	 */
	public static void main(String[] args) {
		System.out.println(SeasonEnum.AAAA);
	}
}

