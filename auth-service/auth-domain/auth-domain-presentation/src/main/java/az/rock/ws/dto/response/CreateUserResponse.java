package az.rock.ws.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public record CreateUserResponse(@NotNull UUID userId, @NotNull String message) {
}
