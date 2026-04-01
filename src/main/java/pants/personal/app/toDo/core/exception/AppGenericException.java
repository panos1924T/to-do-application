package pants.personal.app.toDo.core.exception;


/**
 * A custom exception class that serves as the base for other domain-specific exceptions
 * in the application. It extends {@code RuntimeException} and introduces an additional
 * {@code code} field to provide a standardized way of identifying the type or category
 * of exception.
 * */

public class AppGenericException extends RuntimeException{
    private final String code;

    public AppGenericException(String code, String message) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
