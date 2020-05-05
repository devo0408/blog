package com.devo.blog.web.validation;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RestErrorMessage {

  private final String message;

}
