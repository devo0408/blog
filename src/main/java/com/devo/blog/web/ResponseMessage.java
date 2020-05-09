package com.devo.blog.web;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ResponseMessage {

  String message;

  public static ResponseMessage of(String msg){
    return ResponseMessage.builder()
        .message(msg)
        .build();
  }

}
