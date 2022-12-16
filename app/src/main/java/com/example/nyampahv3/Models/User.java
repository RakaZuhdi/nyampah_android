package com.example.nyampahv3.Models;

import java.util.Date;

public class User
{
    public int id;
    public String fullname;
    public String email;
    public String password;
    public int point;
    public Date created_at;
    public Date modified_at;

    public User(int id_,String fullname_,String email_,String password_,int point_, Date created_at_,Date modified_at_)
    {
        this.id = id_;
        this.fullname = fullname_;
        this.email = email_;
        this.password = password_;
        this.point = point_;
        this.created_at = created_at_;
        this.modified_at = modified_at_;
    }
}