package pants.personal.app.toDo.service;


import pants.personal.app.toDo.core.exception.EntityAlreadyExistsException;
import pants.personal.app.toDo.dto.UserCreateDTO;
import pants.personal.app.toDo.dto.UserReadOnlyDTO;
import pants.personal.app.toDo.model.User;

import java.util.UUID;

/**
 * Interface representing the contract for user-related services.
 * Provides a set of operations for managing user data and behaviors.
 * The implementing class is expected to define the specific logic
 * for each operation defined in this interface.
 */
public interface IUserService {

    UserReadOnlyDTO createUser(UserCreateDTO dto) throws EntityAlreadyExistsException;

    UserReadOnlyDTO getUserByUuid(UUID uuid);
}
