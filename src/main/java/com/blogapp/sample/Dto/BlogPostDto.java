package com.blogapp.sample.Dto;

import java.time.LocalDateTime;

public class BlogPostDto {
    private Long id;
    private String title;
    private String content;
    private Long authorId;
    private LocalDateTime createdDateTime;
    public BlogPostDto(){
        
    }
    public BlogPostDto(Long id, String title, String content, Long authorId, LocalDateTime createdDateTime) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.authorId = authorId;
        this.createdDateTime = createdDateTime;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Long getAuthorId() {
        return authorId;
    }
    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }
    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    
}
