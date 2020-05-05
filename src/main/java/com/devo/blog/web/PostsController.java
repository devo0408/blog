package com.devo.blog.web;

import com.devo.blog.post.PostDto;
import com.devo.blog.post.PostDtoConverter;
import com.devo.blog.post.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.http.ResponseEntity.notFound;
import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping(value = "/posts")
@AllArgsConstructor
public class PostsController {

  private final PostDtoConverter postDtoConverter;
  private final PostService postService;

  @GetMapping(value = "/")
  public ResponseEntity<List<PostDto>> getAllPost(){
    List<PostDto> posts = postService.findAll().stream()
        .map(postDtoConverter::convert)
        .collect(toList());
    return ok().body(posts); // TODO: 05.05.2020 add paging for list 
  }

  @GetMapping(value = "/{uid}")
  public ResponseEntity<PostDto> getPost(@PathVariable("uid") String uid){
    return Optional.ofNullable(postService.findByUid(uid))
        .map(postDtoConverter::convert)
        .map(postDto -> ok().body(postDto))
        .orElseGet(() -> notFound().build());
  }

}
