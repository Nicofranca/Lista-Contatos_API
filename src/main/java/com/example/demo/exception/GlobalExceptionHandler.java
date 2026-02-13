package com.example.demo.exception;

import com.example.demo.dto.ErrorResp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    public ResponseEntity<ErrorResp> tratarErroDeValidacao(MethodArgumentNotValidException e){
        String mensagemErro = e.getBindingResult().getFieldError().getDefaultMessage();

        ErrorResp error  = new ErrorResp(
                HttpStatus.BAD_REQUEST.value(),
                mensagemErro
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ErrorResp> tratarErro404(ResponseStatusException e){
        ErrorResp error = new ErrorResp(
                e.getStatusCode().value(),
                e.getReason()
        );

        return ResponseEntity.status(e.getStatusCode()).body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResp> tratarErroGenerico(Exception e){
        ErrorResp errorResp = new ErrorResp(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Ocorreu um erro no Servidor"
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResp);
    }
}
