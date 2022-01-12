package com.itcraftsolution.esell.Model;

public class SellCategory {
    private int cat_img;
    private String Name ;

    public SellCategory(int cat_img, String name) {
        this.cat_img = cat_img;
        Name = name;
    }

    public SellCategory() {
    }

    public int getCat_img() {
        return cat_img;
    }

    public void setCat_img(int cat_img) {
        this.cat_img = cat_img;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
