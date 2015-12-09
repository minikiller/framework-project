package cn.com.rexen.excel.core.internal;

import cn.com.rexen.core.util.ConfigUtil;
import cn.com.rexen.excel.api.IExcelService;
import cn.com.rexen.excel.core.ExcelServiceImpl;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.xml.sax.SAXException;

import java.util.Dictionary;
import java.util.List;
import java.util.Map;

/**
 * Created by sunlf on 14-3-23.
 */
public class InitActivator implements BundleActivator {
    @Override
    public void start(BundleContext bundleContext) throws Exception {
        IExcelService ies = new ExcelServiceImpl();
        Object wb = ies.OpenExcel("D:\\test.xls");
        Object sheet = ies.OpenSheet(wb, "Sheet1");

        int rc = ies.GetRowCount(sheet);
        List<String> colNames = ies.GetColumnNames(sheet, 0);

        Dictionary dictionary = ConfigUtil.getAllConfig("ConfigContractColumnMap");

        Map rtnDic = ies.GetColumnDic(sheet, 0, dictionary);

        System.out.println(rc);
        System.out.println(colNames.toString());
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {

    }
}
