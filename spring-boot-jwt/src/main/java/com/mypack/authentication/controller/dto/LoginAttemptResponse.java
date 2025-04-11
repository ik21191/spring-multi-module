package com.mypack.authentication.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import com.mypack.authentication.domain.LoginAttempt;

public record LoginAttemptResponse(
    @Schema(description = "The date and time of the login attempt") LocalDateTime createdAt,
    @Schema(description = "The login status") boolean success) {

  public static LoginAttemptResponse convertToDTO(LoginAttempt loginAttempt) {
    return new LoginAttemptResponse(loginAttempt.createdAt(), loginAttempt.success());
  }
}
