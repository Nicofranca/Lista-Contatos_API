package com.example.demo.dto.error;

import java.time.LocalDateTime;

public class ErrorResp {
    private LocalDateTime dataHora;
    private int status;
    private String mensage;

    public ErrorResp(int status, String mensage) {
        this.dataHora = LocalDateTime.now();
        this.status = status;
        this.mensage = mensage;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMensage() {
        return mensage;
    }

    public void setMensage(String mensage) {
        this.mensage = mensage;
    }
}
