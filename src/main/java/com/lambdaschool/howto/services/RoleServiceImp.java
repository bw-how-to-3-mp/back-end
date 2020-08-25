package com.lambdaschool.howto.services;

import com.lambdaschool.howto.exceptions.ResourceFoundException;
import com.lambdaschool.howto.exceptions.ResourceNotFoundException;
import com.lambdaschool.howto.models.Role;
import com.lambdaschool.howto.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "roleService")
public class RoleServiceImp implements RoleService
{
    @Autowired
    RoleRepository rolerepo;

    @Override
    public List<Role> findAll()
    {
        List<Role> roles = new ArrayList<>();
        rolerepo.findAll()
            .iterator()
            .forEachRemaining(roles::add);
        return roles;
    }

    @Override
    public Role findRoleById(long id)
    {
        return rolerepo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Role id " + id + " not found!"));
    }

    @Override
    public Role save(Role role)
    {
        if (role.getUsers()
            .size() > 0)
        {
            throw new ResourceFoundException("User Roles are not updated through Role.");
        }

        return rolerepo.save(role);
    }

    @Override
    public Role findByName(String name)
    {
        Role role = rolerepo.findByNameIgnoreCase(name);

        if (role == null)
        {
            throw new ResourceNotFoundException("Role " + name + " is not found!");
        }
        return role;
    }

    @Override
    public Role update(
        long id,
        Role role)
    {
        return null;
    }
}
