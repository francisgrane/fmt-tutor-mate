package com.fmt.tutor.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> lidarComExceptionGlobal(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ops, tivemos um erro: Erro Interno de Servidor.");
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> lidarComResourceNotFoundException(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O recurso não foi encontrado.");
    }

    @ExceptionHandler(CreateException.class)
    public ResponseEntity<String> lidarComCreationException(CreateException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Houve falha na criação deste recurso.");
    }

    @ExceptionHandler(UpdateException.class)
    public ResponseEntity<String> lidarComUpdateException(UpdateException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Houve falha na atualização desse recurso.");
    }

    @ExceptionHandler(DeleteException.class)
    public ResponseEntity<String> lidarComDeletionException(DeleteException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Houve falha na exclusão desse recurso.");
    }

}
