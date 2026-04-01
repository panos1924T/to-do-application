package pants.personal.app.toDo.core.exception;


import org.springframework.http.HttpStatus;

/**
 * A custom runtime exception class designed to serve as a base for application-specific exceptions.
 * This class provides additional context by including an error code and HTTP status, which
 * can help in identifying and categorizing errors, as well as generating meaningful API responses.
 */

public class AppGenericException extends RuntimeException{
    private final String code;
    private final HttpStatus status;

    public AppGenericException(String code, String message, HttpStatus status) {
        super(message);
        this.code = code;
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public HttpStatus getStatus(){
        return status;
    }
}
