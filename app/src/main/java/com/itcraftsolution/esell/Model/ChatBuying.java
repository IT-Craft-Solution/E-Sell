package com.itcraftsolution.esell.Model;

public class ChatBuying {
    private int ItemImage;
    private String ItemName,ItemMessage, ItemTime;

    public ChatBuying(int itemImage, String itemName, String itemMessage, String itemTime) {
        ItemImage = itemImage;
        ItemName = itemName;
        ItemMessage = itemMessage;
        ItemTime = itemTime;
    }

    public ChatBuying(){

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

    public String getItemMessage() {
        return ItemMessage;
    }

    public void setItemMessage(String itemMessage) {
        ItemMessage = itemMessage;
    }

    public String getItemTime() {
        return ItemTime;
    }

    public void setItemTime(String itemTime) {
        ItemTime = itemTime;
    }
}
