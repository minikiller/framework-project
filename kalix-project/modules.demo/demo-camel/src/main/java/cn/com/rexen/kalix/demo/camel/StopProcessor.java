package cn.com.rexen.kalix.demo.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 * @类描述：${INPUT}
 * @创建人： sunlingfeng
 * @创建时间：2014/12/15
 * @修改人：
 * @修改时间：
 * @修改备注：
 */
public class StopProcessor implements Processor {
    private String routeId;

    public String getRouteId() {
        return this.routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public void process(Exchange exchange) throws Exception {
        CamelContext camelContext = exchange.getContext();
        // remove myself from the in flight registry so we can stop this route without trouble
        camelContext.getInflightRepository().remove(exchange);
        // stop the route
        camelContext.stopRoute(routeId);
    }
}
