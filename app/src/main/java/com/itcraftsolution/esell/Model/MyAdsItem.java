package com.itcraftsolution.esell.Model;

public class MyAdsItem {
    private int ItemImage;
    private String ItemName,ItemPrice,Date,ItemLocation,ItemViews,ItemLikes;

    public MyAdsItem(int itemImage, String itemName, String itemPrice, String date, String itemLocation, String itemViews, String itemLikes) {
        ItemImage = itemImage;
        ItemViews = itemViews;
        ItemLikes = itemLikes;
        ItemName = itemName;
        ItemPrice = itemPrice;
        Date = date;
        ItemLocation = itemLocation;
    }

    public MyAdsItem(){

    }

    public int getItemImage() {
        return ItemImage;
    }

    public void setItemImage(int itemImage) {
        ItemImage = itemImage;
    }

    public String getItemViews() {
        return ItemViews;
    }

    public void setItemViews(String itemViews) {
        ItemViews = itemViews;
    }

    public String getItemLikes() {
        return ItemLikes;
    }

    public void setItemLikes(String itemLikes) {
        ItemLikes = itemLikes;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public String getItemPrice() {
        return ItemPrice;
    }

    public void setItemPrice(String itemPrice) {
        ItemPrice = itemPrice;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getItemLocation() {
        return ItemLocation;
    }

    public void setItemLocation(String itemLocation) {
        ItemLocation = itemLocation;
    }

}
