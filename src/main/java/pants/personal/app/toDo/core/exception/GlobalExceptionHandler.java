package pants.personal.app.toDo.core.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pants.personal.app.toDo.dto.ErrorResponseDTO;

/**
 * Global exception handler for managing application-wide exceptions.
 * This class uses Spring's {@code @RestControllerAdvice} to intercept and process
 * exceptions thrown during the execution of controller methods, providing consistent
 * error responses to the client.
 *
 * It defines the handling of the following exceptions:
 * 1. {@code EntityNotFoundException}: For cases where a requested entity could not be found.
 * 2. {@code EntityAlreadyExistsException}: For cases where an entity with the same
 * identifier or properties already exists.
 * 3. {@code MethodArgumentNotValidException}: For cases where validation of input arguments
 * fails, typically during request validation.
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 1. Για όταν δεν βρίσκεται κάτι (404)
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleNotFound(EntityNotFoundException e) {
        return ResponseEntity.status(404).body(new ErrorResponseDTO(404, e.getMessage()));
    }

    // 2. Για όταν κάτι υπάρχει ήδη (409)
    @ExceptionHandler(EntityAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDTO> handleAlreadyExists(EntityAlreadyExistsException e) {
        return ResponseEntity.status(409).body(new ErrorResponseDTO(409, e.getMessage()));
    }

    // 3. Η ΑΠΛΗ λύση για το Validation (400)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDTO> handleValidation(MethodArgumentNotValidException e) {
        // Παίρνουμε μόνο το πρώτο μήνυμα λάθους που θα βρει το Spring
        String errorMessage = e.getBindingResult().getFieldError().getDefaultMessage();

        return ResponseEntity.status(400).body(new ErrorResponseDTO(400, errorMessage));
    }
}