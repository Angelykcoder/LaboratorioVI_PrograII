package com.labseis.labvi.exception;

import java.time.LocalDateTime;

public class ErrorResponse {

    private LocalDateTime timestamp;
    private int status;
    private String mensaje;

    public ErrorResponse(LocalDateTime timestamp, int status, String mensaje) {
        this.timestamp = timestamp;
        this.status = status;
        this.mensaje = mensaje;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public int getStatus() {
        return status;
    }

    public String getMensaje() {
        return mensaje;
    }
}
