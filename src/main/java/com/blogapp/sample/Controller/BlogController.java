package com.blogapp.sample.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.blogapp.sample.Dto.BlogPostDto;
import com.blogapp.sample.Exception.NotFoundException;
import com.blogapp.sample.Service.BlogPostService;

@RestController
@RequestMapping("/api/blog/posts")
public class BlogController {
    @Autowired
    private BlogPostService blogPostService;

    @GetMapping
    public List<BlogPostDto> getAllBlogPosts() {
        return blogPostService.getAllBlogPosts();
    }

    @GetMapping("/{postId}")
    public ResponseEntity<BlogPostDto> getBlogPostById(@PathVariable Long postId) {
        BlogPostDto blogPostDto = blogPostService.getBlogPostById(postId);
        return ResponseEntity.ok(blogPostDto);
    }

    @GetMapping("/author/{authorId}")
    public List<BlogPostDto> getBlogPostsByAuthor(@PathVariable Long authorId) {
        return blogPostService.getBlogPostsByAuthor(authorId);
    }

    @PostMapping
    public Long createBlogPost(@RequestBody BlogPostDto blogPostDto) {
        return blogPostService.createBlogPost(blogPostDto);
    }

    @PutMapping("/{postId}")
    public void updateBlogPost(@PathVariable Long postId, @RequestBody BlogPostDto blogPostDto) {
        blogPostService.updateBlogPost(postId, blogPostDto);
    }

    @DeleteMapping("/{postId}")
    public void deleteBlogPost(@PathVariable Long postId) {
        blogPostService.deleteBlogPost(postId);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(NotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}
