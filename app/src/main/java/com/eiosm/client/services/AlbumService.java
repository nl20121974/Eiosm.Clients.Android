package com.eiosm.client.services;

import com.eiosm.client.models.Album;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class AlbumService {

    private static IAlbumService _albumServiceClient;
    private static AlbumService _albumService;

    public AlbumService() {
        _albumServiceClient = RetrofitService.Create();
    }

    public static AlbumService getInstance() {
        if (_albumService == null)
            _albumService = new AlbumService();
        return _albumService;
    }

    public void getAlbums(Callback<List<Album>> callback) {
        Call<List<Album>> albumsCall = _albumService.getAlbums(callback);
        albumsCall.enqueue(callback);
    }

}