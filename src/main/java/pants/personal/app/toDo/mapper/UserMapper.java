package pants.personal.app.toDo.mapper;

import org.springframework.stereotype.Component;
import pants.personal.app.toDo.dto.UserCreateDTO;
import pants.personal.app.toDo.dto.UserReadOnlyDTO;
import pants.personal.app.toDo.model.User;

/**
 * This mapper class transforms a user object into an entity
 * and into read only for the client
 */

@Component
public class UserMapper {

    public User toEntity(UserCreateDTO dto, String hashedPassword) {
        User user = new User();
        user.setEmail(dto.email());
        user.setUsername(dto.username());
        user.setPassword(hashedPassword);
        return user;
    }

    public UserReadOnlyDTO toReadOnly(User user) {
        return new UserReadOnlyDTO(
                user.getUuid(),
                user.getUsername(),
                user.getEmail(),
                user.isActive(),
                user.getCreatedAt()
        );
    }
}
