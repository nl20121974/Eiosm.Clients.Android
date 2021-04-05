package com.eiosm.client.services;

import com.eiosm.client.models.Album;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IAlbumService {
    @GET("albums")
    Call<List<Album>> getAlbums();

    @GET("albums/{id}")
    Call<Album> getAlbum(int id);
}
