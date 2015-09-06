package cn.com.rexen.example.sequoiadb;

import com.sequoiadb.base.CollectionSpace;
import com.sequoiadb.base.DBCollection;
import com.sequoiadb.base.DBCursor;
import com.sequoiadb.base.Sequoiadb;
import com.sequoiadb.exception.BaseException;
import org.bson.BSONObject;
import org.bson.BasicBSONObject;
import org.bson.util.JSON;
import org.apache.commons.codec.binary.Base64;
import org.junit.Test;



/**
 * Created by sunlf on 2015/9/1.
 */
public class TestSequcaDb {
    private Base64 base64Encoder = new Base64();
    @Test
    public void insert() throws Exception {
        String connString = "172.17.2.95:11810";
        try {
            // 建立 SequoiaDB 数据库连接
            Sequoiadb sdb = new Sequoiadb(connString, "adbadmin", "123456");
        CollectionSpace db = sdb.getCollectionSpace("space");
        DBCollection cl = db.getCollection("collection");
//        <p>// 创建一个插入的 bson 对象
         BSONObject obj = new BasicBSONObject(); obj.put("name", "jack"); obj.put("age", 26);
         cl.insert(obj); }
        catch (BaseException e) {
            System.out.println("Sequoiadb driver error, error description:" + e.getErrorType());
        }

    }

    @Test
    public void list() throws Exception{
        String connString = "172.17.2.95:11810";
        try {
            // 建立 SequoiaDB 数据库连接
            Sequoiadb sdb = new Sequoiadb(connString, "adbadmin", "123456");
            // 获取所有 Collection 信息，并打印出来
            DBCursor cursor = sdb.listCollections();
            while(cursor.hasNext()) {
                System.out.println(cursor.getCurrent());
            }
        } catch (BaseException e) {
            System.out.println("Sequoiadb driver error, error description:" + e.getErrorType());
        }
    }

    @Test
    public void query() throws Exception {
        String connString = "172.17.2.95:11810";
        try {
            // 建立 SequoiaDB 数据库连接
            Sequoiadb sdb = new Sequoiadb(connString, "adbadmin", "123456");
            CollectionSpace db = sdb.getCollectionSpace("space");
            DBCollection cl = db.getCollection("collection");

            // 定义一个游标对象
            DBCursor cursor;
            BSONObject queryCondition = new BasicBSONObject();
            queryCondition = (BSONObject) JSON.parse("{age:{$ne:20}}");
// 查询所有记录，并把查询结果放在游标对象中
            cursor = cl.query(queryCondition, null, null, null);
// 从游标中显示所有记录
            while (cursor.hasNext()) {
                BSONObject record = cursor.getNext();
                /*BasicBSONDecoder decoder = new BasicBSONDecoder();
                BSONObject bsonObject = decoder.readObject(record);*/
                String json_string = record.toString();
                String name = (String) record.get("name");
                System.out.println("name=" + name);
            }
        }
        catch (BaseException e) {
            System.out.println("Sequoiadb driver error, error description:" + e.getErrorType());
        }
    }

    @Test
    public void testBinary() throws Exception
    {
        String connString = "172.17.2.95:11810";
        try {
            // 建立 SequoiaDB 数据库连接
            Sequoiadb sdb = new Sequoiadb(connString, "adbadmin", "123456");
            CollectionSpace db = sdb.getCollectionSpace("space");
            DBCollection cl = db.getCollection("collection");
            String str="hello";
            byte[] srtbyte = str.getBytes();
            String string=base64Encoder.encodeAsString(srtbyte);
            BSONObject obj = new BasicBSONObject(); obj.put("$binary", string);
            obj.put("$type", 26);
            cl.insert(obj);
        }
        catch (BaseException e) {
            System.out.println("Sequoiadb driver error, error description:" + e.getErrorType());
        }

    }


}
