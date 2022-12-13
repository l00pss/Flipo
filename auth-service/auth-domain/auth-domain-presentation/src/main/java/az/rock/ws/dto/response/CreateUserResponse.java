package az.rock.ws.dto.response;

import lombok.Builder;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Builder
public record CreateUserResponse(@NotNull UUID userId, @NotNull String message) {
}
