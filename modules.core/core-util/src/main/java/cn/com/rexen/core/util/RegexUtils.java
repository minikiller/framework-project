package cn.com.rexen.core.util;

import java.util.regex.Pattern;

/**
 * 正则表达式工具类.
 * 
 * @author libo
 * 
 */
public final class RegexUtils {

	/**
	 * 私有构�?�方�?.
	 */
	private RegexUtils() {
		super();
	}

	/**
	 * <p>
	 * �?查字符串是否符合正则表达�?.
	 * <p>
	 * 
	 * @param regex
	 *            正则表达�?
	 * @param str
	 *            被检查的字符�?
	 * @return 如果被检查的字符串符合正则表达式规则返回true .
	 */
	public static boolean matcher(final String regex, final String str) {
		if (StringUtils.isEmpty(regex) || StringUtils.isEmpty(str)) {
			throw new IllegalArgumentException("匹配字符串为�?.");
		}
		return Pattern.compile(regex).matcher(str).matches();
	}
}
