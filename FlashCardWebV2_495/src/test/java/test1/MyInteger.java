package test1;

public class MyInteger {
	Integer num;

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "MyIntger [num=" + num + "]";
	}

	public MyInteger(Integer num) {
		super();
		this.num = num;
	}

}
