package com.itcraftsolution.esell.spf;

import android.content.Context;
import android.content.SharedPreferences;

public class SpfLoginUserData {

    public void setSpf(Context context, String UserPhone, String UserEmail, String UserImage, String UserName, String UserBio , String UserCity, String CityArea, int UserStatus)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("LoginUserDetails", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("UserPhone", UserPhone);
        editor.putString("UserEmail", UserEmail);
        editor.putString("UserImage", UserImage);
        editor.putString("UserName", UserName);
        editor.putString("UserBio", UserBio);
        editor.putString("UserCity", UserCity);
        editor.putString("CityArea", CityArea);
        editor.putInt("UserStatus", UserStatus);
        editor.apply();

    }
    public SharedPreferences getSpf(Context context)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("LoginUserDetails", Context.MODE_PRIVATE);

        return sharedPreferences;
    }

}
