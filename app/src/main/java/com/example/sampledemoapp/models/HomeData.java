package com.example.sampledemoapp.models;

import java.util.ArrayList;

public class HomeData {
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    private String Name = "";
    private String Url = "";
    private String Description = "";

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    private String Title = "";

    public ArrayList<HomeField> getHomeFiledListItem() {
        return homeFiledListItem;
    }

    public void setHomeFiledListItem(ArrayList<HomeField> homeFiledListItem) {
        this.homeFiledListItem = homeFiledListItem;
    }

    private ArrayList<HomeField> homeFiledListItem = new ArrayList<>();

}
