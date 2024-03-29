package com.blogapp.sample.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogapp.sample.Dto.BlogPostDto;
import com.blogapp.sample.Entity.BlogPost;
import com.blogapp.sample.Exception.NotFoundException;
import com.blogapp.sample.Repository.BlogPostRepository;
import com.blogapp.sample.Repository.UserRepository;

import org.modelmapper.ModelMapper;

@Service
public class BlogPostServiceImpl implements BlogPostService {
    @Autowired
    private BlogPostRepository blogPostRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<BlogPostDto> getAllBlogPosts() {
        List<BlogPost> blogPosts = blogPostRepository.findAll();
        return mapToDTOList(blogPosts);
    }

    @Override
    public BlogPostDto getBlogPostById(Long postId) {
        BlogPost blogPost = blogPostRepository.findById(postId)
                .orElseThrow(() -> new NotFoundException("Blog post not found"));
        return modelMapper.map(blogPost, BlogPostDto.class);
    }

    @Override
    public List<BlogPostDto> getBlogPostsByAuthor(Long authorId) {
        List<BlogPost> blogPosts = blogPostRepository.findByAuthorId(authorId);
        return mapToDTOList(blogPosts);
    }

    @Override
    public Long createBlogPost(BlogPostDto blogPostDto) {
        BlogPost blogPost = mapToEntity(blogPostDto);
        blogPost.setCreatedDateTime(LocalDateTime.now());
        BlogPost savedPost = blogPostRepository.save(blogPost);
        return savedPost.getId();
    }

    @Override
    public void updateBlogPost(Long postId, BlogPostDto blogPostDto) {
        BlogPost existingPost = blogPostRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Blog post not found"));

        // Update existing post with new data from DTO
        existingPost.setTitle(blogPostDto.getTitle());
        existingPost.setContent(blogPostDto.getContent());

        blogPostRepository.save(existingPost);
    }

    @Override
    public void deleteBlogPost(Long postId) {
        blogPostRepository.deleteById(postId);
    }

    private List<BlogPostDto> mapToDTOList(List<BlogPost> blogPosts) {
        return blogPosts.stream()
                .map(blogPost -> modelMapper.map(blogPost, BlogPostDto.class))
                .collect(Collectors.toList());
    }

    private BlogPost mapToEntity(BlogPostDto blogPostDto) {
        BlogPost blogPost = modelMapper.map(blogPostDto, BlogPost.class);
        if (blogPostDto.getAuthorId() != null) {
            blogPost.setAuthor(userRepository.findById(blogPostDto.getAuthorId())
                    .orElseThrow(() -> new RuntimeException("Author not found")));
        }
        return blogPost;
    }
}
