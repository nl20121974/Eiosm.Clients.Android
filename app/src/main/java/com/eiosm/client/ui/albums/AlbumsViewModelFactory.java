package com.eiosm.client.ui.albums;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.eiosm.client.MainActivity;
import com.eiosm.client.repositories.AlbumRepository;
import com.eiosm.client.ui.albums.AlbumsViewModel;

public class AlbumsViewModelFactory implements ViewModelProvider.Factory {

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(AlbumsViewModel.class)) {
            return (T) new AlbumsViewModel(AlbumRepository.getInstance(MainActivity.albumService));
        } else {
            throw new IllegalArgumentException("Unknown ViewModel class");
        }
    }
}
