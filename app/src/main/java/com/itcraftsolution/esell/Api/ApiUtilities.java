package com.itcraftsolution.esell.Api;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiUtilities {
    private static final String BASE_URL= "http://192.168.0.105:80/all/";
    public static final String UserImage ="http://192.168.0.105:80/all/user/images/";
    public static final String SellItemImage ="http://192.168.0.105:80/all/post/images/";
    public static Retrofit retrofit = null;

    public static ApiInterface apiInterface()
    {

        if(retrofit == null)
        {

            Gson gson =new GsonBuilder()
                    .setLenient()
                    .create();
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit.create(ApiInterface.class);
    }

}
