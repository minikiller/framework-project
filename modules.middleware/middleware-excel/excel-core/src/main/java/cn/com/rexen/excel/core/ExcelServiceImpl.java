package cn.com.rexen.excel.core;

import cn.com.rexen.core.util.SerializeUtil;
import cn.com.rexen.excel.api.IExcelService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * @author chenyanxu
 */
public class ExcelServiceImpl implements IExcelService {
    @Override
    public Object OpenExcel(String excelPath) {
        try {
            InputStream is = new FileInputStream(excelPath);

            return OpenSheet(is, excelPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Object OpenExcel(InputStream is, String fileName) {
        try {

            Object wb = null;

            if (fileName.indexOf(".xlsx") == -1) {
                wb = new HSSFWorkbook(is);
            } else {
                wb = new XSSFWorkbook(is);
            }

            return wb;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Object OpenSheet(Object wb, String sheetName) {
        Workbook theWb = (Workbook) wb;

        return theWb.getSheet(sheetName);
    }

    @Override
    public int GetRowCount(Object sheet) {
        Sheet theSheet = (Sheet) sheet;
        int firstRowNum = theSheet.getFirstRowNum();
        int lastRowNum = theSheet.getLastRowNum();

        if (theSheet.getRow(firstRowNum) != null) {
            return lastRowNum - firstRowNum + 1;
        } else {
            return 0;
        }
    }

    @Override
    public List<String> GetColumnNames(Object sheet, int columnRowIndex) {
        List<String> rtnList = new ArrayList<String>();
        Sheet theSheet = (Sheet) sheet;
        Row row = theSheet.getRow(columnRowIndex);

        for (int colIndex = 0; colIndex < row.getLastCellNum(); ++colIndex) {
            rtnList.add(row.getCell(colIndex).getStringCellValue().trim());
        }

        return rtnList;
    }

    @Override
    public Map<String, Integer> GetColumnDic(Object sheet, int columnRowIndex, Dictionary<String, Object> dic) {

        List<String> colNameList = GetColumnNames(sheet, columnRowIndex);
        List<String> configKeys = new ArrayList<String>();
        List<String> configValues = new ArrayList<String>();
        Enumeration<String> keys = dic.keys();
        Enumeration<Object> elements = dic.elements();
        String temp = null;
        Map<String, Integer> columnMap = new HashMap<>();

        while (keys.hasMoreElements()) {
            temp = keys.nextElement();
            configKeys.add(temp.trim());
        }

        while (elements.hasMoreElements()) {
            temp = (String) elements.nextElement();
            configValues.add(temp.trim());
        }

        for (int idx = 0; idx < colNameList.size(); ++idx) {
            for (int configIndex = 0; configIndex < configKeys.size(); ++configIndex) {
                if (colNameList.get(idx).equals(configValues.get(configIndex))) {
                    columnMap.put(configKeys.get(configIndex), idx);

                    break;
                }
            }
        }


        return columnMap;
    }

    @Override
    public Map<String, Object> GetRowMap(Object sheet, int rowIndex, Map<String, Integer> columnMap) {
        Map<String, Object> rowMap = new HashMap<String, Object>();
        Sheet theSheet = (Sheet) sheet;
        Row row = theSheet.getRow(rowIndex);
        Iterator<Map.Entry<String, Integer>> iterator = columnMap.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            Cell cell = row.getCell(entry.getValue());

            switch (cell.getCellType()) {
                case Cell.CELL_TYPE_STRING:
                    rowMap.put(entry.getKey(), row.getCell(entry.getValue()).getStringCellValue());
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    rowMap.put(entry.getKey(), row.getCell(entry.getValue()).getNumericCellValue());
                    break;
                case Cell.CELL_TYPE_BLANK:
                    rowMap.put(entry.getKey(), null);
                    break;
                case Cell.CELL_TYPE_BOOLEAN:
                    rowMap.put(entry.getKey(), row.getCell(entry.getValue()).getBooleanCellValue());
                    break;
                case Cell.CELL_TYPE_FORMULA:
                    // rowMap.put(entry.getKey(), row.getCell(entry.getValue()).get());
                    break;
            }
        }

        return rowMap;
    }

    @Override
    public String GetJsonRowString(Object sheet, int rowIndex, Map<String, Integer> columnMap) {
        Map rowMap = GetRowMap(sheet, rowIndex, columnMap);

        return SerializeUtil.serializeJson(rowMap);
    }


}
