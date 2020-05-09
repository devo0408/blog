package com.devo.blog.web;

import com.devo.blog.exception.PostNotFoundException;
import com.devo.blog.post.PostDto;
import com.devo.blog.post.PostDtoConverter;
import com.devo.blog.post.PostEntity;
import com.devo.blog.post.PostService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static org.springframework.http.ResponseEntity.ok;
import static java.util.stream.Collectors.toList;
import static java.lang.String.format;

@Slf4j
@RestController
@RequestMapping(value = "/posts")
@AllArgsConstructor
public class PostsController {

  private final PostDtoConverter postDtoConverter;
  private final PostService postService;


  @GetMapping
  public ResponseEntity<List<PostDto>> getAllPost(){
    log.debug("Getting all posts");
    List<PostDto> posts = postService.findAll().stream()
        .map(postDtoConverter::convert)
        .collect(toList());
    return ok(posts); // TODO: 05.05.2020 add paging for (list org.springframework.data.domain.Page)
  }

  @GetMapping(value = "/{uid}")
  public ResponseEntity<PostDto> getPost(@PathVariable("uid") String uid){
    log.debug("Getting post {}", uid);
    return Optional.ofNullable(postService.findByUid(uid))
        .map(postDtoConverter::convert)
        .map(ResponseEntity::ok)
        .orElseThrow(() -> new PostNotFoundException(uid));
  }

  @PostMapping
  public ResponseEntity<ResponseMessage> createPost(@Valid @RequestBody PostDto newPost){
    log.info("Start creating new post from: \"{}\")", newPost);

    PostEntity createdPost = postService.create(newPost);
    String newUid = createdPost.getUid();

    log.info("Created new post: {}", newUid);
    return ok(ResponseMessage.of(format("uid: %s", newUid)));
  }

  @PutMapping
  public ResponseEntity<ResponseMessage> updatePost(@PathVariable("uid") String uid,
                                                    @Valid @RequestBody PostDto newPostData){
    log.info("Start updating post \"{}\" from \" {}\"", uid, newPostData);

    PostEntity currentStatePost = postService.findByUid(uid);

    Function<PostEntity, ResponseEntity<ResponseMessage>> postResponseCreator = (postEntity) -> {
      log.info("Post {} successfully updated", postEntity.getUid());
      return ok(ResponseMessage.of("Successfully updated"));
    };
    return Optional.ofNullable(currentStatePost)
        .map(postEntity -> postService.update(postEntity, newPostData))
        .map(postResponseCreator)
        .orElseThrow(() -> new PostNotFoundException(uid));
  }

}
