package cn.com.rexen.excel.core;

import cn.com.rexen.excel.api.IExcelService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
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

            // POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(excelPath));
            InputStream is = new FileInputStream(excelPath);
            Object wb = null;

            if (excelPath.indexOf(".xlsx") == -1) {
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
    public Object OpenExcel(InputStream is) {
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
        Map<String, Integer> rtnDic = new HashMap<>();

        while (keys.hasMoreElements()) {
            temp = keys.nextElement();

            if (temp != null) {
                configKeys.add(temp.trim());
            } else {
                break;
            }
        }

        while (elements.hasMoreElements()) {
            temp = (String) elements.nextElement();

            if (temp != null) {
                configValues.add(temp.trim());
            } else {
                break;
            }
        }

        for (int idx = 0; idx < colNameList.size(); ++idx) {
            for (int configIndex = 0; configIndex < configKeys.size(); ++configIndex) {
                if (colNameList.get(idx).equals(configValues.get(configIndex))) {
                    rtnDic.put(configKeys.get(configIndex), idx);

                    break;
                }
            }
        }

        return rtnDic;
    }

    @Override
    public Map<String, Object> GetRowMap(Object sheet, int rowIndex, Dictionary<String, Integer> dic) {

        return null;
    }
}
