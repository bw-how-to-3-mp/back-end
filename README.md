# How-To back-end

## Create new User - returns token
```
/createnewuser
```
expecting
```
{
  "password": "string",
  "username": "string"
}
```
returns
```
{
    "access_token": "943ae615-a4ea-4926-877b-171d4d407c36",
    "token_type": "bearer",
    "scope": "read trust write"
}
```
## login - returns token
```
/login or /oauth/token
``` 
expects a valid username password

## logout - removes token from store - authorized users
```
/logout , or /oauth/revoke-token 
```

## get all post - authorized users
```
GET /posts/posts
```
returns
```

    {
        "postid": 4,
        "title": "TEST",
        "body": "TESTING",
        "user": {
            "userid": 3,
            "username": "admin",
            "roles": [
                {
                    "role": {
                        "roleid": 1,
                        "name": "ADMIN"
                    }
                }
            ],
        }
    },
    {
        "postid": 6,
        "title": "title",
        "body": "post body ",
        
        "user": {
            "userid": 5,
            "username": "newUser",
            "roles": [
                {
                    "role": {
                        "roleid": 2,
                        "name": "USER"
                    }
                }
            ]
        }
    },
    {
        "postid": 9,
        "title": "Test title",
        "body": "this is a  test",
        "user": {
            "userid": 8,
            "username": "joe",
            "roles": [
                {
                    "role": {
                        "roleid": 2,
                        "name": "USER"
                    }
                }
            ]
        }
    },
```

## submit post - authorized users
```
POST /posts/post
```
requires
```
"title": "String",
"body": "String"
```
returns
```
{
    "postid": 6,
    "title": "title",
    "body": "post body ",
    "user": {
        "userid": 5,
        "username": "newUser",
        "roles": [
            {
                "role": {
                    "roleid": 2,
                    "name": "USER"
                }
            }
        ]
    }
}
```

## edit post - authorized users
```
PUT /posts/post/{postid}
```
returns
```
{
    "postid": 6,
    "title": "title",
    "body": "post body ",
    "user": {
        "userid": 5,
        "username": "newUser",
        "roles": [
            {
                "role": {
                    "roleid": 2,
                    "name": "USER"
                }
            }
        ]
    }
}
```

## delete post - authorized users
```
DELETE /posts/post/{postid}
```

## get all post by current user - authorized users

```
GET /posts/user
```
returns
```
[
    {
        "postid": 4,
        "title": "TEST",
        "body": "TESTING",
        "user": {
            "userid": 3,
            "username": "admin",
            "roles": [
                {
                    "role": {
                        "roleid": 1,
                        "name": "ADMIN"
                    }
                }
            ],
        }
    }
]
```


## get all users - admin only

`GET /users/users`

returns
```
[
    {
        "userid": 3,
        "username": "admin",
        "roles": [
            {
                "role": {
                    "roleid": 1,
                    "name": "ADMIN"
                }
            }
        ],
        "posts": [
            {
                "postid": 4,
                "title": "TEST",
                "body": "TESTING"
            }
        ],
    },
    {
        "userid": 5,
        "username": "newUser",
        "roles": [
            {
                "role": {
                    "roleid": 2,
                    "name": "USER"
                }
            }
        ],
        "posts": [
            {
                "postid": 6,
                "title": "title",
                "body": "post body "
                        }
                    }
                ]
            }
        ],
    },
```

## get user by username - admin only
```
GET /users/user/username/{username}
```

## get list of users with username like - admin only
```
GET /users/user/username/like/{username}
```

## add admin role to current user - authorized
```
PUT /roles/user{userid}
```
## delete user by id
```
`DELETE /users/user/{userid}`
```

