package com.itcraftsolution.esell.Model;

public class HomeFreshItem {
    private int ItemImage;
    private String ItemName,ItemPrice, ItemLocation;


    public HomeFreshItem(int itemImage, String itemName, String itemPrice, String itemLocation) {
        ItemImage = itemImage;
        ItemName = itemName;
        ItemPrice = itemPrice;
        ItemLocation = itemLocation;
    }

    public HomeFreshItem() {
    }

    public int getItemImage() {
        return ItemImage;
    }

    public void setItemImage(int itemImage) {
        ItemImage = itemImage;
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

    public String getItemLocation() {
        return ItemLocation;
    }

    public void setItemLocation(String itemLocation) {
        ItemLocation = itemLocation;
    }
}
