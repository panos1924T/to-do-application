package pants.personal.app.toDo.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * public record for user creation
 * @param username
 * @param email
 * @param password
 */
public record UserCreateDTO(
        @NotBlank
        String username,

        @NotBlank
        @Email
        String email,

        @NotBlank
        @Size(min = 8)
        String password) {
}
