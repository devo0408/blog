package com.devo.blog.web.validation;

import com.devo.blog.exception.PostNotFoundException;
import com.devo.blog.web.ResponseMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Slf4j
@ControllerAdvice
public class BlogResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(PostNotFoundException.class)
  protected ResponseEntity<ResponseMessage> handleConflict(PostNotFoundException ex) {
    log.info("Can't find Post {}", ex.getUid());
    return ResponseEntity.status(NOT_FOUND)
        .body(ResponseMessage.of("Uid not found"));
  }

}
