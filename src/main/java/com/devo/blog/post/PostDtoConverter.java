package com.devo.blog.post;

import lombok.NonNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PostDtoConverter implements Converter<PostEntity, PostDto> {


  @Override
  public PostDto convert(PostEntity source) {
    return PostDto.builder()
        .uid(source.getUid())
        .topic(source.getTopic())
        .text(source.getText())
        .build();
  }
}
