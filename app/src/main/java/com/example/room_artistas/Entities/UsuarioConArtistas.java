package com.example.room_artistas.Entities;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import java.util.List;

public class UsuarioConArtistas {
    @Embedded
    private Usuario usuario;
    @Relation(
            parentColumn = "usuarioId",
            entityColumn = "artistaId",
            associateBy = @Junction(UsuarioArtistaEntity.class)
    )
    List<Artista> artistas;



    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Artista> getArtistas() {
        return artistas;
    }

    public void setArtistas(List<Artista> artistas) {
        this.artistas = artistas;
    }
}
