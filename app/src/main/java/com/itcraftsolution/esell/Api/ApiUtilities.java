package com.itcraftsolution.esell.Api;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiUtilities {
    private static final String BASE_URL= "https://esell.co.in/esell_api/";
    public static final String UserImage ="https://esell.co.in/esell_api/user/images/";
    public static final String SellItemImage ="https://esell.co.in/esell_api/post/images/";
    public static final String HomeCategory ="https://esell.co.in/admin/assets/images/";
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
