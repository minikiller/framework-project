package cn.com.rexen.core.swagger;

import cn.com.rexen.core.util.JNDIHelper;
import org.apache.shiro.web.env.WebEnvironment;
import org.apache.shiro.web.filter.mgt.FilterChainResolver;
import org.apache.shiro.web.mgt.WebSecurityManager;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.apache.shiro.web.util.WebUtils;

import java.io.IOException;

/**
 * Created by sunlf on 2015/7/10.
 */
public class TestFilter extends AbstractShiroFilter {
    private WebSecurityManager securityManager;

    public void setSecurityManager(WebSecurityManager securityManager) {
        this.securityManager = securityManager;
    }

    /*@Override
    public void init(FilterConfig filterConfig) throws ServletException {
        SecurityUtils.setSecurityManager(securityManager);
    }*/

    /* @Override
     public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
         HttpServletRequest httpServletRequest = (HttpServletRequest) request;
         HttpServletResponse httpServletResponse = (HttpServletResponse) response;
         String userName = httpServletRequest.getHeader("SHIRO_SECURITY_USERNAME");
         System.out.println("filter is activate!" + userName);
         Subject subject = SecurityUtils.getSubject();
         UsernamePasswordToken token = new UsernamePasswordToken("qwer", "123");
         try {
             subject.login(token);
             if (subject.isAuthenticated()) {
                 System.out.println("dsdff");
                 httpServletResponse.setCharacterEncoding("UTF-8");
                 PrintWriter out = httpServletResponse.getWriter();
                 out.println("{success:true,message:'登入成功'}");
                 out.flush();
                 out.close();
             }
             if(subject.isPermitted("save")){
                 System.out.println("hello");
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
 //        chain.doFilter(httpServletRequest, response);
     }
 */
    @Override
    public void destroy() {

    }

    @Override
    public void init() throws Exception {
        WebEnvironment env = WebUtils.getRequiredWebEnvironment(getServletContext());
        try {
            securityManager = JNDIHelper.getJNDIServiceForName(WebSecurityManager.class.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
        super.setSecurityManager(securityManager);
        FilterChainResolver resolver = env.getFilterChainResolver();
        if (resolver != null) {
            setFilterChainResolver(resolver);
        }
    }
}
