package com.lambdaschool.howto.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userid;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @OneToMany(mappedBy = "user",
    cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties(value = "user",
    allowSetters = true)
    private Set<UserRoles> roles = new HashSet<>();

    @OneToMany(mappedBy =  "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties(value = "user", allowSetters = true)
    private Set<Vote> votedPost = new HashSet<>();

    public User()
    {
    }

    public User(
        String username,
        String password)
    {
        this.username = username;
        this.password = password;
    }

    public long getUserid()
    {
        return userid;
    }

    public void setUserid(long userid)
    {
        this.userid = userid;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        this.password = password;
    }

    public Set<UserRoles> getRoles()
    {
        return roles;
    }

    public void setRoles(Set<UserRoles> roles)
    {
        this.roles = roles;
    }

//    public Set<Vote> getVotedPost()
//    {
//        return votedPost;
//    }
//
//    public void setVotedPost(Set<Vote> votedPost)
//    {
//        this.votedPost = votedPost;
//    }

    @JsonIgnore
    public List<SimpleGrantedAuthority> getAuthority() {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (UserRoles r : this. roles)
        {
            String myRole = "Role_" + r.getRole()
                .getName()
                .toUpperCase();
            list.add(new SimpleGrantedAuthority(myRole));
        }
        return list;
    }
}
