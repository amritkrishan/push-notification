package com.notification.listener.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Notification {

    private Payload payload;
    private String title;
    private String message;
}
