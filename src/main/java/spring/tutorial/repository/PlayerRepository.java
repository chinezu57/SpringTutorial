package spring.tutorial.repository;

import spring.tutorial.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * @author Cristian Ilca, Catalysts Romania on 16-Oct-15.
 */
public interface PlayerRepository extends JpaRepository<Player, Long> {
    Player findByName(String name);
}
