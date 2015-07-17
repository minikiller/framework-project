package cn.com.rexen.core.swagger;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.mgt.WebSecurityManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by majian on 2015/7/15.
 */
public class LogoutServlet extends HttpServlet {

    private WebSecurityManager securityManager;

    public void setSecurityManager(WebSecurityManager securityManager) {
        this.securityManager = securityManager;
        SecurityUtils.setSecurityManager(securityManager);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        String loginName = request.getParameter("loginName");
        String password = request.getParameter("password");

        Subject subject = SecurityUtils.getSubject();
        subject.logout();
    }
}
