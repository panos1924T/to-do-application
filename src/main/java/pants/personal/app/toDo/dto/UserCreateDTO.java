package pants.personal.app.toDo.dto;


/**
 * public record for user creation
 * @param username
 * @param email
 * @param password
 */
public record UserCreateDTO(
        String username,
        String email,
        String password) {
}
