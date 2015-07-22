package cn.com.rexen.example.pax.cdi.impl;

import cn.com.rexen.example.pax.cdi.model.SourceUser;
import cn.com.rexen.example.pax.cdi.model.TargetUser;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.dozer.config.BeanContainer;
import org.dozer.osgi.OSGiClassLoader;
import org.osgi.framework.BundleContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunlf on 2015/7/21.
 */
public class TestDozer {
    private Mapper mapper;
    private BundleContext bundleContext;

    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }

    public void init(){
        OSGiClassLoader classLoader = new OSGiClassLoader(bundleContext);
        BeanContainer.getInstance().setClassLoader(classLoader);
        SourceUser source=new SourceUser();
        source.setName("hloo");
        List<String> mapFile=new ArrayList<>();
        mapFile.add("mapper.xml");
//        Mapper mapper = new DozerBeanMapper(mapFile);
        TargetUser menuBean = mapper.map(source, TargetUser.class);
        System.out.print(menuBean.getText());
    }

    public void setBundleContext(BundleContext bundleContext) {
        this.bundleContext = bundleContext;
    }
}
