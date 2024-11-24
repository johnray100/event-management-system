package jay.event_management_system.Feedback.Repository;

import jay.event_management_system.Feedback.Model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedBackRepository extends JpaRepository<Feedback, Long> {
}
