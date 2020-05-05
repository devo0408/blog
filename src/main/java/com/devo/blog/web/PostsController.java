package com.devo.blog.web;

import com.devo.blog.exception.PostNotFoundException;
import com.devo.blog.post.PostEntity;
import com.devo.blog.post.PostDto;
import com.devo.blog.post.PostDtoConverter;
import com.devo.blog.post.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.http.ResponseEntity.notFound;

@RestController
@RequestMapping(value = "/posts")
@AllArgsConstructor
public class PostsController {

  private final PostDtoConverter postDtoConverter;
  private final PostService postService;


  @GetMapping(value = "/{uid}")
  public ResponseEntity<PostDto> getPost(@PathVariable("uid") String uid){
    return Optional.ofNullable(postService.getByUid(uid))
        .map(postDtoConverter::convert)
        .map(postDto -> ok().body(postDto))
        .orElseGet(() -> notFound().build());
  }

}
