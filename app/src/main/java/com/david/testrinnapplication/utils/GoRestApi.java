package com.david.testrinnapplication.utils;

import com.david.testrinnapplication.models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GoRestApi {


    @GET("public-api/users")
    Call<List<User>> getUsers();


    @GET("public-api/users")
    Call<String> getUsersByScalars();

}
