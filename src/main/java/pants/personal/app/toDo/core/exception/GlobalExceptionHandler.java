package pants.personal.app.toDo.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pants.personal.app.toDo.dto.ErrorResponseDTO;

/**
 * A global exception handler to manage application-wide exception handling.
 * This class captures specific exceptions and returns appropriate HTTP
 * responses with error details encapsulated in {@code ErrorResponseDTO}.
 *
 * The following exceptions are handled:
 * - {@code EntityNotFoundException}: Returns a 404 Not Found response.
 * - {@code EntityAlreadyExistsException}: Returns a 409 Conflict response.
 *
 * Marked with {@code RestControllerAdvice}, this class listens for exceptions
 * thrown across all controllers in the application.
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleNotFound(EntityNotFoundException e) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponseDTO(
                        e.getMessage()
                ));
    }

    @ExceptionHandler(EntityAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDTO> handleAlreadyExists(EntityAlreadyExistsException e) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(new ErrorResponseDTO(
                        e.getMessage()
                ));
    }
}
