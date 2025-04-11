package com.mypack.authentication.domain;

import java.time.LocalDateTime;

public record LoginAttempt(String email,
                           boolean success,
                           LocalDateTime createdAt) {

}
