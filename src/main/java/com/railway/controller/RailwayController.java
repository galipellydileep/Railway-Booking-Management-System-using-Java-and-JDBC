package com.railway.controller;

import com.railway.model.Ticket;
import com.railway.service.RailwayService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/railway")
public class RailwayController {

    private final RailwayService service;

    public RailwayController(RailwayService service) {
        this.service = service;
    }

    // 1️⃣ Book Ticket
    @PostMapping("/book")
    public String bookTicket(
            @RequestParam String customerName,
            @RequestParam String mobile,
            @RequestParam String currentLocation,
            @RequestParam String destination
    ) {
        Ticket ticket = new Ticket();
        ticket.setCustomerName(customerName);
        ticket.setMobile(mobile);
        ticket.setCurrentLocation(currentLocation);
        ticket.setDestination(destination);
        ticket.setBookingDate(LocalDate.now());

        service.saveTicket(ticket);

        return "Ticket booked successfully";
    }

    // 2️⃣ Health check
    @GetMapping("/status")
    public String status() {
        return "Railway Booking Service is running";
    }
}
