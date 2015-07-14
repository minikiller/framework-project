package cn.com.rexen.core.swagger;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.mgt.WebSecurityManager;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sunlf on 2015/7/10.
 */
public class TestFilter implements Filter {
    private WebSecurityManager securityManager;

    public void setSecurityManager(WebSecurityManager securityManager) {
        this.securityManager = securityManager;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        SecurityUtils.setSecurityManager(securityManager);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        String userName = httpServletRequest.getHeader("SHIRO_SECURITY_USERNAME");
        System.out.println("filter is activate!" + userName);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("wewe", "1234");
        try {
            /*subject.login(token);
            if (subject.isAuthenticated()) {
                System.out.println("dsdff");
                httpServletResponse.setCharacterEncoding("UTF-8");
                PrintWriter out = httpServletResponse.getWriter();
                out.println("{success:true,message:'登入成功'}");
                out.flush();
                out.close();
            }*/
        } catch (Exception e) {
            e.printStackTrace();
        }
        chain.doFilter(httpServletRequest, response);
    }

    @Override
    public void destroy() {

    }
}
