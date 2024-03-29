package com.blogapp.sample.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;

@Entity
public class BlogPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Lob
    @Column(name = "content", nullable = false, columnDefinition = "TEXT")
    private String content; // Using @Lob for handling large text content

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    @Column(name = "created_date_time", nullable = false)
    private LocalDateTime createdDateTime;

    public Long getId() {
        return id;
    }

    public BlogPost(){

    }
    
    public BlogPost(Long id, String title, String content, User author, LocalDateTime createdDateTime) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.createdDateTime = createdDateTime;
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

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    

    
}


