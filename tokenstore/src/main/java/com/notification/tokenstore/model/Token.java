package com.notification.tokenstore.model;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "token")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Token {

    @Column(name = "userId")
    private Integer userId;

    @Column(name = "appId")
    private String appId;

    @Column(name = "deviceToken")
    private String deviceToken;


}