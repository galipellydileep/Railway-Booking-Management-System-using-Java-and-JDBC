package com.railway.service;

import com.railway.model.Ticket;
import com.railway.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RailwayService {

    private final TicketRepository repository;

    public RailwayService(TicketRepository repository) {
        this.repository = repository;
    }

    // Save ticket to Railway MySQL
    public void saveTicket(Ticket ticket) {
        repository.save(ticket);
    }

    // Fetch all tickets
    public List<Ticket> getAllTickets() {
        return repository.findAll();
    }

    // Fetch ticket by ID
    public Ticket getTicketById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));
    }
}
