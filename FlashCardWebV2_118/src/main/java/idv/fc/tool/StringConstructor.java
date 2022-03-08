package idv.fc.tool;

public class StringConstructor {
	private static final String DEFAULT_APPENDIX = ",";

	public static String join(String contextExpression, String[] insertDatas,
			boolean insertData, String appendix, boolean lastAppendix) {
		if (appendix == null || appendix.equals("")) {
			appendix = DEFAULT_APPENDIX;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < insertDatas.length; i++) {
			String data = insertData ? insertDatas[i] : "";
			String ap = appendix;
			if (i == insertDatas.length - 1 && !lastAppendix) {
				ap = "";
			}

			sb.append(String.format(contextExpression, data) + ap);
		}

		return sb.toString();
	}

	public static String join(String contextExpression, String[] datas,
			String appendix) {
		return join(contextExpression, datas, false, appendix, false);
	}

	public static String join(String contextExpression, String[] datas,
			boolean insertData, String appendix) {
		return join(contextExpression, datas, insertData, appendix, false);
	}

	public static String join(String[] datas, String appendix) {
		return join("%s", datas, true, appendix, false);
	}
}
