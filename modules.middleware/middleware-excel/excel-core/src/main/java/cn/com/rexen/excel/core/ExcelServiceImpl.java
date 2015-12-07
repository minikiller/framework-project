package cn.com.rexen.excel.core;

import cn.com.rexen.excel.api.IExcelService;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by lenovo on 2015/12/7.
 */
public class ExcelServiceImpl implements IExcelService {
    @Override
    public Object OpenExcel(String excelPath) {
        try {
            POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(excelPath));
            HSSFWorkbook wb = new HSSFWorkbook(fs);

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
        HSSFWorkbook theWb = (HSSFWorkbook) wb;

        return theWb.getSheet(sheetName);
    }

    @Override
    public int GetRowCount(Object sheet) {
        HSSFSheet theSheet = (HSSFSheet) sheet;

        return theSheet.getLastRowNum() - theSheet.getFirstRowNum();
    }
}
