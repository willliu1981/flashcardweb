package idv.fc.tool;

public class StringConstructor {
	private static final String DEFAULT_SEPARATOR = ",";
	private String defaultSeparator = DEFAULT_SEPARATOR;
	private boolean defaultLastSeparatorAppend = false;// default false

	protected String getDefaultSeparator() {
		return defaultSeparator;
	}

	public void setDefaultSeparator(String default_separator) {
		this.defaultSeparator = default_separator;
	}

	protected boolean isDefaultLastSeparatorAppend() {
		return defaultLastSeparatorAppend;
	}

	public void setDefaultLastSeparatorAppend(boolean defaultLastSeparatorAppend) {
		this.defaultLastSeparatorAppend = defaultLastSeparatorAppend;
	}

	public String join(String contextFormatExpression, String[] insertDatas,
			boolean insertData, String separator, boolean lastSeparatorAppend) {
		if (separator == null || separator.equals("")) {
			separator = getDefaultSeparator();
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

	public String join(String contextFormatExpression, String[] insertDatas,
			String separator) {
		return join(contextFormatExpression, insertDatas, true, separator,
				isDefaultLastSeparatorAppend());
	}

	public String join(String contextFormatExpression, String[] insertDatas) {
		return join(contextFormatExpression, insertDatas, getDefaultSeparator());
	}

	public String join(String contextFormatExpression, String[] insertDatas,
			boolean insertData, String separator) {
		return join(contextFormatExpression, insertDatas, insertData, separator,
				isDefaultLastSeparatorAppend());
	}

	public String join(String contextFormatExpression, String[] insertDatas,
			boolean insertData) {
		return join(contextFormatExpression, insertDatas, insertData,
				getDefaultSeparator());
	}

	public String join(String[] insertDatas, String separator) {
		return join("%s", insertDatas, true, separator, isDefaultLastSeparatorAppend());
	}

	public String join(String[] insertDatas) {
		return join(insertDatas, getDefaultSeparator());
	}
}
