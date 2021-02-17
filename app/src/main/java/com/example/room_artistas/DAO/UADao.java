package com.example.room_artistas.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.room_artistas.Entities.Artista;
import com.example.room_artistas.Entities.Usuario;
import com.example.room_artistas.Entities.UsuarioArtistaEntity;
import com.example.room_artistas.Entities.UsuarioConArtistas;

import java.util.List;

@Dao
public interface UADao {



    @Query("DELETE FROM artista")
    void deleteAll();

    @Query("DELETE FROM usuario")
    void deleteAllU();

    @Query("DELETE FROM usuarioartistaentity")
    void deleteAllUA();

    @Insert
    void insertU(Usuario usuario);

    @Insert
    void insertUA(UsuarioArtistaEntity usuarioArtistaEntity);

    @Insert
    void insert(Artista artista);

    @Update
    void update(Artista artista);

    @Delete
    void delete(Artista artista);

    @Transaction
    @Query("SELECT * FROM usuario")
    LiveData<List<UsuarioConArtistas>> getUsuariosConArtistas();


    @Query("Select * from artista")
    LiveData<List<Artista>> getArtistaList();




    /*@Transaction
    @Query("SELECT * FROM usuario WHERE idUsuario = :id")
    UsuarioConArtistas getUsuariosConArtistas(String id);*/


/*
    @Dao
    public interface MyDao {
        @Query("SELECT * FROM user WHERE age > :minAge")
        public User[] loadAllUsersOlderThan(int minAge);
    }

        @Dao
    public interface MyDao {
        @Query("SELECT * FROM user WHERE age BETWEEN :minAge AND :maxAge")
        public User[] loadAllUsersBetweenAges(int minAge, int maxAge);

        @Query("SELECT * FROM user WHERE first_name LIKE :search " +
               "OR last_name LIKE :search")
        public List<User> findUserWithName(String search);
    }

 */

}
