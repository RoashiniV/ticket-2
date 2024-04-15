package com.java.ticket.Service;

import java.util.List;

// import com.java.ticket.model.Ticket;
// import com.java.ticket.repository.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.ticket.Model.Ticket;
import com.java.ticket.Repository.TicketRepo;

@Service
public class TicketService {

    private final TicketRepo ticketRepo;

    @Autowired
    public TicketService(TicketRepo ticketRepo) {
        this.ticketRepo = ticketRepo;
    }

    public Ticket bookTicket(Ticket ticket) {
        // Add logic to book a ticket
        return ticketRepo.save(ticket);
    }

    public List<Ticket> getAllTickets() {
        return ticketRepo.findAll();
    }

    public Ticket getTicketById(Long id) {
        return ticketRepo.findById(id).orElse(null);
    }

    public boolean cancelTicket(Long id) {
        Ticket ticket = ticketRepo.findById(id).orElse(null);
        if (ticket != null) {
            ticketRepo.deleteById(id);
            return true; // Return true if ticket is canceled successfully
        } else {
            return false; // Return false if ticket with the given ID does not exist
        }
    }
    
    
    // Add other methods as needed
}
