package com.pope.contract.util;

import java.io.InputStream;
import java.io.Reader;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * 公共方法工具类
 * @author weizhen
 * @date 2016年11月07日 14:55:50
 */
public class CommonUtil {

	
	
    private static final Log LOGGER = LogFactory.getLog(CommonUtil.class);

    private CommonUtil() {

    }

    /**
     * Map为空判断
     * 
     * @author zhouyu
     * @date 2015年9月21日 上午11:46:14
     * @param map
     * @return
     */
    public static boolean isEmptyMap(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

   
    
    /**
     * List为空判断
     * 
     * @author zhouyu
     * @date 2015年9月21日 上午11:46:22
     * @param list
     * @return
     */
    public static boolean isEmptyList(List<?> list) {
        return list == null || list.isEmpty();
    }

    /**
     * Map非空判断
     * 
     * @author zhouyu
     * @date 2015年9月21日 上午11:46:14
     * @param map
     * @return
     */
    public static boolean isNotEmptyMap(Map<?, ?> map) {
        return !isEmptyMap(map);
    }

    /**
     * List非空判断
     * 
     * @author zhouyu
     * @date 2015年9月21日 上午11:46:22
     * @param list
     * @return
     */
    public static boolean isNotEmptyList(List<?> list) {
        return !isEmptyList(list);
    }


    /**
     * 将集合数据转换成Map数据结构
     * @author weizhen
     * @date 2016年11月07日 14:56:58
     * @param datas
     * @param key
     * @param prefix
     * @return
     */
    public static Map<String, Map<String, Object>> convertMap(List<Map<String, Object>> datas, String key, String prefix) {
        if (isEmptyList(datas)) {
            return null;
        }
        String key2 = key;
        String prefix2 = prefix;
        if (StringUtils.isEmpty(key2)) {
            key2 = "WID";
        }
        if (!datas.get(0).containsKey(key2)) {
            throw new IllegalArgumentException("集合中元素不存在相应的键[" + key2 + "]");
        }
        Map<String, Map<String, Object>> retMap = new HashMap<String, Map<String, Object>>();
        prefix2 = StringUtils.isEmpty(prefix2) ? "" : prefix2;
        for (Map<String, Object> data : datas) {
            String keyValue = prefix2 + String.valueOf(data.get(key2));
            retMap.put(keyValue, data);
        }
        return retMap;
    }

    /**
     * 转换集合为Map
     * 
     * @author mengbin
     * @date 2016年1月14日 上午8:26:19
     * @param datas
     * @param key
     * @return
     */
    public static Map<String, Map<String, Object>> convertMap(List<Map<String, Object>> datas, String key) {
        return convertMap(datas, key, null);
    }

    /**
     * 将MAP进行分组
     * 
     * @author mengbin
     * @date 2016年3月18日 上午11:38:30
     * @param datas
     * @param groupKey
     * @return
     */
    public static Map<String, List<Map<String, Object>>> groupMap(List<Map<String, Object>> datas, String key) {
        if (isEmptyList(datas)) {
            return null;
        }
        if (StringUtils.isEmpty(key)) {
            throw new IllegalArgumentException("分组KEY不能为空");
        }
        if (!datas.get(0).containsKey(key)) {
            throw new IllegalArgumentException("集合中元素不存在相应的键[" + key + "]");
        }
        Map<String, List<Map<String, Object>>> retMap = new LinkedHashMap<String, List<Map<String, Object>>>();
        for (int i = 0; i < datas.size(); i++) {
            Map<String, Object> data = datas.get(i);
            String keyVal = (String) data.get(key);
            if (keyVal == null) {
                keyVal = "";
            }
            List<Map<String, Object>> groupList = retMap.get(keyVal);
            if (groupList == null) {
                groupList = new ArrayList<Map<String, Object>>();
                retMap.put(keyVal, groupList);
            }
            groupList.add(data);
        }
        return retMap;
    }

    /**
     * 检测空字符串
     * 
     * @author weizhen
     * @date 2016年11月07日 14:57:44
     * @param values
     * @param errs
     * @throws Exception
     */
    public static void checkEmptyStr(String[] values, String... errs) throws Exception {
        if (values == null || values.length < 1) {
            return;
        }
        for (int i = 0; i < values.length; i++) {
            if (StringUtils.isEmpty(values[i])) {
                String err = "参数不能为空";
                if (errs != null && errs.length > i) {
                    err = errs[i];
                }
                throw new Exception(err);
            }
        }
    }

    /**
     * 返回SQL参数
     * @author weizhen
     * @date 2016年11月07日 14:57:44
     * @param arr
     * @return
     *          第一个元素为?号字符串,第二个参数为对应的值,类型为List
     */
    private static Object[] getSqlParams(String[] arr) {
        if (arr == null || arr.length < 1) {
            return null;
        }
        StringBuilder buf = new StringBuilder();
        List<Object> p = new ArrayList<Object>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            buf.append("?");
            if (i < arr.length - 1) {
                buf.append(",");
            }
            p.add(arr[i]);
        }
        return new Object[] { buf.toString(), p };
    }

    /**
     * 获取连接查询SQL参数
     * 
     * @author weizhen
     * @date 2016年11月07日 14:57:44
     * @param arr
     * @param params
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    private static String getJoinSql(String[] arr, List<Object> params) throws Exception {
        Object[] result = getSqlParams(arr);
        if (result == null) {
            throw new Exception("参数不能为空");
        }
        String sql = (String) result[0];
        List<Object> p = (List<Object>) result[1];
        if (params != null) {
            params.addAll(p);
        }
        return sql;
    }

    /**
     * 获取连接查询SQL参数
     * 
     * @author weizhen
     * @date 2016年11月07日 14:57:44
     * @param arr
     * @param params
     * @return
     * @throws Exception
     */
    public static String getJoinSql(List<String> list, List<Object> params) throws Exception {
        return getJoinSql(list.toArray(new String[0]), params);
    }

	
    
   
}

