package FlashBrain_Backend.dto;

import jakarta.validation.constraints.NotBlank;

public record TokenDTOResponse(@NotBlank String token) {
}
