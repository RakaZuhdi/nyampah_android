package com.example.nyampahv3.model;

import java.util.Date;

enum Status {
    WAITING("WAITING"),
    PICKED_UP("PICKED_UP"),
    FINISHED("FINISHED"),
    ;

    private final String text;

    /**
     * @param text
     */
    Status(final String text) {
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

public class trash_history {
    public int id;
    public int customer_id;
    public int driver_id;
    public String trash_img;
    public Status status;
    public double weight;
    public double location;
    public Date created_at;
    public Date modified_at;

    public trash_history(int id_,int customer_id,int driver_id_,String trash_img_,Status status_,double weight_,Date created_at_,Date modified_at_, double location_)
    {
        this.id = id_;
        this.customer_id = customer_id;
        this.driver_id = driver_id_;
        this.trash_img = trash_img_;
        this.status = status_;
        this.weight = weight_;
        this.location = location_;
        this.created_at = created_at_;
        this.modified_at = modified_at_;
    }

}
