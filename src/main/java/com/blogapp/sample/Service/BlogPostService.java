package com.blogapp.sample.Service;

import java.util.List;

import com.blogapp.sample.Dto.BlogPostDto;

public interface BlogPostService {
    List<BlogPostDto> getAllBlogPosts();

    BlogPostDto getBlogPostById(Long postId);

    List<BlogPostDto> getBlogPostsByAuthor(Long authorId);

    Long createBlogPost(BlogPostDto blogPostDto);

    void updateBlogPost(Long postId, BlogPostDto blogPostDto);

    void deleteBlogPost(Long postId);
}
