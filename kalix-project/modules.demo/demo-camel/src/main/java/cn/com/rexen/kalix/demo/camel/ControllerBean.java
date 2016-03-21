package cn.com.rexen.kalix.demo.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.Handler;

/**
 * @类描述：${INPUT}
 * @创建人： sunlingfeng
 * @创建时间：2014/12/15
 * @修改人：
 * @修改时间：
 * @修改备注：
 */
public class ControllerBean {
    private String routeId;

    public String getRouteId() {
        return this.routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    @Handler
    public String startRoute(CamelContext camelContext) throws Exception {
        camelContext.startRoute(routeId);
        return "Batch " + routeId + " started.";
    }
}
