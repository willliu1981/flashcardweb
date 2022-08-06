package test1;

public class Info {
	MyInteger myNumber;
	Integer number;
	int num;
	String data;
	Data msg;

	public Info(MyInteger myNumber, Integer number, int num, String data,
			Data msg) {
		super();
		this.myNumber = myNumber;
		this.number = number;
		this.num = num;
		this.data = data;
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "Info [myNumber=" + myNumber + ", number=" + number + ", num="
				+ num + ", data=" + data + ", msg=" + msg + "]";
	}
}
