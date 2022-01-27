package com.events.springevents.service;


import com.events.springevents.controller.BookingController;
import com.events.springevents.controller.request.HotelBookCreateRequest;
import com.events.springevents.event.ReservationCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ApplicationEventPublisher applicationEventPublisher;

    @Async
    public void publishReservationEvent(HotelBookCreateRequest hotelBookRequest){
        applicationEventPublisher.publishEvent(new ReservationCreatedEvent(hotelBookRequest));
    }

}
