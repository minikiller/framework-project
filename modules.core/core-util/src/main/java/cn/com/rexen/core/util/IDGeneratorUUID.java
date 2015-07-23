package cn.com.rexen.core.util;

/**
 * Created by majian on 2015/7/23.
 */
public final  class IDGeneratorUUID {
    public static String generatorId() {
        return java.util.UUID.randomUUID().toString().replace("-", "");
    }

    private IDGeneratorUUID() {
        super();
    }
}
