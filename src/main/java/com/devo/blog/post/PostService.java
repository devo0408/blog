package com.devo.blog.post;

import com.devo.blog.repositories.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class PostService {

  private final PostRepository postRepository;

  public PostEntity findByUid(String uid) {
    return postRepository.findPostEntityByUid(uid).orElse(null);
  }

  public List<PostEntity> findAll() {
    return postRepository.findAll();
  }

}
