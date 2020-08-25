package com.lambdaschool.howto.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post extends Auditable
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long postid;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String body;

    @ManyToOne
    @JoinColumn(name = "userid")
    @JsonIgnoreProperties(value = "posts")
    private User user;

    public Post()
    {
    }

    public Post(
        String title,
        String body)
    {
        this.title = title;
        this.body = body;
    }

    public long getPostid()
    {
        return postid;
    }

    public void setPostid(long postid)
    {
        this.postid = postid;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getBody()
    {
        return body;
    }

    public void setBody(String body)
    {
        this.body = body;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

}
