package test1;

public class Person {
	MyInteger myNumber;
	Integer number;
	int num;
	Info info;
	String infoData;
	Data msg;

	Person() {
		info = new Info(myNumber, number, num, infoData, msg);
	}

	public MyInteger getMyNumber() {
		return myNumber;
	}

	public void setMyNumber(MyInteger myNumber) {
		this.myNumber = myNumber;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	public String getInfoData() {
		return infoData;
	}

	public void setInfoData(String infoData) {
		this.infoData = infoData;
	}

	public Data getMsg() {
		return msg;
	}

	public void setMsg(Data msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "Person [info=" + info + "]";
	}

	

	

}
