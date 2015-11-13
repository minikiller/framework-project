package cn.com.rexen.example.jdbc;

import org.apache.camel.ProducerTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunlf on 2015/11/12.
 */
public class RouteInsert {
    private ProducerTemplate template;
    String str = "INSERT INTO public.roffice_news (id, createby, creationdate, updateby, updatedate, version_, content, publishdate, publishpeople, title) VALUES (274, null, '2015-11-05 11:34:49.232000', null, '2015-11-05 11:35:08.462000', 2, 'fsdf', '1970-01-01', '管理员', 'sdfs12345');";
    InputStream is;

    public void setTemplate(ProducerTemplate template) {
        this.template = template;
    }

    public void test() {
        String str = "";
        List<String> strList = new ArrayList<>();
        StringBuffer buf = new StringBuffer();
//        template.sendBody("direct:start", str);
        try {
            is = new java.io.BufferedInputStream(this.getClass().getClassLoader().getResourceAsStream("initial_data.sql"));

//            sql = FileUtils.readLines(new File("classpath:initial_data.sql"));
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            if (is != null) {
                while ((str = reader.readLine()) != null) {
                    strList.add(str);
                }
            }
            System.out.print(buf);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (Throwable ignore) {
            }
        }
        for (String sql : strList) {
            template.sendBody("direct:start", sql);
        }

//        for(String run:sql){

//        }

    }
}
