package com.pope.contract.util;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.fasterxml.jackson.databind.deser.std.DateDeserializers.CalendarDeserializer;

/**
 * 日期工具接口
 * @author mengbin
 * @date 2015年9月23日 下午6:58:02
 */
public class DateUtil {
	
	private DateUtil(){
		
	}
	
	public static final String DATETIME_FORMATTER = "yyyy-MM-dd HH:mm:ss";
	
	public static final String DATE_FORMATTER = "yyyy-MM-dd";
	
	public static final String TIMESTAMP_FORMATTER = "yyyyMMddHHmmssSSS";
	
	public static final String YEAR_FORMATTER = "yyyy";
	
	public static final String MONTH_FORMATTER = "yyyy-MM";
	
	public static final String ORACLE_DATETIME_FORMATTER = "YYYY-MM-DD HH24:MI:SS";
	
	/**
	 * 获取日期时间字符串，格式：yyyy-MM-dd HH:mm:ss
	 * @author mengbin
	 * @date 2015年9月23日 下午6:59:35
	 * @param date
	 * @return
	 */
	public static String formatDateTime(Date date) throws Exception{
		return new SimpleDateFormat(DATETIME_FORMATTER).format(date);
	}
	
	/**
	 * 获取时间戳字符串，格式：yyyyMMddHHmmssSSS
	 * @author mengbin
	 * @date 2015年10月7日 上午9:08:10
	 * @param date
	 * @return
	 */
	public static String formatTimestamp(Date date) throws Exception{
		return new SimpleDateFormat(TIMESTAMP_FORMATTER).format(date);
	}
	
	/**
	 * 获取日期字符串，格式：yyyy-MM-dd
	 * @author mengbin
	 * @date 2015年9月23日 下午7:00:02
	 * @param date
	 * @return
	 */
	public static String formatDate(Date date) throws Exception{
		return new SimpleDateFormat(DATE_FORMATTER).format(date);
	}
	
	/**
     * 获取Date日期，格式：yyyy-MM-dd
     * @author mengbin
     * @date 2015年9月23日 下午7:00:02
     * @param String，格式：yyyy-MM-dd
     * @return
     */
    public static Date parseDate(String date) throws Exception{
        return new SimpleDateFormat(DATE_FORMATTER).parse(date);
    }
    
    /**
     * 获取Date日期，格式：yyyy-MM-dd HH:mm:ss
     * @author yingwu01
     * @date 时间
     * @param String，格式：yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static Date parseDateTime(String date) throws Exception{
        return new SimpleDateFormat(DATETIME_FORMATTER).parse(date);
    }
	
	/**
     * 获取年份字符串，格式：yyyy
     * @author yuzhou
     * @date 2015年9月23日 下午7:00:02
     * @param date
     * @return
     */
    public static String formatYear(Date date)throws Exception{
        return new SimpleDateFormat(YEAR_FORMATTER).format(date);
    }
    
    /**
     * 获取年月字符串，格式：yyyy-MM
     * @author yuzhou
     * @date 2015年9月23日 下午7:00:02
     * @param date
     * @return
     */
    public static String formatMonth(Date date)throws Exception{
        return new SimpleDateFormat(MONTH_FORMATTER).format(date);
    }
	
	/**
	 * 获取指定日期格式
	 * @author mengbin
	 * @date 2015年10月10日 下午7:36:51
	 * @param date
	 * @param formatter
	 * @return
	 */
	public static String format(Date date,String formatter)throws Exception{
		return new SimpleDateFormat(formatter).format(date);
	}
	
	/**
	 * 获取当前时间，格式：yyyy-MM-dd HH:mm:ss
	 * @author mengbin
	 * @date 2015年9月29日 上午9:46:47
	 * @return
	 */
	public static String getCurrentDateTimeStr()throws Exception {
		return formatDateTime(getCurrentDate());
	}
	
	/**
     * 获取当前时间戳，格式：yyyyMMddHHmmssSSS
     * @author mengbin
     * @date 2015年9月29日 上午9:46:47
     * @return
     */
    public static String getCurrentTimestampStr()throws Exception {
        return formatTimestamp(getCurrentDate());
    }
    
    public static String getDay(Date date,int day) throws Exception{
    	 Calendar calendar = Calendar.getInstance();  
         calendar.setTime(date);
         calendar.add(Calendar.DATE, day);
         return DateUtil.formatDate(calendar.getTime());
    }
    public static String getDay(String date,int day) throws Exception {
    	Date theDate =DateUtil.parseDate(date);
        return getDay(theDate,day);
    	
    }
    
    public static String getMonth(String date,int month) throws Exception{
    	Date theDate =DateUtil.parseDate(date);
        Calendar calendar = Calendar.getInstance();  
        calendar.setTime(theDate);
        calendar.add(Calendar.MONTH, month);
        return DateUtil.format(calendar.getTime(),"yyyy-MM");
    }
    
    public static String addDate(String date,int day) throws Exception{
    	Date theDate =DateUtil.parseDate(date);
    	return addDate(theDate,day);
    }
    
    public static String addMonth(String month,int value) throws Exception {  
    	String date=month+"-01";  
        Date dt = DateUtil.parseDate(date);
        Calendar rightNow = Calendar.getInstance();  
        rightNow.setTime(dt);  
  
        rightNow.add(Calendar.MONTH, value);  
        Date dt1 = rightNow.getTime();  
        String reStr = DateUtil.format(dt1, MONTH_FORMATTER) ;
  
        return reStr;  
    }  
    
    public static String addDate(Date date,int day) throws Exception{
    	
    	 Calendar calendar = Calendar.getInstance();  
         calendar.setTime(date);
         calendar.add(Calendar.DATE, day);
         return DateUtil.formatDate(calendar.getTime());
    }
    /**
     * 获取某月第一天
     * @return
     */
    public static String getFirstDay(String date) throws Exception{
    	
       
        Date theDate =DateUtil.parseDate(date);
        Calendar calendar = Calendar.getInstance();  
        calendar.setTime(theDate);
        calendar.set(Calendar.DAY_OF_MONTH, calendar     
                .getActualMinimum(Calendar.DAY_OF_MONTH));
        return DateUtil.formatDate(calendar.getTime());

    }
    
    /**
     * 当月最后一天
     * @return
     */
    public static String getLastDay(String date) throws Exception {
    	  Date theDate =DateUtil.parseDate(date);
          Calendar calendar = Calendar.getInstance();  
          calendar.setTime(theDate);
          calendar.set(Calendar.DAY_OF_MONTH, calendar     
                  .getActualMaximum(Calendar.DAY_OF_MONTH));
          return DateUtil.formatDate(calendar.getTime());

    }
	/**
	 * 获取当前时间
	 * @author mengbin
	 * @date 2015年10月10日 下午7:37:57
	 * @return
	 * @throws Exception
	 */
	public static Date getCurrentDate()throws Exception {
		return new Date();
	}
	
	/**
	 * 获取当前日期yyyy-MM-dd
	 * @author mengbin
	 * @date 2015年10月10日 下午7:37:57
	 * @return
	 * @throws Exception
	 */
	public static Date getCurrentFormatDate()throws Exception {
		return parseDate(getCurrentDateStr());
	}
	
	/**
     * 获取当前日期，格式：yyyy-MM-dd
     * @author mengbin
     * @date 2015年10月10日 下午7:37:57
     * @return
     * @throws Exception
     */
    public static String getCurrentDateStr()throws Exception {
        return formatDate(getCurrentDate());
    }
	
	/**
     * 获取当前年份，格式：yyyy
     * @author mengbin
     * @date 2015年10月10日 下午7:37:57
     * @return
     * @throws Exception
     */
    public static String getCurrentYearStr()throws Exception {
        return formatYear(getCurrentDate());
    }
    
    /**
     * 获取当前年月，格式：yyyy-MM
     * @author mengbin
     * @date 2015年10月10日 下午7:37:57
     * @return
     * @throws Exception
     */
    public static String getCurrentMonthStr()throws Exception {
        return formatMonth(getCurrentDate());
    }
    
    /**
     * 获取两个日期字符串的天数差，格式：YYYY-MM-DD
     * @author wuying
     * @date 2016年4月20日 上午11:28:09
     * @param startDate
     * @param endDate
     * @return
     * @throws Exception
     */
    public static long getDaysBetween(String startDate,String endDate)throws Exception{
    	Date start = parseDate(startDate);
    	Date end =  parseDate(endDate);
    	long daysBetween =  (end.getTime()-start.getTime())/(1000*3600*24);
    	return daysBetween;
    }
    
    public static void main(String[] args) throws Exception{
    	String start="2017-06-05 21:20:00";
    	String end="2017-06-05 23:50:00";
    	Date start1 = parseDateTime(start);
    	Date end1 =  parseDateTime(end);
    	Calendar c1=Calendar.getInstance();
    	c1.setTime(start1);
    	int mint=c1.get(Calendar.MINUTE);
    	long days=getDaysBetween(start,end);
    	System.out.println("======="+(end1.getMinutes()-start1.getMinutes()));
    	
    	
    }
    
    public static int getMonthsBetween(String startMonth,String endMonth)throws Exception{
    	startMonth=startMonth+"-01";
    	endMonth=endMonth+"-01";
    	
    	Date start = parseDate(startMonth);
    	Date end =  parseDate(endMonth);
    	int months=end.getMonth()-start.getMonth()+(end.getYear()-start.getYear())*12;
 	   return months;
    }
    
    /**
     * 检查一个字符串是否为正常的可转换字符串，格式YYYY-MM-DD,
     * @author wuying
     * @date 2016年6月15日 下午2:34:05
     * @param str
     * @return 检查通过返回true,检查失败返回false
     */
    public static boolean isValidDate(String dateStr) {
	       boolean convertSuccess=true;
	       SimpleDateFormat format = new SimpleDateFormat(DATE_FORMATTER);
	       try {
	    	   //设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007-02-29会被转换成2007-03-01
	    	   format.setLenient(false);
	           format.parse(dateStr);
	       } catch (ParseException  e) {
	            convertSuccess=false;
	       } 
	      return convertSuccess;
	 }
    /**
     * 计算2个日期之间的周六周日天数
     * @param t1
     * @param t2
     * @return
     * @throws ParseException
     */
    public static int computeHolidays(Date t1,Date t2) throws ParseException{  
        //初始化第一个日期  
        Calendar cal1 = Calendar.getInstance();  
        //初始化第二个日期，这里的天数可以随便的设置  
        Calendar cal2 = Calendar.getInstance();  
  
  
        // 设置传入的时间格式    
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");    
        // 指定一个日期    
        Date date1 = dateFormat.parse(dateFormat.format(t1));    
        Date date2 = dateFormat.parse(dateFormat.format(t2));  
        // 对 calendar 设置为 date 所定的日期    
        cal1.setTime(date1);    
        cal2.setTime(date2);  
  
        int holidays = 0;  
        //确定一个 大日期  
        if(cal1.compareTo(cal2) > 0){  
            Calendar temp = cal1;  
            cal1 = cal2;  
            cal2 = temp;  
            temp = null;  
        }  
        while(cal1.compareTo(cal2)<=0){  
            if(cal1.get(Calendar.DAY_OF_WEEK)==1||cal1.get(Calendar.DAY_OF_WEEK)==7){  
                holidays++;  
                System.out.println("周末："+new SimpleDateFormat("yyyy-MM-dd").format(cal1.getTime()));  
            }  
            cal1.add(Calendar.DAY_OF_YEAR,1);  
              
        }  
        return holidays;  
    }  
    
    
    public static String getLastDateOfMonth(String month) throws Exception{
    	 String  lastday;  
    	 String date=month+"-01";
         // 获取前月的第一天  
    	 Calendar cale = Calendar.getInstance();  
         // 获取前月的最后一天  
         cale = Calendar.getInstance();  
         cale.setTime(DateUtil.parseDate(date));
         cale.set(Calendar.DAY_OF_MONTH, cale.getActualMaximum(Calendar.DAY_OF_MONTH));
         lastday = DateUtil.format(cale.getTime(),DATE_FORMATTER);
         return lastday;
    }
    
}
