package com.railway.controller;

import com.railway.model.Platform1;
import com.railway.service.RailwayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
public class RailwayController {

    @Autowired
    private RailwayService service;

    private Platform1 user;

    @PostMapping("/membership")
    public String createMembership(@RequestParam String name,
                                   @RequestParam long mobile) {
        user = new Platform1();
        user.setCustomername(name);
        user.setMobile(mobile);
        return "Membership created successfully";
    }

    @PostMapping("/book")
    public String bookTicket(@RequestParam String destination) {
        user.setDestlocation(destination);
        service.saveTicket(user);
        return user.ticketDetails(LocalDate.now());
    }

    @PostMapping("/station")
    public String stationDetails() {
        return Platform1.stationDetails();
    }

    @PostMapping("/timings")
    public String timings() {
        return service.trainTimings();
    }

    @PostMapping("/viewTicket")
    public String viewTicket() {
        return service.viewLatestTicket(user.getMobile());
    }
}
