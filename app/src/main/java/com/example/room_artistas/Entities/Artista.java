package com.example.room_artistas.Entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

//TODO https://medium.com/mindorks/using-room-database-android-jetpack-675a89a0e942

@Entity(tableName = "artista")
public class Artista {
    @PrimaryKey(autoGenerate = true)
    private int artistaId;

    @ColumnInfo(name = "nombre")
    private String nombre;

    public Artista(String nombre) {
        this.nombre = nombre;
    }

    public int getArtistaId() {
        return artistaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setArtistaId(int artistaId) {
        this.artistaId = artistaId;
    }
}
