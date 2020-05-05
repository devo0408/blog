package com.devo.blog.exception;

import lombok.Getter;

@Getter
public class PostNotFoundException extends RuntimeException {

  private final String uid;

  public PostNotFoundException(String uid) {
    this.uid = uid;
  }

}
