package com.lambdaschool.howto;

import com.lambdaschool.howto.models.Post;
import com.lambdaschool.howto.models.Role;
import com.lambdaschool.howto.models.User;
import com.lambdaschool.howto.models.UserRoles;
import com.lambdaschool.howto.services.PostService;
import com.lambdaschool.howto.services.RoleService;
import com.lambdaschool.howto.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.transaction.annotation.Transactional;

@Transactional
//@Component
public class SeedData implements CommandLineRunner
{
    @Autowired
    UserService userService;
    @Autowired
    PostService postService;
    @Autowired
    RoleService roleService;

    @Transactional
    @Override
    public void run(String... args) throws Exception
    {
        Role r1 = new Role("ADMIN");
        Role r2 = new Role("USER");
        r1 = roleService.save(r1);
        r2 = roleService.save(r2);

        User u1 = new User("admin", "password");
        u1.addRole(new UserRoles(u1, r1));
        u1 = userService.save(u1);

        Post p1 = new Post("TEST",
            "TESTING, 123....., TESTING, 123");
        p1.setUser(u1);

        p1 = postService.save(p1);
        u1.addPost(p1);
    }
}
