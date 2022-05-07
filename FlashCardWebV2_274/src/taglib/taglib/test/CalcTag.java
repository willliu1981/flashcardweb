package taglib.test;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class CalcTag extends SimpleTagSupport {

	private Integer num1;
	private Integer num2;
	private Integer num3;
	public String operation = "";

	public void setNum1(Integer num1) {
		this.num1 = num1;
	}

	public void setNum2(Integer nume2) {
		this.num2 = nume2;
	}

	public void setNum3(Integer num3) {
		this.num3 = num3;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = this.getJspContext().getOut();
		switch (this.operation) {
		case "add":
		default:
			out.println("Clac Tag, answer= " + (num1 + num2));
			break;
		case "sub":
			out.println("Clac Tag, answer= " + (num1 - num2));
			break;
		case "mult":
			out.println("Clac Tag, answer= " + num1 * num2);
			break;
		case "div":
			out.println("Clac Tag, answer= " + num1 * 0.1 / num2);
			break;

		}
	}

}