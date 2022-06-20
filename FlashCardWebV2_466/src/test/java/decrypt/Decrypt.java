package decrypt;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.junit.jupiter.api.Test;

public class Decrypt {

	static Map<String, String> keys = new HashMap<>();;

	static {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(
					"c:/java/test/keys book/keys.properties"));
			prop.forEach(
					(x, y) -> keys.put(String.valueOf(x), String.valueOf(y)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	String process(String text) {

		String[] datas = text.split("");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < datas.length; i++) {
			if (datas[i].equals(",")) {
				sb.append("9");

			} else if (datas[i].equals("-")) {
				sb.append("0");

			} else {
				int combine = Integer.valueOf(datas[i] + datas[i + 1]);
				if (combine >= 55) {
					char c = (char) (combine - 55 + 65);
					sb.append(String.valueOf(c));

				} else if (combine >= 28) {
					char c = (char) (combine - 28 + 97);
					sb.append(String.valueOf(c));

				} else {
					int value = Integer.valueOf(datas[i]) * 3
							+ Integer.valueOf(datas[i + 1]);
					sb.append(String.valueOf(value));

				}

				i++;
			}

		}

		return sb.toString();

	}

	public String deCode(String code) {
		return process(keys.get(this.deCodeForKeysCode(code)));
	}

	//keys key 本身也是 密文
	public String deCodeForKeysCode(String code) {
		return process(code);
	}

	@Test
aaaaaa	public void test() {

		System.out.println(this.deCode("-11"));
	}

}
