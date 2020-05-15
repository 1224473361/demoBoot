package com.xhx.demo.framework.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 日期转换类
 * 
 * @author xhx
 *
 */
public class EDateUtil {

	public static final String PATTERN_YYYY_DD_MM = "yyyy-MM-dd";
	public static final String PATTERN_YYYYMMDD = "yyyyMMdd";
	public static final String PATTERN_YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmssSSSS";
	public static final String PATTERN_YYYY_DD_MM_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
	public static final long DAY_SECOND = 1000 * 60 * 60 * 24L;
	public static final String ZONE_TIME = " 00:00:00";
	public static final String END_TIME = " 23:59:59";

	public static final DateTimeFormatter FORMAT_YYYYMMDDHHMMSSSSS = DateTimeFormatter
			.ofPattern(PATTERN_YYYYMMDDHHMMSSSSS);
	public static final DateTimeFormatter FORMAT_YYYYMMDD = DateTimeFormatter.ofPattern(PATTERN_YYYYMMDD);

	public static final DateTimeFormatter FORMAT_YYYY_DD_MM = DateTimeFormatter.ofPattern(PATTERN_YYYY_DD_MM);

	public static final DateTimeFormatter FORMAT_YYYY_DD_MM_HH_MM_SS = DateTimeFormatter
			.ofPattern(PATTERN_YYYY_DD_MM_HH_MM_SS);

	private EDateUtil() {

	}

	public static Date asDate(LocalDate localDate) {
		return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	}

	public static Date asDate(LocalDateTime localDateTime) {
		return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
	}

	public static LocalDate asLocalDate(Date date) {
		return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
	}

	public static LocalDateTime asLocalDateTime(Date date) {
		return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
	}

	/**
	 * yyyy-MM-dd 转为date
	 * 
	 * @param date
	 * @return
	 */
	public static Date asDate(String date) {
		LocalDateTime date1 = LocalDateTime.parse(date, FORMAT_YYYY_DD_MM);
		return asDate(date1);
	}

	/**
	 * yyyy-MM-dd HH:mm:ss 转为date
	 * 
	 * @param date
	 * @return
	 */
	public static Date asDateYMDHMS(String date) {
		LocalDateTime date1 = LocalDateTime.parse(date, FORMAT_YYYY_DD_MM_HH_MM_SS);
		return asDate(date1);
	}

	/**
	 * 时间相关的唯一标志
	 *
	 * @return
	 */
	public static String getFlag() {
		LocalDateTime now = LocalDateTime.now();
		String s1 = now.format(EDateUtil.FORMAT_YYYYMMDDHHMMSSSSS);
		String b = s1.substring(s1.length() - 6);
		Integer c = (int) (Math.random() * (Integer.parseInt(b) - 100000)) + 100000;
		String a = s1.substring(0, s1.length() - 6) + c;
		return a;
	}

	/**
	 * 获取yyyymmdd的当前时间
	 *
	 * @return
	 */
	public static String getLocalDateForYMD() {
		LocalDateTime now = LocalDateTime.now();
		return now.format(EDateUtil.FORMAT_YYYYMMDD);
	}

	/**
	 * yyyy-MM-dd HH:mm:ss 转为date
	 * 
	 * @param date
	 * @return
	 */
	public static Date asDateYMD(String date) {
		LocalDate date1 = LocalDate.parse(date, FORMAT_YYYYMMDD);
		return asDate(date1);
	}
}
