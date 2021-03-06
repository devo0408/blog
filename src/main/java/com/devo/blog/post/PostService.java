package com.devo.blog.post;

import com.devo.blog.repositories.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.devo.blog.common.utils.IdentifierGenerator.getNextPostUid;


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

  public PostEntity update(PostEntity post, PostDto postDto){
    updatePostEntity(post, postDto);
    return postRepository.save(post);
  }

  public void delete(PostEntity post) {
    postRepository.deleteById(post.getId());
  }

  private void updatePostEntity(PostEntity postEntity, PostDto postDto){
    String uid = postEntity.getUid() != null ? postEntity.getUid() : getNextPostUid();
    postEntity.setUid(uid);
    postEntity.setTopic(postDto.getTopic());
    postEntity.setText(postDto.getText());
  }

}
