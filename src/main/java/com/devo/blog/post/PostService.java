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

  public PostEntity create(PostDto postDto){
    PostEntity post = new PostEntity();
    updatePostEntity(post, postDto);
    return postRepository.save(post);
  }

  private void updatePostEntity(PostEntity postEntity, PostDto postDto){
    postEntity.setUid(postDto.getUid());
    postEntity.setTopic(postDto.getTopic());
    postEntity.setText(postDto.getText());
  }

}
