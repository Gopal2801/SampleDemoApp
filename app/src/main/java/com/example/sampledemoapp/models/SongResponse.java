
package com.example.sampledemoapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SongResponse {

    @SerializedName("xr_id")
    @Expose
    private String xrId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("keywords")
    @Expose
    private String keywords;
    @SerializedName("note")
    @Expose
    private String note;
    @SerializedName("album")
    @Expose
    private String album;
    @SerializedName("logo")
    @Expose
    private String logo;
    @SerializedName("song")
    @Expose
    private String song;
    @SerializedName("artist_id")
    @Expose
    private String artistId;
    @SerializedName("catagory_id")
    @Expose
    private String catagoryId;
    @SerializedName("duration")
    @Expose
    private String duration;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("xr_flag")
    @Expose
    private String xrFlag;

    public String getXrId() {
        return xrId;
    }

    public void setXrId(String xrId) {
        this.xrId = xrId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public String getArtistId() {
        return artistId;
    }

    public void setArtistId(String artistId) {
        this.artistId = artistId;
    }

    public String getCatagoryId() {
        return catagoryId;
    }

    public void setCatagoryId(String catagoryId) {
        this.catagoryId = catagoryId;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getXrFlag() {
        return xrFlag;
    }

    public void setXrFlag(String xrFlag) {
        this.xrFlag = xrFlag;
    }

}
