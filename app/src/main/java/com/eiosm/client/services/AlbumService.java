package com.eiosm.client.services;

import com.eiosm.client.helpers.RetrofitService;
import com.eiosm.client.models.Album;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class AlbumService {

    private static IAlbumService _albumServiceClient;
    private static AlbumService _instance;

    public AlbumService() {
        _albumServiceClient = RetrofitService.Create(IAlbumService.class, "https://dataservice.eiosm.net");
    }

    public static AlbumService getInstance() {
        if (_instance == null)
            _instance = new AlbumService();
        return _instance;
    }

    public void getAlbums(Callback<List<Album>> callback) {
        Call<List<Album>> albumsCall = _albumServiceClient.getAlbums();
        albumsCall.enqueue(callback);
    }
}