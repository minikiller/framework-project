package cn.com.rexen.excel.api;

import java.io.InputStream;
import java.util.Dictionary;
import java.util.List;
import java.util.Map;

/**
 * @author chenyanxu
 */
public interface IExcelService {
    Object OpenExcel(String excelPath);

    Object OpenExcel(InputStream is, String fileName);

    Object OpenSheet(Object wb, String sheetName);

    int GetRowCount(Object sheet);

    List<String> GetColumnNames(Object sheet, int columnRowIndex);

    Map<String, Integer> GetColumnDic(Object sheet, int columnRowIndex, Dictionary<String, Object> dic);

    Map<String, Object> GetRowMap(Object sheet, int rowIndex, Map<String, Integer> columnMap);

    String GetJsonRowString(Object sheet, int rowIndex, Map<String, Integer> columnMap);

    Map<String, Object> GetExcelFromJson(String jsonStr);
}
