package pants.personal.app.toDo.core.exception;


/**
 * Exception thrown to indicate that an attempt to create or add an entity has failed
 * because an entity with the same identifier or properties already exists.
 *
 * This exception is typically used in cases where uniqueness constraints are violated
 * during operations such as persisting data to a database or adding elements to a collection.
 */
public class EntityAlreadyExistsException extends Exception {
    public EntityAlreadyExistsException(String message) {
        super(message);
    }
}
