package com.notification.notification.service;

import com.notification.notification.model.Notification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;


@Service
public class ProducerService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private static final String EXCHANGE_NAME = "notification_exchange";

    private static final Logger logger = LoggerFactory.getLogger(ProducerService.class);

    private HashMap<String,String> routeKeys = new HashMap<String, String>() {{
        put("app1", "app1.FCM");
        put("app2", "app2.GCM");
        put("app3", "app3.APNS");
    }};

    public boolean produce(Object data, String appId) {
        logger.info("AppId - {}",appId);
        logger.info("Message - {}",data.toString());
        if(appId.equals("") == false && routeKeys.containsKey(appId)){
            logger.info("Sending the message with routing key {}", routeKeys.get(appId));
            rabbitTemplate.convertAndSend(EXCHANGE_NAME, routeKeys.get(appId), data);
            return true;
        }
        else {
            logger.info("Message cannot be sent as no routing key found with appId {}", appId);
            return false;
        }
    }
}