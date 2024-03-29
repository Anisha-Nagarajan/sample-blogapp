package com.blogapp.sample.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogapp.sample.Entity.BlogPost;

public interface BlogPostRepository  extends JpaRepository<BlogPost, Long> {
    List<BlogPost> findByAuthorId(Long authorId);
}
