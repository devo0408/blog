package com.devo.blog.repositories;

import com.devo.blog.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {


  Optional<Post> findPostByUid(String uid);

}
