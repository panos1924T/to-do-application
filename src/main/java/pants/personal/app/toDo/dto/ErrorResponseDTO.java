package pants.personal.app.toDo.dto;

/**
 * Data Transfer Object representing an error response.
 * Used to encapsulate error details that can be provided to clients
 * in case of exceptions such as {@code EntityNotFoundException}
 * or {@code EntityAlreadyExistsException}.
 *
 * This record holds the error message, which provides information
 * about the nature of the error.
 */
public record ErrorResponseDTO(
        String message
) {
}
