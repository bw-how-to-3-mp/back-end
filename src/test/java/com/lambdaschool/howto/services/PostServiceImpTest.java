package com.lambdaschool.howto.services;

import com.lambdaschool.howto.HowtoApplication;
import com.lambdaschool.howto.models.Post;
import com.lambdaschool.howto.models.User;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HowtoApplication.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PostServiceImpTest
{
    @Autowired
    private UserService userService;
    @Autowired
    private PostService postService;

    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void a_findAll()
    {
        User user = new User("UserName", "password");
        user = userService.save(user);
        Post post = new Post("TITLE", "BODY");

        post.setUser(user);

        post = postService.save(post);
        assertEquals(1, postService.findAll().size());
    }

    @Test
    public void b_findPostById()
    {
        assertEquals("TITLE", postService.findPostById(postService.findAll().get(0).getPostid()).getTitle());
    }

    @Test
    public void c_findByTitle()
    {
        assertEquals("TITLE", postService.findByTitle("TITLE").getTitle());
    }

    @Test
    public void d_findByTitleLike()
    {
        assertEquals(1, postService.findByTitleLike("TI").size());
    }

    @Test
    public void e_save()
    {
        User user = userService.findAll().get(0);
        Post post = new Post("NEW POST", "THIS IS THE NEW POST, STAND UP AND ADMIT");
        post.setUser(user);
        post = postService.save(post);

        assertEquals(2, postService.findAll().size());
    }

    @Test
    public void f_update()
    {
        Post updatePost = new Post();
        updatePost.setTitle("UPDATED");
        postService.update(updatePost, postService.findAll().get(0).getPostid());
        assertEquals("UPDATED", postService.findAll().get(0).getTitle());
    }

    @Test
    public void z_delete()
    {
        postService.delete(postService.findAll().get(1).getPostid());
        assertEquals(1, postService.findAll().size());
    }
}