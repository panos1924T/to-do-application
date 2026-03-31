package pants.personal.app.toDo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pants.personal.app.toDo.core.exception.EntityAlreadyExistsException;
import pants.personal.app.toDo.core.exception.EntityNotFoundException;
import pants.personal.app.toDo.dto.UserCreateDTO;
import pants.personal.app.toDo.dto.UserReadOnlyDTO;
import pants.personal.app.toDo.mapper.UserMapper;
import pants.personal.app.toDo.model.User;
import pants.personal.app.toDo.repository.UserRepository;

import java.util.UUID;


/**
 * Implementation of the {@link IUserService} interface responsible for handling
 * user-related operations such as creation and retrieval by UUID.
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService{

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserReadOnlyDTO createUser(UserCreateDTO dto) throws EntityAlreadyExistsException{
        if (userRepository.existsByUsername(dto.username())) {
            throw new EntityAlreadyExistsException("Username already exists");
        }

        if (userRepository.existsByEmail(dto.email())) {
            throw new EntityAlreadyExistsException("Email already exists");
        }

        User user = userMapper.toEntity(dto, dto.password());
        userRepository.save(user);

        return userMapper.toReadOnly(user);
    }

    @Override
    public UserReadOnlyDTO getUserByUuid(UUID uuid) {
        User user = userRepository.findByUuid(uuid)
                .orElseThrow(() -> new EntityNotFoundException("User with uuid " + uuid + " not found!"));
        return userMapper.toReadOnly(user);
    }
}
