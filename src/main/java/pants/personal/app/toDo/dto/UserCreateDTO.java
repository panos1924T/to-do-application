package pants.personal.app.toDo.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * public record for user creation
 */
public record UserCreateDTO(
        @NotNull
        String username,

        @NotNull
        @Email
        String email,

        @NotNull
        @Size(min = 8)
        String password) {
}
