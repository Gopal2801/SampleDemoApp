
package com.example.sampledemoapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Category {

    @SerializedName("xr_id")
    @Expose
    private String xrId;
    @SerializedName("cat")
    @Expose
    private String cat;
    @SerializedName("songs")
    @Expose
    private String songs;

    public String getXrId() {
        return xrId;
    }

    public void setXrId(String xrId) {
        this.xrId = xrId;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getSongs() {
        return songs;
    }

    public void setSongs(String songs) {
        this.songs = songs;
    }

}
