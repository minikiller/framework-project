package cn.com.rexen.workflow.core.servlet;

import cn.com.rexen.core.util.Assert;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by sunlf on 2015/8/1.
 * 用于显示工作流图片的servlet
 * test address http://localhost:8181/image?processInstanceId=5001&processDefinitionId=fireworks:1:3
 */
public class BpmnImageServlet extends BaseBpmnImageServlet {

    private String processDefinitionId;
    private String processInstanceId;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        InputStream imageStream;
        processDefinitionId = request.getParameter("processDefinitionId");
        Assert.notNull(processDefinitionId);
        processInstanceId = request.getParameter("processInstanceId");
        if (processInstanceId == null)//如果传入一个参数，返回流程图片，不带活动节点
            imageStream = getInputStream(processDefinitionId);
        else
            imageStream = getInputStream(processDefinitionId, processInstanceId);
        response.setContentType("image/jpeg");
        response.setHeader("Pragma", "no-cache");
        OutputStream out = null;
        try {
            out = response.getOutputStream();
            // Copy the contents of the file to the output stream
            byte[] buf = new byte[1024];
            int count = 0;
            while ((count = imageStream.read(buf)) >= 0) {
                try {
                    out.write(buf, 0, count);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            imageStream.close();
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        doGet(request, response);
    }


}

