package com.example.testinterview.model;

import com.google.gson.annotations.SerializedName;

public class ImageList {

    public final long id;
    public final String name;
    public final String description;

    @SerializedName("stargazers_count")
    public final long stars;
    @SerializedName("forks_count")
    public final long forks;

    public ImageList(long id, String name, String description, long stars, long forks) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.stars = stars;
        this.forks = forks;
    }
}
