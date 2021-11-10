package com.generation.SpringSecurityJWT.model;

import com.fasterxml.jackson.annotation.JsonIgnore; //ignora la linea siempre
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(columnDefinition = "text")  //para cambiar el tipo a nivel de bases de datos
    private String content;

    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) //solo se puede escribir
    private User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
