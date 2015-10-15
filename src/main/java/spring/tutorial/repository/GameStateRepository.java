package spring.tutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.tutorial.domain.GameState;

/**
 * @author Cristian Ilca, Catalysts Romania on 16-Oct-15.
 */
public interface GameStateRepository extends JpaRepository<GameState, Long>{
    GameState findByRoomId(String roomId);
}
