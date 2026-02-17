package com.eduardos.ecommerce_2026.exception;

import java.time.LocalDateTime;

public record CustomErrorResponse(
        LocalDateTime timestamp,
        String error,
        String message) {
}