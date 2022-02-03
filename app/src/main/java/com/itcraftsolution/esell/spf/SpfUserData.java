package com.itcraftsolution.esell.spf;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.itcraftsolution.esell.Fragment.AdsFragment;

import java.io.File;

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

    public void setSpfHome(Context context,String Category,int Insert, int Update,String Title,String Desc, String Price,String Location, String Img)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("UserHomeDetails", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Category", Category);
        editor.putInt("Insert", Insert);
        editor.putInt("Update", Update);
        editor.putString("Title", Title);
        editor.putString("Desc", Desc);
        editor.putString("Price", Price);
        editor.putString("Location", Location);
        editor.putString("Img", Img);
        editor.apply();
    }
    public SharedPreferences getSpfHome(Context context)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("UserHomeDetails", Context.MODE_PRIVATE);

        return sharedPreferences;
    }
    public void setItemDetail(Context context,String Img,String Price,String Title,String Location,String Desc,int Id)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("ItemDetails", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("ItemId", Id);
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
    public boolean RemoveAllSpf(Context context)
    {
        boolean isDelete;
        SharedPreferences sharedPreferences = context.getSharedPreferences("LoginUserDetails", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        SharedPreferences spf = context.getSharedPreferences("UserHomeDetails", Context.MODE_PRIVATE);
        SharedPreferences.Editor spfeditor = spf.edit();
        spfeditor.clear();
        spfeditor.apply();
        SharedPreferences sp = context.getSharedPreferences("ItemDetails", Context.MODE_PRIVATE);
        SharedPreferences.Editor speditor = sp.edit();
        speditor.clear();
        speditor.apply();
        isDelete = true;
        return isDelete;
    }


}
