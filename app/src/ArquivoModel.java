package com.com.superoti.superoti.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ArquivoModel {

    @SerializedName("total_count")
    private String total;

    @SerializedName("items")
    private List<ItemModel> Item;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<ItemModel> getItem() {
        return Item;
    }

    public void setItem(List<ItemModel> item) {
        Item = item;
    }

    @Override
    public String toString() {
        return "Total: " + getTotal() +
                "\n Nome: " + getItem();
    }
}
