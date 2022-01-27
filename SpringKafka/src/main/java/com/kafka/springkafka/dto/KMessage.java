package com.kafka.springkafka.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(of = {"id", "message", "messageDate"})
public class KMessage {
    private String message;
    private String id = UUID.randomUUID().toString();
    private LocalDate messageDate = LocalDate.now();
}
