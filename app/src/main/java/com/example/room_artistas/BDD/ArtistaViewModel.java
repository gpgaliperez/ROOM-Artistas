package com.example.room_artistas.BDD;


import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.room_artistas.BDD.Repositorio;
import com.example.room_artistas.Entities.Artista;
import com.example.room_artistas.Entities.Usuario;
import com.example.room_artistas.Entities.UsuarioArtistaEntity;
import com.example.room_artistas.Entities.UsuarioConArtistas;

import java.util.List;


public class ArtistaViewModel extends AndroidViewModel {

    private Repositorio repositorio;
    private LiveData<List<Artista>> allNotes;
    private LiveData<List<UsuarioConArtistas>> allUsuariosConArtistas;

    public ArtistaViewModel(@NonNull Application application) {
        super(application);
        repositorio = new Repositorio(application);
        allNotes = repositorio.getArtistaList();
        allUsuariosConArtistas = repositorio.getUsuariosConArtistas();
    }

    public void insertUA(UsuarioArtistaEntity usuarioArtistaEntity) {
        repositorio.insertUA(usuarioArtistaEntity);
    }

    public void insertU(Usuario usuario) {
        repositorio.insertU(usuario);
    }

    public void insert(Artista artista) {
        repositorio.insert(artista);
    }

    public void update(Artista artista) {
        repositorio.update(artista);
    }

    public void delete(Artista artista) {
        repositorio.delete(artista);
    }

    public void deleteAll() {
        repositorio.deleteAll();
    }

    public void deleteAllU() {
        repositorio.deleteAllU();
    }

    public void deleteAllUA() {
        repositorio.deleteAllUA();
    }

    public LiveData<List<Artista>> getAllArtistas() {
        return allNotes;
    }

    public LiveData<List<UsuarioConArtistas>> getAllUsuariosConArtistas() { return allUsuariosConArtistas; }

    /*public LiveData<UsuarioConArtistas> getUsuarioConArtistas(String uId){
        return allUsuariosConArtistas
    }*/
}