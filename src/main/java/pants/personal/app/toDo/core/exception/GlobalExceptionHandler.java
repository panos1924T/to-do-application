package pants.personal.app.toDo.core.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pants.personal.app.toDo.dto.ErrorResponseDTO;

import java.time.LocalDateTime;

/**
 * Handles global exception scenarios within the application by providing centralized exception
 * handling for custom application exceptions and validation errors.
 * This class utilizes {@link RestControllerAdvice} to intercept and manage exceptions
 * thrown by the controller layer, ensuring a consistent error response format.
 * These exception handlers ensure that meaningful and standardized error responses are provided
 * to API clients, improving the debuggability and reliability of the API.
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AppGenericException.class)
    public ResponseEntity<ErrorResponseDTO> handleAppGenericException(AppGenericException e, HttpServletRequest request) {
        HttpStatus status = e.getStatus();

        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(
                LocalDateTime.now(),
                status.value(),
                e.getCode(),
                e.getMessage(),
                request.getRequestURI()
        );

        return new ResponseEntity<>(errorResponseDTO, status);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDTO> handleValidation(MethodArgumentNotValidException e, HttpServletRequest request) {
        var fieldError = e.getBindingResult().getFieldError();
        String errorMessage = (fieldError != null) ? fieldError.getDefaultMessage() : "Validation Failed";

        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(
                LocalDateTime.now(),
                400,
                "VALIDATION_ERROR",
                errorMessage,
                request.getRequestURI()
        );

        return ResponseEntity.status(400).body(errorResponseDTO);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleEverything(Exception e, HttpServletRequest request) {
        return ResponseEntity.status(500).body(new ErrorResponseDTO(
                LocalDateTime.now(),
                500,
                "GENERIC_ERROR",
                "An internal server error occurred.",
                request.getRequestURI()
        ));
    }
}