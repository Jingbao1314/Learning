package generics.i;

public class A1 extends Apple<String> {
    // 与父类Apple<String>的返回值完全相同
    public String getInfo() {
        return "子类" + super.getInfo();
    }
    /*
	// 下面方法是错误的
	public Object getInfo()
	{
		return "子类";
	}
	*/
}

