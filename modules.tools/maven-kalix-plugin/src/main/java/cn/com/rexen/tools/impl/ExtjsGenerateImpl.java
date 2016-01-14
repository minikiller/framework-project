package cn.com.rexen.tools.impl;

import org.stringtemplate.v4.ST;

import java.io.File;
import java.util.Map;

/**
 * Created by sunlf on 2015/9/18.
 * 前台extjs代码生成实现类
 */
public class ExtjsGenerateImpl extends AbstractGenernateImpl {

    //需要替换名字的java类名
    String activatorFileName = "InitActivator.java";

    //需要替换名字的js文件名
//    String searchFormControllerFileName = "%sSearchFormController.js";
//    String formControllerFileName = "%sFormController.js";
    String gridControllerFileName = "%sGridController.js";

    String modelFileName = "%sModel.js";
    String storeFileName = "%sStore.js";
    String viewModelFileName = "%sViewModel.js";

    String mainFileName = "Main.js";
    String windowFileName = "%sWindow.js";
    String viewWindowFileName = "%sViewWindow.js";
    String searchFormFileName = "%sSearchForm.js";
    String gridFileName = "%sGrid.js";

    public ExtjsGenerateImpl(Map<String, String> attributes, File inputDir, File outputDir) {
        super(attributes, inputDir, outputDir, "extjs");
        fileMap.put("InitActivator", "//" + moduleName + "//internal//" + activatorFileName);
        //js process
//        fileMap.put("SearchFormController", "//controller//" + String.format(searchFormControllerFileName, beanName));
//        fileMap.put("FormController", "//controller//" + String.format(formControllerFileName,beanName));
        fileMap.put("GridController", "//controller//" + String.format(gridControllerFileName,beanName));

        fileMap.put("Model", "//model//" + String.format(modelFileName,beanName));
        fileMap.put("Store", "//store//" + String.format(storeFileName,beanName));
        fileMap.put("ViewModel", "//viewModel//" + String.format(viewModelFileName, beanName));

        fileMap.put("Main", "//" + mainFileName);
        fileMap.put("Window", "//view//" + String.format(windowFileName, beanName));
        fileMap.put("ViewWindow", "//view//" + String.format(viewWindowFileName, beanName));
        fileMap.put("SearchForm", "//view//" + String.format(searchFormFileName, beanName));
        fileMap.put("Grid", "//view//" + String.format(gridFileName,beanName));
    }

    @Override
    public void genResources() {

    }

    @Override
    public void setAttributes(Map<String, String> attributes){this.attributes = attributes;};

}
