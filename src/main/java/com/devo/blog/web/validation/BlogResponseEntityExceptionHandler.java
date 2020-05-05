package com.devo.blog.web.validation;

import com.devo.blog.exception.PostNotFoundException;
import com.devo.blog.web.ResponseMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.ResponseEntity.notFound;
import static java.lang.String.format;

@ControllerAdvice
public class BlogResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(PostNotFoundException.class)
  protected ResponseEntity<ResponseMessage> handleConflict(PostNotFoundException ex) {
    String msg = format("can't find post with UID: %s", ex.getUid());
//    RestErrorMessage msgDto = RestErrorMessage.builder()
//        .message(format("can't find post with UID: %s", ex.getUid()))
//        .build();
    return notFound().header("details", msg).build();
  }

}
