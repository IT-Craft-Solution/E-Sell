package com.itcraftsolution.esell.Api;

import com.itcraftsolution.esell.Model.ChatModel;
import com.itcraftsolution.esell.Model.MyAdsItem;
import com.itcraftsolution.esell.Model.ResponceModel;
import com.itcraftsolution.esell.Model.UserModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("user/create_user.php")
    Call<ResponceModel> InsertUser(
            @Field("phone") String phone,
            @Field("user_email") String email, @Field("user_img") String user_img,
            @Field("user_name") String user_name, @Field("user_bio") String user_bio,
            @Field("user_location") String location, @Field("user_area") String city_area,
            @Field("user_status") int status, @Field("auth_id") String auth_id
    );

    @FormUrlEncoded
    @POST("chat/create_chat.php")
    Call<ResponceModel> CreateChat(
            @Field("user_name") String user_name,
            @Field("user_img") String user_img, @Field("item_location") String item_location,
            @Field("item_title") String item_title, @Field("receiver_id") String receiver_id,
            @Field("status") int status
    );

    @FormUrlEncoded
    @POST("user/read_user.php")
    Call<UserModel> ReadUser(
            @Field("phone") String phone,
            @Field("email") String email
    );

    @FormUrlEncoded
    @POST("user/read_user_id.php")
    Call<UserModel> ReadUserId(
            @Field("id") int id

    );

    @FormUrlEncoded
    @POST("chat/read_chat_user.php")
    Call<List<ChatModel>> ReadChatUser(
            @Field("receiver_id") String receiver_id,@Field("user_name") String user_name

    );

    @FormUrlEncoded
    @POST("user/update_user.php")
    Call<ResponceModel> UpdateUser(
            @Field("id") int id, @Field("user_img") String user_img,
            @Field("user_name")String username,@Field("user_bio")String userbio,
            @Field("location")String location,@Field("city_area")String cite_area,
            @Field("status") int status
    );

    @FormUrlEncoded
    @POST("user/lastupdate_user.php")
    Call<ResponceModel> LastUpdateUser(
            @Field("id") int id, @Field("status") int status
    );


    @FormUrlEncoded
    @POST("post/create_post.php")
    Call<ResponceModel> InsertSellItem(
            @Field("user_id") int user_id, @Field("cat_name") String cat_name,
            @Field("title") String title, @Field("description") String description,
            @Field("price") int price, @Field("location") String location,
            @Field("city_area") String city_area, @Field("item_img") String item_img,
            @Field("status") int status, @Field("auth_id") String auth_id
    );

    @FormUrlEncoded
    @POST("post/myad_post.php")
    Call<List<MyAdsItem>> MyadSellItem(
            @Field("user_id") int user_id
    );



    @POST("post/read_post.php")
    Call<List<MyAdsItem>> ReadSellItem();


    @FormUrlEncoded
    @POST("post/update_post.php")
    Call<ResponceModel> UpdateSellItem(
            @Field("id") int id, @Field("cat_name") String cat_name,
            @Field("title") String title, @Field("description") String description,
            @Field("price") int price, @Field("location") String location,
            @Field("city_area") String city_area, @Field("item_img") String item_img,
            @Field("status") int status
    );

    @FormUrlEncoded
    @POST("post/fav_post.php")
    Call<ResponceModel> UpdateLike(
            @Field("id") int id, @Field("fav") int fav
    );

    @FormUrlEncoded
    @POST("post/fav_read_post.php")
    Call<List<MyAdsItem>> ReadLike(
            @Field("fav") int fav
    );

    @FormUrlEncoded
    @POST("post/delete_post.php")
    Call<ResponceModel> DeleteSellItem(
            @Field("id") int id,@Field("status") int status
    );



}
