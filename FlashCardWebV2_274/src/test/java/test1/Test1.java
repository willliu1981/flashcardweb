package test1;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import test.Car;
import test.ICar;
import tool.Debug;
import tool.spring.MySpringUtil;

public class Test1 {
	private final static Logger logger = LoggerFactory.getLogger(Test1.class);

	public static void main(String[] args) {

		logger.info("main");
	}



	@Test
	public void test2() {
		MySpringUtil.loadXml("test");
		Car bean = MySpringUtil.getBean("car1", Car.class);

		Debug.test("car", bean);
	}

	static class BaseCar {
		String msg() {
			return "x1";
		}
	}

	static class ACar extends BaseCar {
		String msg() {
			return "x1";
		}
	}

	static class SCar extends ACar implements ICar {
		public String msg() {
			return "x1";
		}
	}

	@Test
	public void test3() {
		ICar car = new ICar() {

			@Override
			public String msg() {
				return ICar.super.msg();
			}

		};

		Debug.test("car", car);
	}

	@Test
	public void test4() {

		String json = "[{\"animal_id\":\"10305240201056\",\"animal_kind\":\"貓\",\"animal_sex\":\"F\",\"shelter_name\":\"臺北市動物之家\"},"
				+ "{\"animal_id\":\"10508011005002\",\"animal_kind\":\"狗\",\"animal_sex\":\"F\",\"shelter_name\":\"臺中市中途動物醫院\"}]";

		String[] cat = new String[4];
		String[] dog = new String[4];

		json = json.replace("[", "").replace("]", "");

		String catData = json.substring(json.indexOf("{"),
				json.indexOf("}") + 1);
		String tmp = catData.replace("{", "").replace("}", "");
		cat = tmp.split(",");

		//String dogData = json.replace(catData + ",", "");
		json = json.replace(catData + ",", "");

		//dogData = dogData.replace("{", "").replace("}", "");
		String dogData = json.substring(json.indexOf("{"),
				json.indexOf("}") + 1);
		tmp = dogData.replace("{", "").replace("}", "");

		//dog = dogData.split(",");
		dog = tmp.split(",");

		System.out.println(json);
		System.out.println(catData);
		System.out.println(dogData);
		System.out.println(cat[3]);
		System.out.println(dog[3]);
	}

	@Test
	public void test5() {

		String json = "[{\"animal_id\":\"10305240201056\",\"animal_kind\":\"貓\",\"animal_sex\":\"F\",\"shelter_name\":\"臺北市動物之家\"},"
				+ "{\"animal_id\":\"10508011005002\",\"animal_kind\":\"狗\",\"animal_sex\":\"F\",\"shelter_name\":\"臺中市中途動物醫院\"},"
				+ "{\"animal_id\":\"10609022006003\",\"animal_kind\":\"貓\",\"animal_sex\":\"M\",\"shelter_name\":\"高雄市壽山動物保護教育園區\"}]";
		String primeJson = json;

		int count = 3;
		String[] amimalDatas = new String[count];
		String[][] animals = new String[count][4];

		json = json.replace("[", "").replace("]", "");

		//String tmpData;
		for (int i = 0;; i++) {
			/*
			amimalDatas[i] = tmpData = json.substring(json.indexOf("{"),
					json.indexOf("}") + 1);
			animals[i] = tmpData.replace("{", "").replace("}", "").split(",");
			json = json.replace(tmpData, "");
			//*/
			amimalDatas[i] = json.substring(json.indexOf("{"),
					json.indexOf("}") + 1);
			animals[i] = amimalDatas[i].replace("{", "").replace("}", "")
					.split(",");
			json = json.replace(amimalDatas[i], "");
			if (json.length() > 0) {
				json = json.replaceFirst(",", "");
			} else {
				break;
			}
		}

		System.out.println(primeJson);

		for (int i = 0; i < count; i++) {
			System.out.println(amimalDatas[i]);
		}

		for (int i = 0; i < count; i++) {
			System.out.println(animals[i][3]);
		}

	}

	@Test
	public void testA() {


	}

}
