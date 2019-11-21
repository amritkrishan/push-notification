package com.notification.notification.resource;

import com.notification.notification.model.Notification;
import com.notification.notification.service.ProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notification")
public class NotificationResource {

    private static final Logger logger = LoggerFactory.getLogger(NotificationResource.class);

    @Autowired
    private ProducerService producerService;

    @PostMapping(path = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> createPushNotification(
            @RequestHeader(name = "user_id", required = true) String userId,
            @RequestHeader(name = "application_id", required = false, defaultValue = "") String appId,
            @RequestBody Notification notification)
            throws Exception {
        String messageToQueue = userId + "|" + notification.getTitle() + "|" + notification.getMessage();
        logger.info("Message to Queue - {}",messageToQueue);
        boolean result = producerService.produce(notification, appId);
        if(result)
            return ResponseEntity.ok("Message sent successfully");
        else
            return ResponseEntity.ok("Message not sent successfully");
    }
}
