package com.itcraftsolution.esell.Model;

public class ChatBuying {
    private int ItemImage;
    private String UserName,ItemMessage, ItemTime,ItemName;

    public ChatBuying(int itemImage, String userName, String itemMessage, String itemTime,String itemName) {
        ItemImage = itemImage;
        UserName = userName;
        ItemMessage = itemMessage;
        ItemTime = itemTime;
        ItemName = itemName;

    }

    public ChatBuying(){

    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
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
