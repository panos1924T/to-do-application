package pants.personal.app.toDo.dto;

import java.time.Instant;
import java.util.UUID;

/**
 * public record for clients use, read only
 * @param uuid
 * @param username
 * @param email
 * @param active
 * @param createdAt
 */
public record UserReadOnlyDTO(
        UUID uuid,
        String username,
        String email,
        Boolean active,
        Instant createdAt
) {
}
