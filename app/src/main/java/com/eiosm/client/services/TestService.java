package com.eiosm.client.services;

import com.eiosm.client.helpers.DataService;
import com.eiosm.client.helpers.RetrofitService;
import com.eiosm.client.models.Album;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;

public class TestService {

    private IAlbumService _albumService;

    public TestService(String uri) {
        _albumService = RetrofitService.Create(IAlbumService.class, uri);
    }

    public void getAlbums(Callback<List<Album>> callback) {
        Call<List<Album>> albumsCall = _albumService.getAlbums();
        albumsCall.enqueue(callback);
    }
}
