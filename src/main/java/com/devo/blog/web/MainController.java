package com.devo.blog.web;

import com.devo.blog.exception.PostNotFoundException;
import com.devo.blog.post.Post;
import com.devo.blog.post.PostDto;
import com.devo.blog.post.PostDtoConverter;
import com.devo.blog.post.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@AllArgsConstructor
public class MainController {

  private final PostDtoConverter postDtoConverter;
  private final PostService postService;


  @GetMapping(value = "/{uid}")
  public ResponseEntity<PostDto> getPost(@PathVariable("uid") String uid){
    Post post = postService.getByUid(uid);
    if (post == null) {
       throw new PostNotFoundException();
    }
    return ok(postDtoConverter.convert(post));
  }

}
