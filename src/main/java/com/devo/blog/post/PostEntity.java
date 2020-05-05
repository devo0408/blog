package com.devo.blog.post;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Getter
@Setter
@Entity
public class PostEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false, unique = true)
  private Long id;
  @Column(nullable = false, unique = true)
  private String uid;
  @Column
  private String topic;
  @Column
  private String text;
  // TODO: 05.05.2020 add Created/Updated date
}
