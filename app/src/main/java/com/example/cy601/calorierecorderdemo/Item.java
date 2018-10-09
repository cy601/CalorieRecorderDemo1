package com.example.cy601.calorierecorderdemo;

import java.util.Date;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity
public class Item {
    @Id
    private Long id;
    private Date rq;
    private int calorie;
    @Generated(hash = 809644512)
    public Item(Long id, Date rq, int calorie) {
        this.id = id;
        this.rq = rq;
        this.calorie = calorie;
    }
    @Generated(hash = 1470900980)
    public Item() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Date getRq() {
        return this.rq;
    }
    public void setRq(Date rq) {
        this.rq = rq;
    }
    public int getCalorie() {
        return this.calorie;
    }
    public void setCalorie(int calorie) {
        this.calorie = calorie;
    }

}