package com.lambda.practice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionManager {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> runtimeExceptionHandler(RuntimeException e) {
        //RuntimeException이 나면 controller대신 이곳에서 return
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(e.getMessage());

        // INTERNAL_SERVER_ERROR를 리턴하고 ResponseBody에 e.getMessage()를 추가해서 보냄.
    }

    @ExceptionHandler(HospitalException.class)
    public ResponseEntity<?> HospitalExceptionHandler(HospitalException hospitalException) {
        //내가 만든 어플리케이션에서 특정 에러코드 (꼭 숫자가 아니어도 됨)을 frontend에 일려주고 싶다.
        return ResponseEntity.status(hospitalException.getErrorCode().getHttpStatus())
                .body(hospitalException.getMessage());
    }
}
