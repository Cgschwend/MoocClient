package com.example.moocClient;

import org.springframework.context.annotation.Primary;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="mooc")
public class MoocEntity implements Serializable {

    private static final long serialVersionUID = -3009157732242241606L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String title;
    private String type;
    private String provider;
    private String imageName;
    private String imageUrl;
    private String description;
    private String moocUrl;
    private String subjectTags;
    private Integer views;
    private Integer ratings;
    private Integer reviewKey;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }


    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }


    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getMoocUrl() {
        return moocUrl;
    }

    public void setMoocUrl(String moocUrl) {
        this.moocUrl = moocUrl;
    }


    public String getSubjectTags() {
        return subjectTags;
    }

    public void setSubjectTags(String subjectTags) {
        this.subjectTags = subjectTags;
    }


    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }


    public Integer getRatings() {
        return ratings;
    }

    public void setRatings(Integer ratings) {
        this.ratings = ratings;
    }


    public int getReviewKey() {
        return reviewKey;
    }

    public void setReviewKey(int reviewKey) {
        this.reviewKey = reviewKey;
    }

    @Override
    public String toString() {
        return String.format("Mooc [id=%d, title='%s', provider='%s']", id, title, provider);
    }



}
