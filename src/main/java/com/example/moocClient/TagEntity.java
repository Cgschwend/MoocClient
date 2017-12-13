package com.example.moocClient;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="tags")
public class TagEntity implements Serializable {

    private static final long serialVersionUID = -3009157732242241606L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;
    private String tag;
    private String moocid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getMoocid() {
        return moocid;
    }

    public void setMoocId(String moocid) {
        this.moocid = moocid;
    }
}