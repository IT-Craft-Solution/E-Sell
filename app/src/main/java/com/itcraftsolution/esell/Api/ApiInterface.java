package com.itcraftsolution.esell.Api;

import com.itcraftsolution.esell.Model.MyAdsItem;
import com.itcraftsolution.esell.Model.ResponceInsert;
import com.itcraftsolution.esell.Model.UserModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("user/create_user.php")
    Call<ResponceInsert> InsertUser(
            @Field("phone") String phone,
            @Field("user_email") String email, @Field("user_img") String user_img,
            @Field("user_name") String user_name, @Field("user_bio") String user_bio,
            @Field("user_location") String location, @Field("user_area") String city_area,
            @Field("user_status") int status
    );


    @FormUrlEncoded
    @POST("user/read_user.php")
    Call<UserModel> ReadUser(
            @Field("phone") String phone,
            @Field("email") String email
    );

    @FormUrlEncoded
    @POST("post/create_post.php")
    Call<ResponceInsert> InsertSellItem(
            @Field("user_id") int user_id, @Field("cat_name") String cat_name,
            @Field("title") String title, @Field("description") String description,
            @Field("price") int price, @Field("location") String location,
            @Field("city_area") String city_area, @Field("item_img") String item_img,
            @Field("status") int status
    );

    @FormUrlEncoded
    @POST("post/read_post.php")
    Call<List<MyAdsItem>> ReadSellItem(
            @Field("user_id") int user_id
    );


}
