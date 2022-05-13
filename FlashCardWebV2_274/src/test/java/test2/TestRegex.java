package test2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tool.Debug;

public class TestRegex {
	Logger logger = LoggerFactory.getLogger(TestRegex.class);

	@Test
	public void test1() {

		String str = "a3b";

		boolean matches = Pattern.matches("[a-z][0-9][a-z]", str);

		logger.info("b=" + matches);
	}

	@Test
	public void test1x() {

		/*	String str = "318";
		
			Pattern compile = Pattern.compile("^318");*/

		String str = "ahello sirars";

		Pattern compile = Pattern.compile("^h.*r");

		Matcher matcher = compile.matcher(str);

		logger.info("b=" + matcher.find());

		logger.info("name=" + new Object() {
		}.getClass().getEnclosingMethod());

		/*		logger.info("name=" + new Object() {
				}.getClass().getEnclosingMethod().getName());
		*/
		/*StackTraceElement stackTrace = new Exception().getStackTrace()[0];
		logger.info(stackTrace.getClassName() + "."
				+ stackTrace.getMethodName() + "  尚未實作");*/

	}

	@Test
	public void test1x1() {

		String str = "1123121";
		String reg = "[0-9]21$";

		Pattern compile = Pattern.compile(reg);

		Matcher matcher = compile.matcher(str);
		/*		logger.info("str=" + str + " reg=" + reg + " b=" + matcher.find());
				Debug.test("group", matcher.groupCount());
				Debug.test("group", matcher.group());*/
		while (matcher.find()) {
			System.out.println(matcher.group());
		}
	}

	@Test
	public void test2() {

		String dfn = "<div> ${body} </div>";

		String jspBody = "<span> xxx <span>";

		Pattern compile = Pattern.compile("\\$\\{[ ]*body[ ]*\\}");

		Matcher matcher = compile.matcher(dfn);

		/*	logger.info("b=" + matcher.find());
		
			Debug.test("group", matcher.group());*/
		while (matcher.find()) {
			System.out.println(matcher.group());
		}

		String replaceAll = matcher.replaceAll(jspBody);

		Debug.test(replaceAll);

	}

}
