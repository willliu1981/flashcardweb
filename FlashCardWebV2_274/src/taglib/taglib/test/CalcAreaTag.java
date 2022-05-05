package taglib.test;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class CalcAreaTag extends SimpleTagSupport {

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
		if (num2 == null) {
			num2 = 1;
		}

		if (num3 == null) {
			num3 = 1;
		}

		switch (this.operation) {
		case "rect":
			out.println("ClacArea Tag, answer= " + (num1 * num2));
			break;
		case "tri":
			out.println("ClacArea Tag, answer= " + (num1 * num2) / 2.0);
			break;
		case "cir":
			out.println("ClacArea Tag, answer= "
					+ (Math.pow(num1, 2) * Math.PI * 2.0));
			break;
		case "squ":
			out.println("ClacArea Tag, answer= " + (Math.pow(num1, 2)));
			break;
		default:
			out.println("Clac Tag, answer= " + num1);
			break;
		}
	}

}
