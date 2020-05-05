package com.devo.blog.post;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PostDtoConverter implements Converter<Post, PostDto> {

  @Override
  public PostDto convert(Post source) {
    return PostDto.builder()
        .uid(source.getUid())
        .topic(source.getTopic())
        .text(source.getText())
        .build();
  }
}
