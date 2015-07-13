package cn.com.rexen.core.impl.cache;

import cn.com.rexen.core.api.cache.ICacheManager;

/**
 * Created by sunlf on 2015/7/10.
 */
public class TestCache {
    ICacheManager cacheManager;

    public void setCacheManager(ICacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    public void init() {
        cacheManager.save("test", "dfdfdf");
    }
}
