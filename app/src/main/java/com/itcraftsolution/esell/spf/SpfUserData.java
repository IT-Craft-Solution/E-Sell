package com.itcraftsolution.esell.spf;

import android.content.Context;
import android.content.SharedPreferences;

import com.itcraftsolution.esell.Fragment.AdsFragment;

public class SpfUserData {

    public void setSpf(Context context, int UserId,String UserPhone, String UserEmail, String UserImage, String UserName, String UserBio , String UserCity, String CityArea, int UserStatus)
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
        editor.putInt("UserId", UserId);
        editor.apply();

    }

    public SharedPreferences getSpf(Context context)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("LoginUserDetails", Context.MODE_PRIVATE);

        return sharedPreferences;
    }

    public void setSpfHome(Context context,String Category)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("UserHomeDetails", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Category", Category);
        editor.apply();
    }
    public SharedPreferences getSpfHome(Context context)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("UserHomeDetails", Context.MODE_PRIVATE);

        return sharedPreferences;
    }
    public void setItemDetail(Context context,String Img,String Price,String Title,String Location,String Desc)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("ItemDetails", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("ItemImg", Img);
        editor.putString("ItemPrice", Price);
        editor.putString("ItemTitle", Title);
        editor.putString("ItemLocation", Location);
        editor.putString("ItemDesc", Desc);
        editor.apply();
    }
    public SharedPreferences getItemDetails(Context context)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("ItemDetails", Context.MODE_PRIVATE);

        return sharedPreferences;
    }


}
