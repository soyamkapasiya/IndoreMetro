package com.kapasiya.indoremetro.serviceimpl;

import com.kapasiya.indoremetro.entity.Ticket;
import com.kapasiya.indoremetro.repo.TicketRepository;
import com.kapasiya.indoremetro.servicedefinitation.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id).orElse(null);
    }

    @Override
    public Ticket createTicket(Ticket ticket) {
        // Additional validation or business logic can be added here
        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket updateTicket(Long id, Ticket ticket) {
        // Additional validation or business logic can be added here
        ticket.setId(id);
        return ticketRepository.save(ticket);
    }

    @Override
    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }
}