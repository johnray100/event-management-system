package jay.event_management_system.Tickets.Repository;

import jay.event_management_system.Tickets.Model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketsRepository extends JpaRepository<Ticket, Long> {
}
