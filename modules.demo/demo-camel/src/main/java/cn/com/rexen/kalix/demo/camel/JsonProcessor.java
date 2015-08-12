package cn.com.rexen.kalix.demo.camel;

import cn.com.rexen.kalix.demo.camel.model.NewPerson;
import cn.com.rexen.kalix.demo.camel.model.Person;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

/**
 * @类描述：${INPUT}
 * @创建人： sunlingfeng
 * @创建时间：2014/12/2
 * @修改人：
 * @修改时间：
 * @修改备注：
 */
public class JsonProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        Message message = exchange.getIn();
        Person person = message.getBody(Person.class);
        NewPerson newPerson = new NewPerson();
        newPerson.setName(person.getName());
        newPerson.setTwitterName(person.getTwitterName());
        exchange.getIn().setBody(newPerson);
    }
}
