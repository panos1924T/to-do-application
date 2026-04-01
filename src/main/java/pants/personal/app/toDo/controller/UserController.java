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

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserReadOnlyDTO> register(
            @Valid @RequestBody UserCreateDTO dto
            ) {
        UserReadOnlyDTO responseDTO = userService.createUser(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping("/{userUuid}")
    public ResponseEntity<UserReadOnlyDTO> getUser(
            @PathVariable UUID userUuid
    ) {
        UserReadOnlyDTO responseDTO = userService.getUserByUuid(userUuid);
        return ResponseEntity.ok(responseDTO);
    }
}
