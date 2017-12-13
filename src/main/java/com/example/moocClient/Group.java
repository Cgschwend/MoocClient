package com.example.moocClient;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.internal.LinkedTreeMap;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Group {

    private String link;
    private String city;
    private Object group_photo;
    private String highres_link;
    private String name;

    public Group() {

    }

    public Group(String link, String city, Object group_photo,  String name) {
        setLink(link);
        setCity(city);
        setGroup_photo(group_photo);
        setName(name);
    }

    public Object getGroup_photo() {

        return group_photo;
    }

    public void setGroup_photo(Object group_photo) {

        this.group_photo = group_photo;
        if (group_photo != null) {
            LinkedTreeMap temp = (com.google.gson.internal.LinkedTreeMap) group_photo;
            highres_link = temp.get("highres_link").toString();
        }
    }


    public String getHighres_link() {
        this.group_photo = group_photo;
        if (group_photo != null) {
            LinkedTreeMap temp = (com.google.gson.internal.LinkedTreeMap) group_photo;
            highres_link = temp.get("highres_link").toString();
        }
        return highres_link;
    }

    public void setHighres_link(String highres_link) {
        this.highres_link = highres_link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }



}

