package com.kapasiya.indoremetro.repo;

import com.kapasiya.indoremetro.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    // Additional custom queries can be added here if needed
}