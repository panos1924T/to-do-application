package pants.personal.app.toDo.core.exception;


/**
 * Exception thrown to indicate that a requested entity could not be found.
 */
public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String message) {
        super(message);
    }
}
