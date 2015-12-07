package cn.com.rexen.excel.api;

import java.io.InputStream;

/**
 * Created by lenovo on 2015/12/7.
 */
public interface IExcelService {
    Object OpenExcel(String excelPath);

    Object OpenExcel(InputStream is);

    Object OpenSheet(Object wb, String sheetName);

    int GetRowCount(Object sheet);
}
