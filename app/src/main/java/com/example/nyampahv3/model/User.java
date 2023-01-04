package com.example.nyampahv3.model;

import java.util.Date;



public class User
{

    public static enum Type {
        DRIVER("DRIVER"),
        CUSTOMER("CUSTOMER")
        ;

        private final String text;

        /**
         * @param text
         */
        Type(final String text) {
            this.text = text;
        }

        /* (non-Javadoc)
         * @see java.lang.Enum#toString()
         */
        @Override
        public String toString() {
            return text;
        }
    }

    public int id;
    public String fullname;
    public String email;
    public String password;
    public int point;
    public Type type;
    public Date created_at;
    public Date modified_at;


    public String token;
    public double total_trash_weight;
    public double total_pickedup_trash;

    public User(){

    }

    public User(String fullname_,String email_,String password_){
        this.fullname = fullname_;
        this.email = email_;
        this.password = password_;
    }

    public User(int id_,String fullname_,String email_,String password_,int point_, Date created_at_,Date modified_at_, String token, double total_trash_weight, Type type, double total_pickedup_trash)
    {
        this.id = id_;
        this.fullname = fullname_;
        this.email = email_;
        this.password = password_;
        this.point = point_;
        this.created_at = created_at_;
        this.modified_at = modified_at_;

        this.token = token;
        this.total_trash_weight = total_trash_weight;
        this.total_pickedup_trash = total_pickedup_trash;
        this.type = type;
    }


    public static User defaultInstance()
    {
        return new User(0,"abc", "abc@abc.com", " ", 0, new Date(), null, null,0, Type.CUSTOMER,0);
    }
}