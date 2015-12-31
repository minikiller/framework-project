package cn.com.rexen.example.imp.second;

import cn.com.rexen.example.api.IHelloWorld;

/**
 * Created by Administrator on 2015-12-30.
 */
public class HelloSecondmpl implements IHelloWorld {
    @Override
    public String getStr() {
        return "it is second impl!";
    }
}
