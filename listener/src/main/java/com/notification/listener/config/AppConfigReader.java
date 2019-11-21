package com.notification.listener.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class AppConfigReader {
    @Value("${notification.queue1}")
    private String app1Queue;
    @Value("${notification.queue2}")
    private String app2Queue;
    @Value("${notification.queue3}")
    private String app3Queue;

}