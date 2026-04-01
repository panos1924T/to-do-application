package pants.personal.app.toDo.dto;

/**
 * A Data Transfer Object (DTO) that encapsulates error response information to be sent
 * to clients in case of exceptions or errors during API interactions.
 */
public record ErrorResponseDTO(
        int status,
        String message
) {
}
