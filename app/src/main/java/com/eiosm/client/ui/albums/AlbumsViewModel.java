package com.eiosm.client.ui.albums;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.eiosm.client.models.Album;
import com.eiosm.client.repositories.AlbumRepository;

import java.util.List;

public class AlbumsViewModel extends ViewModel {
    private MutableLiveData<List<Album>> _albums;
    private AlbumRepository _albumRepository;

    public AlbumsViewModel(AlbumRepository albumRepository) {
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
