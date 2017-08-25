package com.pope.contract.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;

import com.alibaba.druid.util.StringUtils;

/**
 * @author zhanglingyun E-mail:
 * @version 创建时间：2017年5月30日 上午10:57:31 类说明
 */
public class ExportExcel {

	/**
	 * 功能: 导出为Excel工作簿 参数: sheetName[工作簿中的一张工作表的名称] 参数: titleName[表格的标题名称] 参数:
	 * headers[表格每一列的列名] 参数: dataSet[要导出的数据源] 参数: resultUrl[导出的excel文件地址] 参数:
	 * pattern[时间类型数据的格式]
	 */
	public static void exportExcel(String sheetName, String titleName, String[] headers, Collection<?> dataSet,
			String resultUrl) {

		doExportExcel(sheetName, headers, dataSet);

	}
	/**
	 * 功能:真正实现导出
	 */
	public static void doExportExcel2(String fileName,String sheetName, String[] headers, List<List<String>> dataSet,HttpServletResponse response)  throws Exception{

		// 声明一个工作薄
		HSSFWorkbook workbook = new HSSFWorkbook();

		// 生成一个工作表
		HSSFSheet sheet = workbook.createSheet(sheetName);
		// 设置工作表默认列宽度为20个字节
		sheet.setDefaultColumnWidth((short) 20);
		// 创建[表中数据]样式
		HSSFCellStyle dataSetStyle = workbook.createCellStyle();
		// 设置[表中数据]样式
		//dataSetStyle.setFillForegroundColor(HSSFColor.GOLD.index);
		dataSetStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		dataSetStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		dataSetStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		dataSetStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		dataSetStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		dataSetStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		dataSetStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		// 创建[表中数据]字体
		HSSFFont dataSetFont = workbook.createFont();
		// 设置[表中数据]字体
		dataSetFont.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
		dataSetFont.setColor(HSSFColor.BLUE.index);
		// 把[表中数据字体]应用到[表中数据样式]
		dataSetStyle.setFont(dataSetFont);

		// 创建标题行-增加样式-赋值
		// HSSFRow titleRow = sheet.createRow(0);
		// HSSFCell titleCell = titleRow.createCell(0);
		// if( StringUtils.isEmpty(titleName)){
		// //titleCell.setCellStyle(titleStyle);
		// }
		// titleCell.setCellValue(titleName);

		// 创建列首-增加样式-赋值
		HSSFRow row = sheet.createRow(0);
		for (short i = 0; i < headers.length; i++) {

			@SuppressWarnings("deprecation")
			HSSFCell cell = row.createCell(i);
			// cell.setCellStyle(headersStyle);
			HSSFRichTextString text = new HSSFRichTextString(headers[i]);
			cell.setCellValue(text);

		}
		String pattern = "yyyy-MM-dd";
		int index = 0;
		if (dataSet != null) {
			for (List<String> datas : dataSet) {
				index++;
				row = sheet.createRow(index);
				int i=0;
				for (String column : datas) {
					@SuppressWarnings("deprecation")
					HSSFCell cell = row.createCell(i);
					cell.setCellStyle(dataSetStyle);
					cell.setCellValue(column);
					i++;
				}
			}
		}
		// 不弹出保存框方式
        /*
         * FileOutputStream fout = new FileOutputStream("e:/numberQuery1.xls");
         * wb.write(fout); fout.close(); wb.close();
         * System.out.println("导出完成！");
         */

        // 弹出保存框方式
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        workbook.write(os);
        byte[] content = os.toByteArray();
        InputStream is = new ByteArrayInputStream(content);
        // 设置response参数，可以打开下载页面
        response.reset();
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition",
                "attachment;filename=" + new String((fileName + ".xls").getBytes(), "iso-8859-1"));
        ServletOutputStream out = response.getOutputStream();
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(is);
            bos = new BufferedOutputStream(out);
            byte[] buff = new byte[2048];
            int bytesRead;
            // Simple read/write loop.
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            if (bis != null)
                bis.close();
            if (bos != null)
                bos.close();
        }
		// OutputStream out = null;
		// try {
		// out = new FileOutputStream(resultUrl);
		// workbook.write(out);
		// } catch (IOException e) {
		// e.printStackTrace();
		// } finally {
		// try {
		// out.close();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// }
	}

	/**
	 * 功能:真正实现导出
	 */
	private static void doExportExcel(String sheetName, String[] headers, Collection<?> dataSet) {

		// 声明一个工作薄
		HSSFWorkbook workbook = new HSSFWorkbook();

		// 生成一个工作表
		HSSFSheet sheet = workbook.createSheet(sheetName);
		// 设置工作表默认列宽度为20个字节
		sheet.setDefaultColumnWidth((short) 20);
		// 创建[表中数据]样式
		HSSFCellStyle dataSetStyle = workbook.createCellStyle();
		// 设置[表中数据]样式
		dataSetStyle.setFillForegroundColor(HSSFColor.GOLD.index);
		dataSetStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		dataSetStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		dataSetStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		dataSetStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		dataSetStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		dataSetStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		dataSetStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		// 创建[表中数据]字体
		HSSFFont dataSetFont = workbook.createFont();
		// 设置[表中数据]字体
		dataSetFont.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
		dataSetFont.setColor(HSSFColor.BLUE.index);
		// 把[表中数据字体]应用到[表中数据样式]
		dataSetStyle.setFont(dataSetFont);

		// 创建标题行-增加样式-赋值
		// HSSFRow titleRow = sheet.createRow(0);
		// HSSFCell titleCell = titleRow.createCell(0);
		// if( StringUtils.isEmpty(titleName)){
		// //titleCell.setCellStyle(titleStyle);
		// }
		// titleCell.setCellValue(titleName);

		// 创建列首-增加样式-赋值
		HSSFRow row = sheet.createRow(0);
		for (short i = 0; i < headers.length; i++) {

			@SuppressWarnings("deprecation")
			HSSFCell cell = row.createCell(i);
			// cell.setCellStyle(headersStyle);
			HSSFRichTextString text = new HSSFRichTextString(headers[i]);
			cell.setCellValue(text);

		}
		String pattern = "yyyy-MM-dd";
		if (dataSet != null) {
			// 创建表中数据行-增加样式-赋值
			Iterator<?> it = dataSet.iterator();
			int index = 1;
			while (it.hasNext()) {
				index++;
				row = sheet.createRow(index);
				Object t = it.next();
				// 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
				Field[] fields = t.getClass().getDeclaredFields();
				for (short i = 0; i < fields.length; i++) {
					@SuppressWarnings("deprecation")
					HSSFCell cell = row.createCell(i);
					cell.setCellStyle(dataSetStyle);
					Field field = fields[i];
					String fieldName = field.getName();
					String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
					try {
						@SuppressWarnings("rawtypes")
						Class tCls = t.getClass();
						@SuppressWarnings("unchecked")
						Method getMethod = tCls.getMethod(getMethodName, new Class[] {});
						Object value = getMethod.invoke(t, new Object[] {});

						// 如果是时间类型,按照格式转换
						String textValue = null;
						if (value instanceof Date) {
							Date date = (Date) value;
							SimpleDateFormat sdf = new SimpleDateFormat(pattern);
							textValue = sdf.format(date);
						} else {
							// 其它数据类型都当作字符串简单处理
							textValue = value.toString();
						}

						// 利用正则表达式判断textValue是否全部由数字组成
						if (textValue != null) {
							Pattern p = Pattern.compile("^\\d+(\\.\\d+)?$");
							Matcher matcher = p.matcher(textValue);
							if (matcher.matches()) {
								// 是数字当作double处理
								cell.setCellValue(Double.parseDouble(textValue));
							} else {
								// 不是数字做普通处理
								cell.setCellValue(textValue);
							}
						}

					} catch (SecurityException e) {
						e.printStackTrace();
					} catch (NoSuchMethodException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					} finally {
						// 清理资源

						// try {
						// // workbook.close();
						// } catch (IOException e) {
						// e.printStackTrace();
						// }
					}
				}
			}
		}
		// OutputStream out = null;
		// try {
		// out = new FileOutputStream(resultUrl);
		// workbook.write(out);
		// } catch (IOException e) {
		// e.printStackTrace();
		// } finally {
		// try {
		// out.close();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// }
	}

	public static void main(String[] args) {
		String sheetName = "图书列表";
		String titleName = "";
		String[] headers = { "图书id", "123", "图书价格", "入库时间" };
		String resultUrl = "E:\\book.xls";
		String pattern = "yyyy-MM-dd";
		ExportExcel.exportExcel(sheetName, titleName, headers, null, resultUrl);

	}
}