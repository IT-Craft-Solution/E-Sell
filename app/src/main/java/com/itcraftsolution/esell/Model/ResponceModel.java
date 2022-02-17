package com.itcraftsolution.esell.Model;

//Retrofit Responce Model Class
public class ResponceModel {
    private String message ;

    // Responce Class Constructor
    public ResponceModel(String message) {
        this.message = message;
    }

    //Responce Getter And Setter Method
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
