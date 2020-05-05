package com.devo.blog.post;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PostDto {
  // TODO: 05.05.2020 add Created/Updated date
  private final String uid;
  private final String topic;
  private final String text;

}
