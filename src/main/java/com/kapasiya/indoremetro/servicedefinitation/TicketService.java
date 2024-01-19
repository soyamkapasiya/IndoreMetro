package com.kapasiya.indoremetro.servicedefinitation;

import com.kapasiya.indoremetro.entity.Ticket;

import java.util.List;

public interface TicketService {
    List<Ticket> getAllTickets();
    Ticket getTicketById(Long id);
    Ticket createTicket(Ticket ticket);
    Ticket updateTicket(Long id, Ticket ticket);
    void deleteTicket(Long id);
}
