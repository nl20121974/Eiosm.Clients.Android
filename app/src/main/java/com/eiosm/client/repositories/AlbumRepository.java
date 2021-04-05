package com.eiosm.client.repositories;

import androidx.lifecycle.MutableLiveData;

import com.eiosm.client.models.Album;
import com.eiosm.client.services.AlbumService;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumRepository {

    private static volatile AlbumRepository _instance;
    private static AlbumService _albumService;
    private final MutableLiveData<List<Album>> _albums = new MutableLiveData<>();

    public static AlbumRepository getInstance(AlbumService albumService) {
        if (_instance == null)
            _instance = new AlbumRepository(albumService);
        return _instance;
    }

    public AlbumRepository(AlbumService albumService) {
        this._albumService = albumService;
    }

    public MutableLiveData<List<Album>> getAlbums() {
        _albumService.getAlbums(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, @NotNull Response<List<Album>> response) {
                if (response.isSuccessful()) {
                    List<Album> albums = response.body();
                    _albums.setValue(albums);
                } else {
                    _albums.postValue(null);
                }
            }

            @Override
            public void onFailure(@NotNull Call<List<Album>> call, Throwable t) {
                _albums.postValue(null);
            }
        });
        return _albums;
    }
}
