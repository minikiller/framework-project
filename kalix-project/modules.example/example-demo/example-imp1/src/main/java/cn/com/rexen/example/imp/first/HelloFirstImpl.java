package cn.com.rexen.example.imp.first;

import cn.com.rexen.example.api.IHelloWorld;
import org.apache.felix.ipojo.annotations.Component;
import org.apache.felix.ipojo.annotations.Provides;

/**
 * Created by Administrator on 2015-12-30.
 */
@Component
@Provides
public class HelloFirstImpl implements IHelloWorld {
    @Override
    public String getStr() {
        return "it is first impl!";
    }
}
