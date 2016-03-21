package cn.com.rexen.kalix.demo.camel;

import javax.naming.Context;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import java.util.Hashtable;

/**
 * Created by sunlf on 2015/8/18.
 */
public class LdapTest {
    public static void main(String[] args) {
        String account = "Manager";
        String password = "secret";
        String root = "dc=maxcrc,dc=com"; // root

        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://localhost:389/" + root);
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, "cn=" + account + "," + root);
        env.put(Context.SECURITY_CREDENTIALS, password);

        DirContext ctx = null;

        try {
            // 链接ldap
            ctx = new InitialDirContext(env);
            System.out.println("ldap认证成功");

            // 3.添加节点
            String newUserName = "user21";
            BasicAttributes attrsbu = new BasicAttributes();
            BasicAttribute objclassSet = new BasicAttribute("objectclass");
            objclassSet.add("person");
//            objclassSet.add("top");
            objclassSet.add("organizationalPerson");
            objclassSet.add("inetOrgPerson");
            attrsbu.put(objclassSet);
            attrsbu.put("sn", newUserName);
            attrsbu.put("cn", newUserName);
            attrsbu.put("uid", newUserName);
            ctx.createSubcontext("uid=31,ou=" + newUserName, attrsbu);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
