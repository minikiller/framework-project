package cn.com.rexen.core.rest;

import org.apache.camel.util.ObjectHelper;
import org.osgi.framework.BundleContext;
import org.osgi.service.http.HttpContext;
import org.osgi.service.http.HttpService;

import javax.servlet.http.HttpServlet;
import java.util.Dictionary;
import java.util.Hashtable;

/**
 * Created by sunlf on 2015/7/22.
 */
public class ShiroOsgiServletRegisterer   {
    /**
     * The alias is the name in the URI namespace of the Http Service at which the registration will be mapped
     * An alias must begin with slash ('/') and must not end with slash ('/'), with the exception that an alias
     * of the form "/" is used to denote the root alias.
     */
    private String alias;

    private BundleContext bundleContext;

    /**
     * The servlet name.
     */
    private String servletName = "CamelServlet";

    /**
     * Servlet to be registered
     */
    private HttpServlet servlet;

    /**
     * HttpService to register with. Get this with osgi:reference in the blueprint/spring-dm file
     */
    private HttpService httpService;

    private HttpContext httpContext;

    private boolean alreadyRegistered;

    // The servlet will default have to match on uri prefix as some endpoints may do so
    private volatile boolean matchOnUriPrefix = true;

    public void setHttpService(HttpService httpService) {
        this.httpService = httpService;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setServletName(String servletName) {
        this.servletName = servletName;
    }

    public void setServlet(HttpServlet servlet) {
        this.servlet = servlet;
    }

    public void setHttpContext(HttpContext httpContext) {
        this.httpContext = httpContext;
    }

    public void setMatchOnUriPrefix(boolean matchOnUriPrefix) {
        this.matchOnUriPrefix = matchOnUriPrefix;
    }

    public void setBundleContext(BundleContext bundleContext) {
        this.bundleContext = bundleContext;
    }

    public void register() throws Exception {
        ObjectHelper.notEmpty(alias, "alias", this);
        ObjectHelper.notEmpty(servletName, "servletName", this);

        HttpContext actualHttpContext = (httpContext == null)
                ? httpService.createDefaultHttpContext()
                : httpContext;
        final Dictionary<String, String> initParams = new Hashtable<String, String>();
        initParams.put("matchOnUriPrefix", matchOnUriPrefix ? "true" : "false");
        initParams.put("servlet-name", servletName);
        httpService.registerServlet(alias, servlet, initParams, actualHttpContext);
        alreadyRegistered = true;

        /*ServiceReference<WebContainer> serviceReference = bundleContext.getServiceReference(WebContainer.class);
        WebContainer webContainer = bundleContext.getService(serviceReference);*/
//        HttpContext httpContext=webContainer.createDefaultHttpContext();
//        webContainer.registerEventListener(new EnvironmentLoaderListener(),httpContext);

    }

    public void unregister() {
        if (alreadyRegistered) {
            httpService.unregister(alias);
            alreadyRegistered = false;
        }
    }

}
