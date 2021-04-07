package com.eiosm.client.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.eiosm.client.models.Album;
import com.eiosm.client.repositories.AlbumRepository;

import java.util.List;

public class AlbumListViewModel extends ViewModel {
    private MutableLiveData<List<Album>> _albums;
    private AlbumRepository _albumRepository;

    public AlbumListViewModel(AlbumRepository albumRepository) {
        this._albumRepository = albumRepository;
    }

    public MutableLiveData<List<Album>> getAlbums() {
        if (_albums == null) {
            _albums = new MutableLiveData<>();
            loadAlbums();
        }
        return _albums;
    }

    private void loadAlbums() {
        _albums = _albumRepository.getAlbums();
    }
}
