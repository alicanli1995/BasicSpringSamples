package com.rabbitmq.rabbitmq.model;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Notification implements Serializable {

    private String notificationId;

    private Date createdDate;

    private Boolean seen;

    private String message;

}
