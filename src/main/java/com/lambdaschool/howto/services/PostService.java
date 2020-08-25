package com.lambdaschool.howto.services;

import com.lambdaschool.howto.models.Post;

import java.util.List;

public interface PostService
{
    List<Post> findAll();
    Post findPostById(long id);
    Post findByTitle(String title);
    List<Post> findByTitleLike(String title);
    List<Post> findUsersPost();
    Post save(Post post);
    Post update(Post post, long id);
    void delete(long id);
}
