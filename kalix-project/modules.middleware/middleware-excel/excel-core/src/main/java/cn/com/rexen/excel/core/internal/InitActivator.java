package cn.com.rexen.excel.core.internal;

//import cn.com.rexen.core.util.ConfigUtil;
//import cn.com.rexen.excel.api.IExcelService;
//import cn.com.rexen.excel.core.ExcelServiceImpl;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

//import java.util.Dictionary;
//import java.util.List;
//import java.util.Map;

/**
 * Created by sunlf on 14-3-23.
 */
public class InitActivator implements BundleActivator {
    @Override
    public void start(BundleContext bundleContext) throws Exception {
//        IExcelService ies = new ExcelServiceImpl();
//        Object wb = ies.OpenExcel("D:\\test.xls");
//        Object sheet = ies.OpenSheet(wb, "Sheet1");
//
//        int rc = ies.GetRowCount(sheet);
//        List<String> colNames = ies.GetColumnNames(sheet, 0);
//
//        Dictionary dictionary = ConfigUtil.getAllConfig("ConfigContractColumnMap");
//
//        Map columnMap = ies.GetColumnDic(sheet, 0, dictionary);
//        Map rowMap=ies.GetRowMap(sheet, 1, columnMap);
//
//        //ContractBean obj = SerializeUtil.unserializeJson(SerializeUtil.serializeJson(rowMap), ContractBean.class);
//
//        System.out.println(rc);
//        System.out.println(colNames.toString());
//        System.out.println(ies.GetJsonRowString(sheet, 1, columnMap));
//        System.out.println(ies.GetJsonRowString(sheet,2,columnMap));
//        System.out.println(ies.GetJsonRowString(sheet,3,columnMap));
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {

    }
}
