package com.lambdaschool.howto.controllers;

import com.lambdaschool.howto.models.Post;
import com.lambdaschool.howto.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController
{
    @Autowired
    private PostService postService;

    @GetMapping(value = "/posts",
        produces = {"application/json"})
    public ResponseEntity<?> listAllPost() {
        List<Post> posts = postService.findAll();
        return new ResponseEntity<>(posts,
            HttpStatus.OK);
    }

    @GetMapping(value = "/user",
    produces = {"application/json"})
    public ResponseEntity<?> listUsersPost() {
        List<Post> list = postService.findUsersPost();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping(value = "/post",
    consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> addNewPost (@Valid @RequestBody Post newPost) throws URISyntaxException {
        newPost.setPostid(0);
        newPost = postService.save(newPost);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newPostURI = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{postid}")
            .buildAndExpand(newPost.getPostid()).toUri();
        responseHeaders.setLocation(newPostURI);

        return new ResponseEntity<>(newPost, responseHeaders, HttpStatus.CREATED);
    }

    @PutMapping(value = "/post/{postid}",
    consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> updateFullPost (@Valid @RequestBody Post updatePost, @PathVariable long postid) {
        updatePost.setPostid(postid);
        updatePost = postService.save(updatePost);

        return new ResponseEntity<>(updatePost, HttpStatus.OK);
    }

    @DeleteMapping(value = "/post/{postid}")
    public ResponseEntity<?> deletePostById (@PathVariable long postid) {
        postService.delete(postid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
