package pants.personal.app.toDo.core.exception;


/**
 * Exception thrown to indicate that an attempt to create or add an entity has failed
 * because an entity with the same identifier or properties already exists.
 */
public class EntityAlreadyExistsException extends RuntimeException {
    public EntityAlreadyExistsException(String message) {
        super(message);
    }
}
