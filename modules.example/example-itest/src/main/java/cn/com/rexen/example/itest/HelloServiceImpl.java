package cn.com.rexen.example.itest;

/**
 * Created by zcx2001 on 2015-03-09.
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String getMessage() {
        return "Hello Pax!";
    }
}
