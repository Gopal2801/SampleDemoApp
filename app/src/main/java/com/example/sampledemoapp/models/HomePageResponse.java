
package com.example.sampledemoapp.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HomePageResponse {

    @SerializedName("songs")
    @Expose
    private List<Song> songs = null;
    @SerializedName("albums")
    @Expose
    private List<Album> albums = null;
    @SerializedName("artists")
    @Expose
    private List<Artist> artists = null;
    @SerializedName("category")
    @Expose
    private List<Category> category = null;

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public List<Category> getCategory() {
        return category;
    }

    public void setCategory(List<Category> category) {
        this.category = category;
    }

}
