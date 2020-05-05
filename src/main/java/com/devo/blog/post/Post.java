package com.devo.blog.post;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Post {


  @Id
  private Long id;
  private String uid;
  private String topic;
  private String text;

}
