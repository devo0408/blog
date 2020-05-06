package com.devo.blog.post;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PostDtoConverter implements Converter<PostEntity, PostDto> {

  @Override
  public PostDto convert(PostEntity source) {
    return new PostDto(source.getUid(),source.getTopic(), source.getText());
  }
}
