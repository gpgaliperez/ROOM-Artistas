package com.example.room_artistas.Entities;

import androidx.room.Entity;
import androidx.annotation.NonNull;

@Entity(primaryKeys = {"usuarioId", "artistaId"})
public class UsuarioArtistaEntity {

    @NonNull private String usuarioId;
    @NonNull private int artistaId;

    public UsuarioArtistaEntity(String usuarioId, int artistaId) {
        this.usuarioId = usuarioId;
        this.artistaId = artistaId;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getArtistaId() {
        return artistaId;
    }

    public void setArtistaId(int artistaId) {
        this.artistaId = artistaId;
    }
}
