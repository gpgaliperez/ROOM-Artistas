package com.example.room_artistas.Entities;


import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

@Entity(tableName = "usuario")
public class Usuario {
    @NonNull
    @PrimaryKey
    private String usuarioId;

    public Usuario(@NonNull String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }
}