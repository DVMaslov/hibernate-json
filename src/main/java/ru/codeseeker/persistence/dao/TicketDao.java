package ru.codeseeker.persistence.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.codeseeker.persistence.model.Ticket;

import java.math.BigDecimal;

public interface TicketDao extends JpaRepository<Ticket, Long> {

    Page<Ticket> findByCostIsLessThan(BigDecimal cost, Pageable pageable);
}
