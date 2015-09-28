package cn.com.rexen.tools.impl;

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
    String controllerFileName = "%sController.js";
    String formControllerFileName = "%sFormController.js";
    String gridControllerFileName = "%sGridController.js";

    String modelFileName = "%sModel.js";
    String storeFileName = "%sStore.js";
    String viewmodelFileName = "%sViewModel.js";

    String beanFileName = "%s.js";
    String addFormFileName = "%sAddForm.js";
    String editFormFileName = "%sEditForm.js";
    String gridFileName = "%sGrid.js";

    public ExtjsGenerateImpl(Map<String, String> attributes, File inputDir, File outputDir) {
        super(attributes, inputDir, outputDir, "extjs");
        fileMap.put("InitActivator", "//" + moduleName + "//internal//" + activatorFileName);
        //js process
        fileMap.put("Controller", "//controller//" + String.format(controllerFileName,beanName));
        fileMap.put("FormController", "//controller//" + String.format(formControllerFileName,beanName));
        fileMap.put("GridController", "//controller//" + String.format(gridControllerFileName,beanName));

        fileMap.put("Model", "//model//" + String.format(modelFileName,beanName));
        fileMap.put("Store", "//store//" + String.format(storeFileName,beanName));
        fileMap.put("ViewModel", "//viewModel//" + String.format(viewmodelFileName,beanName));

        fileMap.put("bean", "//view//" + String.format(beanFileName,beanName));
        fileMap.put("AddForm", "//view//" + String.format(addFormFileName,beanName));
        fileMap.put("EditForm", "//view//" + String.format(editFormFileName,beanName));
        fileMap.put("Grid", "//view//" + String.format(gridFileName,beanName));
    }

    @Override
    public void genResources() {

    }


}
