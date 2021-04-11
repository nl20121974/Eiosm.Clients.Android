package com.eiosm.client.helpers;

import com.eiosm.client.services.IAlbumService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
    public static<T> T Create(Class<T> type, String uri) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(uri).addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit.create(type);
    }
}