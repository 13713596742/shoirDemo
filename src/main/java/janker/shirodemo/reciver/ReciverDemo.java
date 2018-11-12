package janker.shirodemo.reciver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

/**
 * @author : WeiTong
 * @date :  2018/11/7 10:43
 */
@Component
@Slf4j
public class ReciverDemo {

    public CountDownLatch latch=new CountDownLatch(1);

    public void receiveMessage(String message){
        log.info("接收到的消息：{}",message);
        latch.countDown();
    }

    public CountDownLatch getLatch(){
        return  latch;
    }

}
