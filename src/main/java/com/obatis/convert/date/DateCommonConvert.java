package com.obatis.convert.date;


import com.obatis.validate.ValidateTool;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Date转换公共组件库
 * @author HuangLongPu
 */
public class DateCommonConvert {

	private DateCommonConvert(){}

	/**
	 * 将传入的Date转为日期字符串，转换后格式：yyyy-MM-dd
	 * @author HuangLongPu
	 * @param date
	 * @return
	 */
	public static String formatDate(Date date) {
		if(date == null) {
			return null;
		}
		return DefaultDateConstant.SD_FORMAT_DATE.format(date);
	}
	
	/**
	 * 获取当前日期的字符串，格式：yyyy-MM-dd
	 * @author HuangLongPu
	 * @return
	 */
	public static String formatCurDate() {
		return formatDate(getCurDate());
	}

	/**
	 * 将传入的Date转为日期字符串，格式：yyyy-MM-dd HH:mm:ss
	 * @author HuangLongPu
	 * @param dateTime
	 * @return
	 */
	public static String formatDateTime(Date dateTime) {
		if(dateTime == null) {
			return null;
		}
		return DefaultDateConstant.SD_FORMAT_DATE_TIME.format(dateTime);
	}

	/**
	 * 得到当前时间字符串，格式：yyyy-MM-dd HH:mm:ss
	 * @author HuangLongPu
	 * @return
	 */
	public static String formatCurTime() {
		return formatDateTime(TimeGenerator.getTimestamp());
	}

	/**
	 * 获取当前年月日时分秒毫秒时间串，格式：yyyyMMddHHmmssSSS
	 * @author HuangLongPu
	 * @return
	 */
	public static String formatCurDateTimeMillis() {
		return formatDateTimeMillis(TimeGenerator.getTimestamp());
	}

	/**
	 * 将传入的Date转换为年月日时分秒毫秒时间串，格式：yyyyMMddHHmmssSSS
	 * @author HuangLongPu
	 * @param date
	 * @return
	 */
	public static String formatDateTimeMillis(Date date) {
		if(date == null) {
			return null;
		}
		return DefaultDateConstant.SD_FORMAT_TIME_MILLIS.format(date);
	}

	/**
	 * 获取当前日期的年月，格式：yyyyMM
	 * @author HuangLongPu
	 * @return
	 */
	public static String formatCurYearMonth() {
		return DefaultDateConstant.SD_FORMAT_YEAR_MONTH.format(TimeGenerator.getTimestamp());
	}
	
    /**
     * 获取开始时间，格式为：yyyy-MM-dd 00:00:00
	 * @author HuangLongPu
     * @param beginDate
     * @return
     */
    public static String formatBeginDateTime(Date beginDate) {
    	if(beginDate == null) {
    		return null;
    	}
    	return DefaultDateConstant.SD_FORMAT_BEGIN_DATE_TIME.format(beginDate);
    }
    
    /**
     * 将字符串的日期格式转为开始时间字符串
	 * @author HuangLongPu
     * @param beginDate
     * @return
     */
    public static String formatBeginDateTime(String beginDate) {
    	if(ValidateTool.isEmpty(beginDate)) {
    		return null;
    	}
    	if(ValidateTool.isDate(beginDate)) {
    		return beginDate + " 00:00:00";
    	}
    	Date date = parseDate(beginDate);
    	if(date != null) {
    		return DefaultDateConstant.SD_FORMAT_BEGIN_DATE_TIME.format(date);
    	}
    	return null;
    }
    
    /**
     * 将字符串的日期转为结束时间字符串
	 * @author HuangLongPu
     * @param endDate
     * @return
     */
    public static String formatEndDateTime(String endDate) {
    	if(ValidateTool.isEmpty(endDate)) {
    		return null;
    	}
    	if(ValidateTool.isDate(endDate)) {
    		return endDate + " 23:59:59";
    	}
    	Date date = parseDate(endDate);
    	if(date != null) {
    		return DefaultDateConstant.SD_FORMAT_END_DATE_TIME.format(date);
    	}
    	return null;
    }
    
    /**
     * 结束时间，格式为：yyyy-MM-dd 23:59:59
	 * @author HuangLongPu
     * @param endDate
     * @return
     */
    public static String formatEndDateTime(Date endDate) {
    	if(endDate == null) {
    		return null;
    	}
    	return DefaultDateConstant.SD_FORMAT_END_DATE_TIME.format(endDate);
    }
    
    /**
     * 根据传入的date，获取1号
	 * @author HuangLongPu
     * @param date
     * @return
     */
    public static String formatDateFirstDay(Date date) {
    	if(date == null) {
    		return null;
    	}
    	return DefaultDateConstant.SD_FORMAT_DATE_FIRST_DAY.format(date);
    }
    
    /**
     * 获取当前月的第一天
	 * @author HuangLongPu
     * @return
     */
    public static String formatCurDateFirstDay() {
    	return formatDateFirstDay(getCurDate());
    }
    
    /**
     * 获取时间戳，long类型格式
	 * @author HuangLongPu
     * @return
     */
    public static long getTimeMillis() {
        return TimeGenerator.getTimeMillis();
    }
    
    /**
     * 获取当前日期，返回Date类型
	 * @author HuangLongPu
     * @return
     */
    public static Date getCurDate() {
    	return TimeGenerator.getTimestamp();
    }
    
    /**
     * 将传入的时间格式字符串转为Date类型，传入格式：yyyy-MM-dd HH:mm:ss
	 * @author HuangLongPu
     * @param dateTime
     * @return
     */
    public static Date parseDateTime(String dateTime) {
    	if(ValidateTool.isEmpty(dateTime)) {
    		return null;
    	}
    	
    	try {
			return DefaultDateConstant.SD_FORMAT_DATE_TIME.parse(dateTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	return null;
    }
    
    /**
     * 将日期格式字符串转为Date类型，格式：yyyy-MM-dd
     * @param date
     * @return
     */
    public static Date parseDate(String date) {
    	if(ValidateTool.isEmpty(date)) {
    		return null;
    	}
    	
    	try {
    		return DefaultDateConstant.SD_FORMAT_DATE.parse(date);
    	} catch (ParseException e) {
    		e.printStackTrace();
    	}
    	return null;
    }

	/**
	 * 将日期格式字符串转为Date类型，格式：可选，默认为yyyy-mm-dd
	 * @author HuangLongPu
	 * @param date    String 字符型日期
	 * @param format  String 格式
	 * @return Date 日期
	 */
	public static Date parseDate(String date, String format) {
		if(ValidateTool.isEmpty(date)) {
			return null;
		}

		if(ValidateTool.isEmpty(format)) {
			format = DefaultDateConstant.DATE_PATTERN;
		}

		try {
			DateFormat dateFormat = new SimpleDateFormat(format);
			return dateFormat.parse(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
    
    /**
     * 获取开始时间，格式：yyyy-MM-dd 00:00:00
	 * @author HuangLongPu
     * @param dateTime
     * @return
     */
    public static Date parseBeginDateTime(String dateTime) {
    	if(ValidateTool.isEmpty(dateTime)) {
    		return null;
    	}
    	
    	try {
			return DefaultDateConstant.SD_FORMAT_BEGIN_DATE_TIME.parse(dateTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	return null;
    }
    
    /**
     * 获取结束时间，格式：yyyy-MM-dd 23:59:59
	 * @author HuangLongPu
     * @param dateTime
     * @return
     */
    public static Date parseEndDateTime(String dateTime) {
    	
    	if(ValidateTool.isEmpty(dateTime)) {
    		return null;
    	}
    	
    	try {
			return DefaultDateConstant.SD_FORMAT_END_DATE_TIME.parse(dateTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	return null;
    }

	/**
	 * 得到当前月份的第一天的Date
	 * @author HuangLongPu
	 * @return
	 */
	public static Date parseCurDateFirstDay() {
		return parseDateFirstDay(formatCurDate());
	}
    
    /**
     * 根据传入的字符串date，获取第一天的Date
	 * @author HuangLongPu
     * @param date
     * @return
     */
    public static Date parseDateFirstDay(String date) {
    	if(ValidateTool.isEmpty(date)) {
    		return null;
    	}
    	
    	try {
			return DefaultDateConstant.SD_FORMAT_DATE_FIRST_DAY.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	
    	return null;
    }

}