package cn.com.rexen.example.imp.first;

import cn.com.rexen.example.api.IHelloWorld;

/**
 * Created by Administrator on 2015-12-30.
 */
public class HelloFirstImpl implements IHelloWorld {
    @Override
    public String getStr() {
        return "it is first impl!";
    }
}
