package pants.personal.app.toDo.dto;

public record UserCreateDTO(
        String username,
        String email,
        String password) {
}
