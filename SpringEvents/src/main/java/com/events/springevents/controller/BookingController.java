package com.events.springevents.controller;

import com.events.springevents.controller.request.HotelBookCreateRequest;
import com.events.springevents.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookingController {

    private final ReservationService reservationService;

    @PostMapping
    public void bookHotel(@RequestBody HotelBookCreateRequest hotelBookRequest){
         reservationService.publishReservationEvent(hotelBookRequest);
        System.out.println("User request is processing...-> " + hotelBookRequest);
    }

}
