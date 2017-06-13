package com.it7890.orange.manage.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XlsUtil {
	private final static Logger logger = LoggerFactory.getLogger(XlsUtil.class);

	public static HSSFWorkbook export(String[]... ss) {
		// 产生工作簿对象
		HSSFWorkbook workbook = null;
		// 产生工作表对象
		try {
			workbook = new HSSFWorkbook();
			HSSFSheet sheet = workbook.createSheet();
			for (int i = 0; i < ss[0].length; i++) {
				HSSFRow row = sheet.createRow((int) i);// 创建一行
				for (int j = 0; j < ss.length; j++) {
					HSSFCell cell = row.createCell(j);// 创建一列
					cell.setCellType(HSSFCell.CELL_TYPE_STRING);
					cell.setCellValue(ss[j][i]);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("XlsUtil.export error,please check param"
					+ e.getMessage());
		}
		return workbook;
	}

	public static String[][] imports(FileInputStream fis) {
		String[][] ss = null;
		try {
			HSSFWorkbook wb = new HSSFWorkbook(new POIFSFileSystem(fis));
			HSSFSheet sheet = wb.getSheetAt(0);
			int count = sheet.getLastRowNum();
			int cellCount = sheet.getRow(0).getLastCellNum();
			ss = new String[count][cellCount + 1];
			for (int i = 0; i <= count; i++) {
				HSSFRow row = sheet.getRow(i);
				for (int j = 0; j <= cellCount; j++) {
					if (row.getCell(j) != null) { // add this condition
						switch (row.getCell(j).getCellType()) {
						case HSSFCell.CELL_TYPE_FORMULA:
							ss[i][j] = "FORMULA ";
							break;
						case HSSFCell.CELL_TYPE_NUMERIC: {
							ss[i][j] = String.valueOf(row.getCell(j)
									.getNumericCellValue());
						}
							break;
						case HSSFCell.CELL_TYPE_STRING:
							ss[i][j] = row.getCell(j).getStringCellValue();
							break;
						case HSSFCell.CELL_TYPE_BLANK:
							ss[i][j] = "";
							break;
						default:
							ss[i][j] = "";
							break;
						}
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("XlsUtil.import error,please check param"
					+ e.getMessage());
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return ss;
	}

	
	//excel 导出
	public static void excelExport(List<String[]> list, String[] title,
			HttpServletResponse response) {
		// 声明一个工作簿
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 创建一个工作表
		HSSFSheet sheet = workbook.createSheet();
		// 设置表格默认列宽度为15个字节
		sheet.setDefaultColumnWidth((int) 15);
		// 生成一个样式
		HSSFCellStyle style = workbook.createCellStyle();
		// 设置这些样式
		style.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		// 生成另一个字体
		HSSFFont font = workbook.createFont();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
		// 把字体应用到当前的样式
		style.setFont(font);

		// 产生表格标题行
		HSSFRow row = sheet.createRow(0);
		for (int i = 0; i < title.length; i++) {
			HSSFCell cell = row.createCell((int) i);
			cell.setCellStyle(style);
			HSSFRichTextString text = new HSSFRichTextString(title[i]);
			cell.setCellValue(text);
		}
		for (int i = 0; i < list.size(); i++) {
			String[] currentDevice = list.get(i);
			HSSFRow currentrow = sheet.createRow(i + 1);
			for (int j = 0; j < title.length; j++) {
				HSSFCell cell = currentrow.createCell(j);
				cell.setCellStyle(style);
				HSSFRichTextString text = new HSSFRichTextString(
						currentDevice[j] == null ? "" : currentDevice[j]);
				cell.setCellValue(text);
			}
		}
		try {

			OutputStream fOut = response.getOutputStream();
			workbook.write(fOut);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//excel导入
	public static List<Map<String, Object>> excelimport(InputStream fis) {

		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
		HSSFWorkbook wb;
		try {
			wb = new HSSFWorkbook(new POIFSFileSystem(fis));
			Sheet sheet = wb.getSheetAt(0);

			// 日期格式化
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			// 数字格式化
			DecimalFormat df = new DecimalFormat("##");
			// 循环xls中的每个表格
			Row firstRow = sheet.getRow(0);

			for (int i = sheet.getFirstRowNum() + 1; i <= sheet.getLastRowNum(); i++) {
				Row row = sheet.getRow(i);
				Map<String, Object> rowMap = new HashMap<String, Object>();

				for (int k = 0; k < row.getLastCellNum(); k++) {
					Cell cell = row.getCell(k);
					if (null == cell) {
						continue;
					}
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_NUMERIC:
						double value_d = cell.getNumericCellValue();
						long value_l = (long) cell.getNumericCellValue();
						if (value_d == value_l)
							rowMap.put(
									firstRow.getCell(k).getStringCellValue(),
									String.valueOf(value_l));
						else
							rowMap.put(
									firstRow.getCell(k).getStringCellValue(),
									String.valueOf(value_d));
						break;
					case Cell.CELL_TYPE_STRING:
						rowMap.put(firstRow.getCell(k).getStringCellValue(),
								cell.getStringCellValue());
						break;
					case Cell.CELL_TYPE_BLANK:
						break;
					default:
						rowMap.put(firstRow.getCell(k).getStringCellValue(),
								cell.toString());
						break;
					}
				}
				// 是否空行
				if (rowMap.size() > 0) {
					resultList.add(rowMap);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resultList;
	}

}
