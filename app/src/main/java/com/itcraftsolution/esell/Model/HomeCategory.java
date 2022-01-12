package com.itcraftsolution.esell.Model;

public class HomeCategory {
    private int Cat_Img;
    private String Cat_Name;

    public HomeCategory(int cat_Img, String cat_Name) {
        Cat_Img = cat_Img;
        Cat_Name = cat_Name;
    }

    public HomeCategory() {
    }

    public int getCat_Img() {
        return Cat_Img;
    }

    public void setCat_Img(int cat_Img) {
        Cat_Img = cat_Img;
    }

    public String getCat_Name() {
        return Cat_Name;
    }

    public void setCat_Name(String cat_Name) {
        Cat_Name = cat_Name;
    }
}
