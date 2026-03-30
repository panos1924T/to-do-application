package pants.personal.app.toDo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pants.personal.app.toDo.model.User;

import java.util.Optional;
import java.util.UUID;

/**
 * This interface provides the basic CRUD for the user entity
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUuid(UUID uuid);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    Optional<User> findByUsername(String username);
}