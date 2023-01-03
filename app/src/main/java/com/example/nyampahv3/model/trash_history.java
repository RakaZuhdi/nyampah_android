package com.example.nyampahv3.model;

import java.util.Date;

public class trash_history {
    public int id;
    public int user_id;
    public int driver_id;
    public String trash_img;
    public String status;
    public double weight;
    public Date created_at;
    public Date modified_at;

    public trash_history(int id_,int user_id_,int driver_id_,String trash_img_,String status_,double weight_,Date created_at_,Date modified_at_)
    {
        this.id = id_;
        this.user_id = user_id_;
        this.driver_id = driver_id_;
        this.trash_img = trash_img_;
        this.status = status_;
        this.weight = weight_;
        this.created_at = created_at_;
        this.modified_at = modified_at_;
    }

}
