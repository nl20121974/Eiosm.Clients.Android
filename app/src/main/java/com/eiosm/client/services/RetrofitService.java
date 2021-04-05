package com.eiosm.client.services;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
    public static IAlbumService Create() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://dataservice.eiosm.net").addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit.create(IAlbumService.class);
    }
}