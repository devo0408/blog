package com.devo.blog.post;

import com.devo.blog.repositories.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class PostService {

  private final PostRepository postRepository;


  public PostEntity getByUid(String uid){
    return postRepository.findPostEntityByUid(uid).orElse(null);
  }

}
