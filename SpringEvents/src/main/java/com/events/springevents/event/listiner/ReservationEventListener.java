package com.events.springevents.event.listiner;


import com.events.springevents.event.ReservationCreatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ReservationEventListener {

    @EventListener
    public void reservationEventHandler(ReservationCreatedEvent reservationCreatedEvent) throws InterruptedException {
        Thread.sleep(2000L);
        System.out.println("From EventListener ->  " + reservationCreatedEvent.getSource().toString());
    }

}
