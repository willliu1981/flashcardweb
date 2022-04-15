package gameobjectimpl.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.gson.Gson;

import idv.tool.Debug;

public class Test8 {

	static class BookI {

	}

	public static void main(String[] args) throws InstantiationException,
			IllegalAccessException, FileNotFoundException, IOException {
		/*
		String a = "\"abc\"";
		String b = "abc";
		
		System.out.println(Pattern.matches("\"\\w+\"", a));
		System.out.println(Pattern.matches("\\w+", b));
		
		boolean matches = Pattern.matches("\"\\w+\"", a);
		//*/

		Properties prop = new Properties();
		prop.load(new FileInputStream(
				Test8.class.getResource("test.properties").getFile()));
		String name = prop.getProperty("name");

		Debug.test("p", name);
		
		String replaceAll = name.replaceAll("\"", "");

		
		Car car=new Car();
		car.setName("x");
		
		Gson gson=new Gson();
		
		String json = gson.toJson(car);
		
		Debug.test("car name",car.getName());
		Debug.test("json",json);
		
		
		prop.setProperty("name",json);
		prop.store(new FileOutputStream("c:/test/test.properties"), "test");
		
		prop.load(new FileInputStream("c:/test/test.properties"));
		String property = prop.getProperty("name");
		
		
		Car fromJson = gson.fromJson(property, Car.class);
		Debug.test("load prop car",fromJson.getName());
		
	}

}
