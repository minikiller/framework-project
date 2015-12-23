/*
 * Copyright (c) 2011, Paul Merlin. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package cn.com.rexen.ext.shiro.web.filter.authc;

import cn.com.rexen.ext.shiro.authc.x509.X509AuthenticationToken;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.security.cert.X509Certificate;

public class X509AuthenticationFilter
        extends AuthenticatingFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(X509AuthenticationFilter.class);

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response)
            throws Exception {
        return executeLogin(request, response);
        /*if (isLoginRequest(request, response)) {
            Subject subject = SecurityUtils.getSubject();
            Session shiro = subject.getSession();
            System.out.println("sessionid is " + shiro.getId());
            if (subject.getPrincipal() == null)
                return executeLogin(request, response);
            else
                return true;
        } else
            return true;*/
    }

    @Override
    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) {
        X509Certificate[] clientCertChain = (X509Certificate[]) request.getAttribute("javax.servlet.request.X509Certificate");
        LOGGER.info("X509AuthFilter.createToken() cert chain is {}", clientCertChain);
        if (clientCertChain == null || clientCertChain.length < 1) {
            throw new ShiroException("Request do not contain any X509Certificate");
        }
        return new X509AuthenticationToken(clientCertChain, getHost(request));
    }

    // @Override
//    protected boolean onLoginSuccess(AuthenticationToken token,
//                                     Subject subject, ServletRequest request, ServletResponse response)
//            throws Exception {
//        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
//        {
//            Session session= SecurityUtils.getSubject().getSession();
//            String name=String.valueOf(session.getAttribute(PermissionConstant.SYS_CURRENT_USERNAME));
//            httpServletResponse.setContentType("application/json");
//            httpServletResponse.setCharacterEncoding("UTF-8");
//            httpServletResponse.sendRedirect("index.jsp");
//            PrintWriter out = httpServletResponse.getWriter();
//            out.println("{success:true,location:'/kalix/index.jsp',message:'登入成功',user:{name:'" + name + "',token:'" + session.getId() + "'}}");
//            out.flush();
//            out.close();
//        }
//        return false;
//    }

}
