package com.devo.blog.post;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PostDto {

  private final String uid;
  private final String topic;
  private final String text;

}
