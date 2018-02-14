package com.pope.contract.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List; 
import java.util.Set;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.crypto.hash.Md5Hash;


/**
 * 字符串工具类
 * 
 * @author mengbin
 * @date 2015-8-29 上午11:47:25
 */
public class StringUtil {
	
	private static Pattern p_script = Pattern.compile("<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>",Pattern.CASE_INSENSITIVE);
    private static Pattern p_style = Pattern.compile("<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>",Pattern.CASE_INSENSITIVE);
    private static Pattern p_html = Pattern.compile("<[^>]+>",Pattern.CASE_INSENSITIVE);

    private static final Log LOGGER = LogFactory.getLog(StringUtil.class);
    
    private StringUtil(){
    	
    }
    
    public static String getUuId(){
    	 UUID uuid = UUID.randomUUID();
    	 return uuid.toString();
    }
    /**
     * 手机号码隐藏中间4位
     * @param mobile
     * @return
     */
    public static String mobile2hide(String mobile){
    	if(StringUtils.isEmpty(mobile)){
    		return mobile;
    	}
    	return mobile = mobile.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
    }
    
    
	/**
	 * 拼装SQL字符串
	 * @deprecated 使用CommonUtil.getSqlParams()替代
	 * @author mengbin
	 * @date 2015-8-29 上午11:48:13
	 * @param arr
	 * @return
	 */
    @Deprecated
	public static String joinSql(String[] arr) {
		if (arr == null || arr.length < 1) {
			return null;
		}
		StringBuilder buf = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			buf.append("'").append(arr[i]).append("'");
			if (i < arr.length - 1) {
				buf.append(",");
			}
		}
		return buf.toString();
	}
	
	/**
	 * 连接SQL
	 * @deprecated 使用CommonUtil.getJoinSql方法替代
	 * @author mengbin
	 * @date 2015年12月14日 上午9:35:30
	 * @param list
	 * @return
	 */
    @Deprecated
	public static String joinSql(List<String> list){
		if(CommonUtil.isEmptyList(list)){
			return null;
		}
		return joinSql(list.toArray(new String[0]));
	}
	
	/**
	 * 连接元素
	 * @author mengbin
	 * @date 2015年12月1日 下午7:45:07
	 * @param arr
	 * @return
	 */
	public static String join(String[] arr){
		if(arr == null || arr.length < 1){
			return null;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
			if (i < arr.length - 1) {
				sb.append(",");
			}
		}
		return sb.toString();
	}
	
	/**
	 * 反向连接元素
	 * @author mengbin
	 * @date 2015年12月1日 下午7:45:07
	 * @param arr
	 * @return
	 */
	public static String reverseJoin(String[] arr){
		if(arr == null || arr.length < 1){
			return null;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = arr.length - 1; i >= 0; i--) {
			sb.append(arr[i]);
			if (i > 0) {
				sb.append(",");
			}
		}
		return sb.toString();
	}
	
	/**
	 * 返回拼接信息
	 * @param arr
	 * @return
	 */
	public static String join(Object... arr){
		if(arr == null || arr.length < 1){
			return null;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
			if (i < arr.length - 1) {
				sb.append(",");
			}
		}
		return sb.toString();
	}
	
	/**
	 * 连接字符串
	 * @author mengbin
	 * @date 2015年12月1日 下午7:44:56
	 * @param list
	 * @return
	 */
	public static String join(List<String> list){
		if(CommonUtil.isEmptyList(list)){
			return null;
		}
		return join(list.toArray(new String[0]));
	}
	
	/**
	 * 反向连接字符串
	 * @author mengbin
	 * @date 2015年12月1日 下午7:44:56
	 * @param list
	 * @return
	 */
	public static String reverseJoin(List<String> list){
		if(CommonUtil.isEmptyList(list)){
			return null;
		}
		return reverseJoin(list.toArray(new String[0]));
	}
	
	/**
	 * 连接字符串(WID除外)
	 * @author yingwu01
	 * @date 2016年1月4日16:35:29
	 * @param list
	 * @param split  过滤的字段  如 WID,XM,NL...
	 * @return
	 */
	public static String joinWithoutStrArray(List<String> list,String split){
		if(CommonUtil.isEmptyList(list)){
			return null;
		}
		return joinWithoutStrArray(list.toArray(new String[0]), split);
	}
	/**
	 * 连接元素(wid字段除外)
	 * @author yingwu01
	 * @date 2016年1月4日16:33:13
	 * @param arr
	 * @param split  过滤的字段  如 WID,XM,NL...
	 * @return
	 */
	public static String joinWithoutStrArray(String[] arr,String split){
		if(arr == null || arr.length < 1){
			return null;
		}
		String str = split;
		str = addStr(str,",",",",true);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			if(str.indexOf(","+arr[i]+",")>=0){
				continue;
			}
			sb.append(arr[i]);
			if (i < arr.length - 1) {
				sb.append(",");
			}
		}
		return removeStr(sb.toString(), ",", ",");
	}
	/**
	 * 连接元素(wid字段除外)
	 * @author yingwu01
	 * @date 2016年1月4日16:33:13
	 * @param arr
	 * @return
	 */
	public static String joinWithoutWid(String[] arr){
		if(arr == null || arr.length < 1){
			return null;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			if("WID".equalsIgnoreCase(arr[i])){
				continue;
			}
			sb.append(arr[i]);
			if (i < arr.length - 1) {
				sb.append(",");
			}
		}
		return removeStr(sb.toString(), ",", ",");
	}
	/**
	 * 返回拼接信息(WID除外)
	 * @author yingwu01
	 * @date 2016年1月4日下午4:33:25
	 * @param arr
	 * @return
	 */
	public static String joinWithoutWid(Object... arr){
		if(arr == null || arr.length < 1){
			return null;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			if("WID".equalsIgnoreCase(toStr(arr[i]))){
				continue;
			}
			sb.append(arr[i]);
			if (i < arr.length - 1) {
				sb.append(",");
			}
		}
		return removeStr(sb.toString(), ",", ",");
	}
	/**
	 * 连接字符串(WID除外)
	 * @author yingwu01
	 * @date 2016年1月4日16:35:29
	 * @param list
	 * @return
	 */
	public static String joinWithoutWid(List<String> list){
		if(CommonUtil.isEmptyList(list)){
			return null;
		}
		return joinWithoutWid(list.toArray(new String[0]));
	}
	
	/**
	 * 是否邮箱
	 * 
	 * @author mengbin
	 * @date 2015年9月23日 下午2:36:15
	 * @param str
	 * @return
	 */
	public static final Pattern MAIL_PATTERN = Pattern
			.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");

	public static boolean isMail(String str) {
		return MAIL_PATTERN.matcher(str).matches();
	}
	
	/**
	 * 判断是否手机号码
	 * 
	 * @author mengbin
	 * @date 2015年9月23日 下午2:36:33
	 * @param str
	 * @return
	 */
	public static final Pattern PHONE_PATTERN = Pattern.compile("^1\\d{10}$");

	public static boolean isPhone(String str) {
		return PHONE_PATTERN.matcher(str).matches();
	}

	public static final String URL_REG = "^(http|https|ftp)\\://([a-zA-Z0-9\\.\\-]+(\\:[a-zA-"
			+ "Z0-9\\.&%\\$\\-]+)*@)?((25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{"
			+ "2}|[1-9]{1}[0-9]{1}|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1]{1}"
			+ "[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|"
			+ "[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\\.(25[0-5]|2[0-"
			+ "4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[0-9])|([a-zA-Z0"
			+ "-9\\-]+\\.)*[a-zA-Z0-9\\-]+\\.[a-zA-Z]{2,4})(\\:[0-9]+)?(/"
			+ "[^/][a-zA-Z0-9\\.\\,\\?\\'\\\\/\\+&%\\$\\=~_\\-@]*)*$";
	public static final Pattern URL_PATTERN = Pattern.compile(URL_REG);

	/**
	 * 判断是否URL
	 * 
	 * @author zhouyu
	 * @date 2015年9月23日 下午2:36:33
	 * @param str
	 * @return
	 */
	public static boolean isUrl(String str) {
		return URL_PATTERN.matcher(str).matches();
	}

	/**
	 * 获取异常内容
	 * 
	 * @author mengbin
	 * @date 2015年11月4日 上午11:33:52
	 * @param e
	 * @return
	 */
	public static String getErrorMsg(Exception e) {
		return ExceptionUtils.getStackTrace(e);
	}
	
	/**
	 * 返回Oracle指定长度的字符串
	 * @author mengbin
	 * @date 2016年4月26日 下午1:47:18
	 * @param str
	 * @return
	 */
	public static String subStrOracleLen(String str,int len) {
		int pos = 0;
		StringBuilder buf = new StringBuilder();
		for(int i=0;i<str.length();i++){
			String s = str.substring(i,i+1);
			if(s.matches("[\\u4e00-\\u9fa5]")){
				pos+=3;
			}else{
				pos+=1;
			}
			if(pos > len){
				break;
			}
			buf.append(s);
		}
		return buf.toString();
	}
	
	/**
	 * HTML过滤
	 * 
	 * @author mengbin
	 * @date 2015年11月24日 下午2:37:04
	 * @param str
	 * @return
	 */
	public static String cleanHtml(String str) {
		if(StringUtils.isEmpty(str)){
			return str;
		}
		String str2 = str;
		str2 = p_script.matcher(str2).replaceAll("");
		str2 = p_style.matcher(str2).replaceAll("");
		str2 = p_html.matcher(str2).replaceAll("");
		return str2.replaceAll("\"", "").replaceAll("\'", "");
	}
	
	/**
	 * 字符串安全校验
	 * @author mengbin
	 * @date 2015-11-30 下午1:23:59
	 * @param value
	 * @return
	 */
	public static String safeHtml(String value) {
		if (value == null) {
			return null;
		}
		StringBuilder result = new StringBuilder(value.length());
		for (int i = 0; i < value.length(); i++) {
			switch (value.charAt(i)) {
			case '<':
				result.append("&lt;");
				break;
			case '>':
				result.append("&gt;");
				break;
			case '"':
				result.append("&quot;");
				break;
			case '\'':
				result.append("&#39;");
				break;
			case '%':
				result.append("&#37;");
				break;
			case ';':
				result.append("&#59;");
				break;
			case '(':
				result.append("&#40;");
				break;
			case ')':
				result.append("&#41;");
				break;
			case '&':
				result.append("&amp;");
				break;
			case '+':
				result.append("&#43;");
				break;
			default:
				result.append(value.charAt(i));
				break;
			}
		}
		return result.toString();
	}
	/**
	 * 在Str字符串左右增加字符,status设置为true则不会重复添加
	 * @author yingwu01
	 * @date 2016年1月5日下午4:26:32
	 * @param str
	 * @param left
	 * @param right
	 */
	public static String addStr(String str,String left,String right,boolean status){
		if(StringUtils.isNotEmpty(str)){
			String str2 = str;
			if(status){
				if(StringUtils.isNotEmpty(left) && !str2.startsWith(left)){
					str2 = left + str2;
				}
				if(StringUtils.isNotEmpty(right) && !str2.endsWith(right)){
					str2 = str2 + right;
				}
			}else{
				if(StringUtils.isNotEmpty(left)){
					str2 = left + str2;
				}
				if(StringUtils.isNotEmpty(right) ){
					str2 = str2 + right;
				}
			}
			return str2;
		}
		return null;
	}
	/**
	 * 在Str字符串删除字符串
	 * @author yingwu01
	 * @date 2016年1月5日下午4:26:32
	 * @param str
	 * @param left
	 * @param right
	 * @return 
	 */
	public static String removeStr(String str,String left,String right){
		if(StringUtils.isNotEmpty(str)){
			String str2 = str;
			if(StringUtils.isNotEmpty(left) && str2.startsWith(left)){
				str2 = str2.substring(left.length());
			}
			if(StringUtils.isNotEmpty(right) && str2.endsWith(right)){
				str2 = str2.substring(0,str2.length()-right.length());
			}
			return str2;
		}
		return null;
	}
	/**
	 * 将可转换的数据转换成int类型
	 * @param o
	 * @return
	 */
	public static int toInt(Object o){
		return toInt(o, 0);
	}
	/**
	 * 将可转换的数据转换成int类型
	 * @param o
	 * @return
	 */
	public static int toInt(Object o, int defaultValue){
		try{
			return Integer.parseInt(o.toString());
		}catch(Exception e){
			LOGGER.error(StringUtil.class, e);
			return defaultValue;
		}
	}
	
	
	/**
	 * 将可转换的数据转换成int类型
	 * @param o
	 * @return
	 */
	public static long toLong(Object o){
		return toLong(o, 0L);
	}
	/**
	 * 将可转换的数据转换成int类型
	 * @param o
	 * @return
	 */
	public static long toLong(Object o, long defaultValue){
		try{
			return Long.parseLong(o.toString());
		}catch(Exception e){
			LOGGER.error(StringUtil.class, e);
			return defaultValue;
		}
	}
	
	/**
	 * 将可转换的数据转换成String类型
	 * @param o
	 * @return
	 */
	public static String toStr(Object o){
		return o == null ? "" : o.toString();
	}
	
	/**
	 * 将可转换的数据转换成String类型
	 * @param o
	 * @return
	 */
	public static String toStr(Object o,String defaultValue){
		if(o==null){
			return defaultValue;
		}
		return o.toString();
	}
	
	
	
	/**
	 * 获取条件构造器中json中的value值
	 * @author twu
	 * @date 2016年4月26日 上午9:31:49
	 * @param json
	 * @return
	 * @throws BizException
	 */
	public static List<String> getJsonValue(String json){
		List<String> values = new ArrayList<String>();
		if(StringUtils.isEmpty(json)){
			return values;
		}
		String regEx = "\"value\":\"([^\"]*)\"";
		Pattern pat = Pattern.compile(regEx);
		Matcher mat = pat.matcher(json);
		while(mat.find()){
			String value = mat.group(1);
			values.addAll( Arrays.asList(value.split(",")));
		}
		return values;
	}
	
	
	
	
	
	private static String getSql(String builder,String value) throws Exception{
		
		return "";
	}
	
	/**
	 * 判断是否为数字
	 * @author mengbin
	 * @date 2016年5月20日 下午2:32:12
	 * @param number
	 * @return
	 */
	public static boolean isNumber(String number) {
		return NumberUtils.isNumber(number);
	}
	
	/**
	 * 判断是否为指定小数位数的数字
	 * @author mengbin
	 * @date 2016年5月20日 下午2:33:29
	 * @param number 数字字符串
	 * @param pos 小数位数
	 * @return
	 */
	public static boolean isNumber(String number, int pos) {
		if(!isNumber(number)){
			return false;
		}
		String[] tmps = number.trim().split("\\.");
		if(tmps.length == 1 && pos == 0){
			return true;
		}
		if(tmps.length == 2 && tmps[1].length() == pos){
			return true;
		}
		return false;
	}
	
	/**
	 * 字符串转换为List
	 * @param value
	 * @return
	 */
	public static List<String> str2List(String value){
		return str2List(value,",");
		
	}
	/**
	 * 字符串转换为List
	 * @param value
	 * @param split分隔符
	 * @return
	 */
	public static List<String> str2List(String value,String split){
		if(value==null|| value.trim().equals("")){
			return null;
		}
		List<String> lst=new ArrayList<String>();
		String[] values=value.split(split);
		for(String s:values){
			lst.add(s);
		}
		return lst;
	}
	/**
	 * list去除重复数据
	 * @param lstValue
	 * @return
	 */
	public static List<String> removeDistint(List<String> lstValue){
		if(lstValue==null){
			return null;
		}
		
		Set<String> set=new HashSet<String>();
		set.addAll(lstValue);
		List<String> newValue=new ArrayList<String>();
		newValue.addAll(set);
		return newValue;
	}
	
	 /**
     * 生成密码
     *
     * @param password 密码
     * @param salt     密码盐
     * @return
     */
    public static String createPassword(String password, String salt, int hashIterations) {
        Md5Hash md5Hash = new Md5Hash(password.trim(), salt, hashIterations);
        new Md5Hash();
        return md5Hash.toString();
    }
    public static String createPassword(String password, String salt) {
        Md5Hash md5Hash = new Md5Hash(password.trim(), salt);
        new Md5Hash();
        return md5Hash.toString();
    }
    public static String exceptionDetail(Throwable throwable) {
        Writer writer = new StringWriter();
        PrintWriter printWriter = new PrintWriter(writer);
        throwable.printStackTrace(printWriter);
        return "\n" + writer.toString();
    }

    public static String formatJson(String jsonStr) {
        if (null == jsonStr || "".equals(jsonStr)) return "";
        StringBuilder sb = new StringBuilder();
        char last = '\0';
        char current = '\0';
        int indent = 0;
        for (int i = 0; i < jsonStr.length(); i++) {
            last = current;
            current = jsonStr.charAt(i);
            switch (current) {
                case '{':
                case '[':
                    sb.append(current);
                    sb.append('\n');
                    indent++;
                    addIndentBlank(sb, indent);
                    break;
                case '}':
                case ']':
                    sb.append('\n');
                    indent--;
                    addIndentBlank(sb, indent);
                    sb.append(current);
                    break;
                case ',':
                    sb.append(current);
                    if (last != '\\') {
                        sb.append('\n');
                        addIndentBlank(sb, indent);
                    }
                    break;
                default:
                    sb.append(current);
            }
        }

        return sb.toString();
    }

    private static void addIndentBlank(StringBuilder sb, int indent) {
        for (int i = 0; i < indent; i++) {
            sb.append('\t');
        }
    }

    public static String camelToUnderline(String name) {
        StringBuilder result = new StringBuilder();
        if (name != null && name.length() > 0) {
            // 将第一个字符处理成大写
            result.append(name.substring(0, 1).toUpperCase());
            // 循环处理其余字符
            for (int i = 1; i < name.length(); i++) {
                String s = name.substring(i, i + 1);
                // 在大写字母前添加下划线
                if (s.equals(s.toUpperCase()) && !Character.isDigit(s.charAt(0))) {
                    result.append("_");
                }
                // 其他字符直接转成大写
                result.append(s);
            }
        }
        return result.toString().toLowerCase();
    }
    
    public static String  getErweima(){
    	long data=System.currentTimeMillis();
    	String value=StringUtil.toStr(data);
    	if(data>9999999999999L){
    		value=value.substring(0, 13);
    	}
    	value = String.format("%013d", StringUtil.toLong(value));
    	return value;
    }
}
