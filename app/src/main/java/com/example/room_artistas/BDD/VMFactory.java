package com.example.room_artistas.BDD;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import java.security.Provider;

public class VMFactory implements ViewModelProvider.Factory {
    String idU;
    Application app;

    public VMFactory(String idU, Application app) {
        this.idU = idU;
        this.app = app;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass.isAssignableFrom(ArtistaViewModel.class)){
            return (T) new ArtistaViewModel(app,idU);

        }
       throw new IllegalArgumentException("ViewModel not found");
    }
}
