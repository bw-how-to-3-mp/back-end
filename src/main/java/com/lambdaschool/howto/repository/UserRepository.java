package com.lambdaschool.howto.repository;

import com.lambdaschool.howto.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long>
{
    User findByUsernameIgnoreCase(String username);
    List<User> findByUsernameContainingIgnoreCase(String username);
}
