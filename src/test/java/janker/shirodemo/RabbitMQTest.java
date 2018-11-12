package janker.shirodemo;

import janker.shirodemo.send.SendMessage;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author : WeiTong
 * @date :  2018/11/7 11:07
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Slf4j
public class RabbitMQTest {

    @Resource
    private SendMessage sendMessage;
    @Test
    public void sendMessage(){
        try {
            for(int i=0;i<20;i++){
                sendMessage.send("第"+i+"消息");
            }
            Thread.sleep(100000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
