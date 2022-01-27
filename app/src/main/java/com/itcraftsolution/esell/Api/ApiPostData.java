package com.itcraftsolution.esell.Api;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class ApiPostData {

    //Format Of DataBase Keys: phone,user_email,user_img,user_name,user_bio,user_location,user_area,user_status.

    private void insertUser(Context context,int UserPhone, String UserEmail, String UserImage, String UserName, String UserBio , String UserCity, String CityArea, int UserStatus)
    {
        String url= "http://192.168.0.102:80//All/user/create_user.php";

        RequestQueue requestQueue = Volley.newRequestQueue(context);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Toast.makeText(context, "Create Successfully ", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(context, "Something went wrong!! "+error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        })
        {
            @NonNull
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();

                //Format Of DataBase Keys: phone,user_email,user_img,user_name,user_bio,user_location,user_area,user_status.
                params.put("phone", String.valueOf(UserPhone));
                params.put("user_email", UserEmail);
                params.put("user_img", UserImage);
                params.put("user_name", UserName);
                params.put("user_bio", UserBio);
                params.put("user_location", UserCity);
                params.put("user_area", CityArea);
                params.put("user_status", String.valueOf(UserStatus));

                return params;
            }
        };
    }
}
