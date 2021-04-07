package com.eiosm.client.viewmodels;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.eiosm.client.MainActivity;
import com.eiosm.client.repositories.AlbumRepository;

public class AlbumViewModelFactory implements ViewModelProvider.Factory {

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(AlbumListViewModel.class)) {
            return (T) new AlbumListViewModel(AlbumRepository.getInstance(MainActivity.albumService));
        } else {
            throw new IllegalArgumentException("Unknown ViewModel class");
        }
    }
}
