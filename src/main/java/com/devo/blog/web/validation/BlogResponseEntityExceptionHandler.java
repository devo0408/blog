package com.devo.blog.web.validation;

import com.devo.blog.exception.PostNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.ResponseEntity.notFound;

@ControllerAdvice
public class BlogResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(PostNotFoundException.class)
  protected ResponseEntity<RestErrorMessage> handleConflict() {
//    RestErrorMessage msg = RestErrorMessage.builder()
//        .message(format("can't find post with UID: %s", ex.getUid()))
//        .build();
    return notFound().build();
  }

}
