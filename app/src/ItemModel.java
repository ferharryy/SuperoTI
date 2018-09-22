package com.com.superoti.superoti.models;

import com.google.gson.annotations.SerializedName;

public class ItemModel {

    @SerializedName("name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return getName();
    }
}
