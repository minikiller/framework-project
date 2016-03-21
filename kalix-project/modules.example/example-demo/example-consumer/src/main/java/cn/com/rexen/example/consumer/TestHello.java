package cn.com.rexen.example.consumer;

import cn.com.rexen.example.api.IHelloWorld;

/**
 * Created by Administrator on 2015-12-30.
 */
public class TestHello {
    IHelloWorld helloWorld;

    public void init() {
        System.out.println(helloWorld.getStr());
    }

    public void setHelloWorld(IHelloWorld helloWorld) {
        this.helloWorld = helloWorld;
    }
}
