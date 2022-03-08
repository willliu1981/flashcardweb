package idv.fc.tool;

public class StringConstructor {
	private static final String DEFAULT_SEPARATOR = ",";

	public static String join(String contextFormatExpression, String[] insertDatas,
			boolean insertData, String separator, boolean lastSeparatorAppend) {
		if (separator == null || separator.equals("")) {
			separator = DEFAULT_SEPARATOR;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < insertDatas.length; i++) {
			String data = insertData ? insertDatas[i] : "";
			String ap = separator;
			if (i == insertDatas.length - 1 && !lastSeparatorAppend) {
				ap = "";
			}

			sb.append(String.format(contextFormatExpression, data) + ap);
		}

		return sb.toString();
	}

	public static String join(String contextFormatExpression, String[] insertDatas,
			String separator) {
		return join(contextFormatExpression, insertDatas, true, separator, false);
	}

	public static String join(String contextFormatExpression, String[] insertDatas) {
		return join(contextFormatExpression, insertDatas, DEFAULT_SEPARATOR);
	}

	public static String join(String contextFormatExpression, String[] insertDatas,
			boolean insertData, String separator) {
		return join(contextFormatExpression, insertDatas, insertData, separator, false);
	}

	public static String join(String contextFormatExpression, String[] insertDatas,
			boolean insertData) {
		return join(contextFormatExpression, insertDatas, insertData,
				DEFAULT_SEPARATOR);
	}

	public static String join(String[] insertDatas, String separator) {
		return join("%s", insertDatas, true, separator, false);
	}

	public static String join(String[] insertDatas) {
		return join(insertDatas, DEFAULT_SEPARATOR);
	}
}
