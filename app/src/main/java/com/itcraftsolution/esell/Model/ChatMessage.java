package com.itcraftsolution.esell.Model;

public class ChatMessage {

    private String messageId,Message, SenderId;
    private long Timestamp;

    public ChatMessage() {
    }

    public ChatMessage(String message, String senderId, long timestamp) {

        Message = message;
        SenderId = senderId;
        Timestamp = timestamp;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getSenderId() {
        return SenderId;
    }

    public void setSenderId(String senderId) {
        SenderId = senderId;
    }

    public long getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(long timestamp) {
        Timestamp = timestamp;
    }
}
