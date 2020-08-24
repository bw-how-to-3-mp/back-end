package com.lambdaschool.howto.models;

import java.io.Serializable;

public class UserRolesID implements Serializable
{
    private long user;
    private long role;

    public UserRolesID()
    {
    }

    public long getUser()
    {
        return user;
    }

    public void setUser(long user)
    {
        this.user = user;
    }

    public long getRole()
    {
        return role;
    }

    public void setRole(long role)
    {
        this.role = role;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        UserRolesID that = (UserRolesID) o;
        return user == that.user &&
            role == that.role;
    }

    @Override
    public int hashCode()
    {
        return 37;
    }
}
