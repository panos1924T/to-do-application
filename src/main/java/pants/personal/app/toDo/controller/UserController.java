package pants.personal.app.toDo.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pants.personal.app.toDo.dto.UserCreateDTO;
import pants.personal.app.toDo.dto.UserReadOnlyDTO;
import pants.personal.app.toDo.service.IUserService;

import java.util.UUID;

/**
 * REST controller for managing user-related operations, such as registration
 * and retrieving user information by UUID. This controller handles HTTP requests
 * and delegates business logic to the associated service layer.
 *
 * Endpoints:
 * - POST /api/v1/users/register: Registers a new user.
 * - GET /api/v1/users/{userUuid}: Retrieves user details by UUID.
 */

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;

    /**
     * Handles the registration of a new user. Accepts user creation details in the request body,
     * validates the input, and delegates the creation process to the service layer. Upon successful
     * creation, returns a response containing a read-only representation of the created user.
     */
    @PostMapping("/register")
    public ResponseEntity<UserReadOnlyDTO> register(
            @Valid @RequestBody UserCreateDTO dto
            ) {
        UserReadOnlyDTO responseDTO = userService.createUser(dto);
        return ResponseEntity.status(201).body(responseDTO);
    }

    /**
     * Retrieves the details of a user identified by their unique UUID.
     */
    @GetMapping("/{userUuid}")
    public ResponseEntity<UserReadOnlyDTO> getUser(
            @PathVariable UUID userUuid
    ) {
        UserReadOnlyDTO responseDTO = userService.getUserByUuid(userUuid);
        return ResponseEntity.ok(responseDTO);
    }
}
