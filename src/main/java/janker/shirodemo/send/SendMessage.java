package janker.shirodemo.send;

import janker.shirodemo.ShiroDemoApplication;
import janker.shirodemo.reciver.ReciverDemo;
import javafx.application.Application;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author : WeiTong
 * @date :  2018/11/7 11:25
 */
@Component
@Slf4j
public class SendMessage {

    private final RabbitTemplate rabbitTemplate;
    private final ReciverDemo receiver;

    public SendMessage(ReciverDemo receiver, RabbitTemplate rabbitTemplate) {
        this.receiver = receiver;
        this.rabbitTemplate = rabbitTemplate;
    }

    public void send(String message) throws Exception {
        log.info("Sending message...");
        rabbitTemplate.convertAndSend(ShiroDemoApplication.queueName, message);
        receiver.getLatch().await(1000, TimeUnit.MILLISECONDS);
    }


}
