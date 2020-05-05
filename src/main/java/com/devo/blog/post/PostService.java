package com.devo.blog.post;

import com.devo.blog.repositories.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@AllArgsConstructor
public class PostService {

  private final PostRepository postRepository;


//  @Transactional
  public Post getByUid(String uid){
    return postRepository.findPostByUid(uid).orElse(null);
  }

}
