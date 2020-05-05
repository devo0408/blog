package com.devo.blog.web;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ResponseMessage {

  private final String message;


  public static ResponseMessage of(String msg){
    return ResponseMessage.builder()
        .message(msg)
        .build();
  }

}
