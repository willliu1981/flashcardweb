package idv.test;

import java.util.Arrays;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tool.toolkit.ToolKit;

public class TestLog {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	public TestStringBuilder sb = new TestStringBuilder();

	public TestStringBuilder foreach(Object[] ds) {
		sb.init("\n");
		Arrays.stream(ds)
				.forEach(x -> sb.append("\t> ").append(x).append("\n"));
		return sb;
	}

	public TestStringBuilder foreach(int[] ds) {
		sb.init("\n");
		Arrays.stream(ds)
				.forEach(x -> sb.append("\t> ").append(x).append("\n"));
		return sb;
	}

	public TestStringBuilder foreach(double[] ds) {
		sb.init("\n");
		Arrays.stream(ds)
				.forEach(x -> sb.append("\t> ").append(x).append("\n"));
		return sb;
	}

	//class TestStringBuilder
	public static class TestStringBuilder {
		protected StringBuilder _sb = ToolKit.getStringBuilder();

		public void init() {
			_sb.setLength(0);
		}

		public void init(String newString) {
			init();
			_sb.append(newString);
		}

		public int length() {
			return _sb.length();
		}

		public int hashCode() {
			return _sb.hashCode();
		}

		public int capacity() {
			return _sb.capacity();
		}

		public void ensureCapacity(int minimumCapacity) {
			_sb.ensureCapacity(minimumCapacity);
		}

		public boolean equals(Object obj) {
			return _sb.equals(obj);
		}

		public IntStream chars() {
			return _sb.chars();
		}

		public StringBuilder append(Object obj) {
			return _sb.append(obj);
		}

		public StringBuilder append(String str) {
			return _sb.append(str);
		}

		public StringBuilder append(StringBuffer sb) {
			return this._sb.append(sb);
		}

		public void trimToSize() {
			_sb.trimToSize();
		}

		public void setLength(int newLength) {
			_sb.setLength(newLength);
		}

		public IntStream codePoints() {
			return _sb.codePoints();
		}

		public StringBuilder append(CharSequence s) {
			return _sb.append(s);
		}

		public StringBuilder append(CharSequence s, int start, int end) {
			return _sb.append(s, start, end);
		}

		public StringBuilder append(char[] str) {
			return _sb.append(str);
		}

		public StringBuilder append(char[] str, int offset, int len) {
			return _sb.append(str, offset, len);
		}

		public StringBuilder append(boolean b) {
			return _sb.append(b);
		}

		public StringBuilder append(char c) {
			return _sb.append(c);
		}

		public StringBuilder append(int i) {
			return _sb.append(i);
		}

		public StringBuilder append(long lng) {
			return _sb.append(lng);
		}

		public StringBuilder append(float f) {
			return _sb.append(f);
		}

		public StringBuilder append(double d) {
			return _sb.append(d);
		}

		public StringBuilder appendCodePoint(int codePoint) {
			return _sb.appendCodePoint(codePoint);
		}

		public char charAt(int index) {
			return _sb.charAt(index);
		}

		public StringBuilder delete(int start, int end) {
			return _sb.delete(start, end);
		}

		public StringBuilder deleteCharAt(int index) {
			return _sb.deleteCharAt(index);
		}

		public StringBuilder replace(int start, int end, String str) {
			return _sb.replace(start, end, str);
		}

		public StringBuilder insert(int index, char[] str, int offset,
				int len) {
			return _sb.insert(index, str, offset, len);
		}

		public int codePointAt(int index) {
			return _sb.codePointAt(index);
		}

		public StringBuilder insert(int offset, Object obj) {
			return _sb.insert(offset, obj);
		}

		public StringBuilder insert(int offset, String str) {
			return _sb.insert(offset, str);
		}

		public StringBuilder insert(int offset, char[] str) {
			return _sb.insert(offset, str);
		}

		public StringBuilder insert(int dstOffset, CharSequence s) {
			return _sb.insert(dstOffset, s);
		}

		public StringBuilder insert(int dstOffset, CharSequence s, int start,
				int end) {
			return _sb.insert(dstOffset, s, start, end);
		}

		public StringBuilder insert(int offset, boolean b) {
			return _sb.insert(offset, b);
		}

		public int codePointBefore(int index) {
			return _sb.codePointBefore(index);
		}

		public StringBuilder insert(int offset, char c) {
			return _sb.insert(offset, c);
		}

		public StringBuilder insert(int offset, int i) {
			return _sb.insert(offset, i);
		}

		public StringBuilder insert(int offset, long l) {
			return _sb.insert(offset, l);
		}

		public StringBuilder insert(int offset, float f) {
			return _sb.insert(offset, f);
		}

		public StringBuilder insert(int offset, double d) {
			return _sb.insert(offset, d);
		}

		public int indexOf(String str) {
			return _sb.indexOf(str);
		}

		public int indexOf(String str, int fromIndex) {
			return _sb.indexOf(str, fromIndex);
		}

		public int codePointCount(int beginIndex, int endIndex) {
			return _sb.codePointCount(beginIndex, endIndex);
		}

		public int lastIndexOf(String str) {
			return _sb.lastIndexOf(str);
		}

		public int lastIndexOf(String str, int fromIndex) {
			return _sb.lastIndexOf(str, fromIndex);
		}

		public StringBuilder reverse() {
			return _sb.reverse();
		}

		public int offsetByCodePoints(int index, int codePointOffset) {
			return _sb.offsetByCodePoints(index, codePointOffset);
		}

		public void getChars(int srcBegin, int srcEnd, char[] dst,
				int dstBegin) {
			_sb.getChars(srcBegin, srcEnd, dst, dstBegin);
		}

		public void setCharAt(int index, char ch) {
			_sb.setCharAt(index, ch);
		}

		public String substring(int start) {
			return _sb.substring(start);
		}

		public CharSequence subSequence(int start, int end) {
			return _sb.subSequence(start, end);
		}

		public String substring(int start, int end) {
			return _sb.substring(start, end);
		}

		@Override
		public String toString() {
			return _sb.toString();
		}
	}

}
