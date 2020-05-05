package com.devo.blog.repositories;

import com.devo.blog.post.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<PostEntity, Long> {

  Optional<PostEntity> findPostEntityByUid(String uid);

}
