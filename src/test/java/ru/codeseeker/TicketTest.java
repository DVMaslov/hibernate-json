package ru.codeseeker;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ru.codeseeker.persistence.dao.TicketDao;
import ru.codeseeker.persistence.model.Location;
import ru.codeseeker.persistence.model.Ticket;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.*;

public class TicketTest extends AbstractTest {

    private static final Random random = new Random();
    private static final List<String> CITIES = Collections.unmodifiableList(Arrays.asList(
            "Москва", "Питер", "Смоленск", "Владимир", "Владивосток", "Красноярск", "Муром"
    ));

    @Autowired
    private TicketDao ticketDao;
    @PersistenceContext
    private EntityManager entityManager;

    @Test
    @Transactional
    public void ticketTest() {
        Ticket ticket = createRandomTicket();
        entityManager.flush();
        entityManager.clear();

        Ticket reloadTicket = ticketDao.getOne(ticket.getId());
        Assert.assertNotNull(reloadTicket);
        Assert.assertEquals(ticket.getLocation(), reloadTicket.getLocation());
    }

    private Ticket createRandomTicket() {
        Ticket ticket = new Ticket();
        ticket.setName("ticket " + random.nextInt(100));
        ticket.setCost(BigDecimal.valueOf(random.nextDouble() * 1000));
        Location location = new Location();
        location.setCity(CITIES.get(random.nextInt(CITIES.size())));
        location.setCityType("c.");
        ticket.setLocation(location);
        return ticketDao.save(ticket);
    }
}
