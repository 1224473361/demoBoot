package com.xhx.demo.framework.util;

import java.math.BigDecimal;
import java.util.Map;

/**
 * 
 * @author xhx
 *
 */
public class EStringUtil {
	/**
	 * @param o
	 * @return
	 */
	public static boolean stringIsNull(Object o) {
		if (null == o || "".equals(o.toString()) || "null".equalsIgnoreCase(o.toString())) {
			return true;
		}
		return false;
	}

	/**
	 * @param o
	 * @return
	 */
	public static boolean stringIsNotNull(Object o) {
		return !stringIsNull(o);
	}

	/**
	 * 从map中获取key对应的bigdecimal
	 * 
	 * @param m
	 * @param key
	 * @return
	 */
	public static BigDecimal getBigByMap(Map<String, Object> m, String key) {
		if (stringIsNull(m.get(key))) {
			return null;
		}
		return new BigDecimal(m.get(key).toString());
	}

	/**
	 * 从map中获取key对应的string
	 * 
	 * @param m
	 * @param key
	 * @return
	 */
	public static String getStringByMap(Map<String, Object> m, String key) {
		if (stringIsNull(m.get(key))) {
			return null;
		}
		return m.get(key).toString();
	}

	/**
	 * 获取object对应的string,null作为o为空的返回
	 * 
	 * @param o
	 * @return
	 */
	public static String getStringByObject(Object o) {
		return getStringByObjectAndDefault(o, null);
	}

	/**
	 * 获取object对应的string,defaultv作为o为空的返回
	 * 
	 * @param o
	 * @param defaultv
	 * @return
	 */
	public static String getStringByObjectAndDefault(Object o, String defaultv) {
		if (stringIsNull(o)) {
			return defaultv;
		}
		return o.toString();
	}

}
