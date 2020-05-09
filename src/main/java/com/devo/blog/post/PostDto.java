package com.devo.blog.post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {

  private String uid;
  private String topic; // TODO: 09.05.2020   @NonNull implementation 
  private String text;

}
