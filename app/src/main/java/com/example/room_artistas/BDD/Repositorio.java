package com.example.room_artistas.BDD;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.room_artistas.DAO.UADao;
import com.example.room_artistas.Entities.Artista;
import com.example.room_artistas.Entities.Usuario;
import com.example.room_artistas.Entities.UsuarioArtistaEntity;
import com.example.room_artistas.Entities.UsuarioConArtistas;

import java.util.List;

public class Repositorio {
    private UADao UADao;
    private LiveData<List<Artista>> listaArtistas;
    private LiveData<List<UsuarioConArtistas>> listaUsuariosConArtistas;

    public Repositorio(Application application) {
        ArtistaDatabase database = ArtistaDatabase.getInstance(application);
        UADao = database.artistaDao();
        listaArtistas = UADao.getArtistaList();
        listaUsuariosConArtistas = UADao.getUsuariosConArtistas();
    }

    public void insertUA(UsuarioArtistaEntity usuarioArtistaEntity){
        new InsertUAAsyncTask(UADao).execute(usuarioArtistaEntity);
    }

    public void insertU(Usuario usuario){
        new InsertUsuarioAsyncTask(UADao).execute(usuario);
    }

    public void insert(Artista artista){
        new InsertArtistaAsyncTask(UADao).execute(artista);
    }

    public void update(Artista artista){
        new UpdateArtistaAsyncTask(UADao).execute(artista);
    }

    public void deleteAll(){
        new DeleteAllArtistaAsyncTask(UADao).execute();
    }

    public void deleteAllU(){ new DeleteAllUsuariosAsyncTask(UADao).execute(); }

    public void deleteAllUA(){
        new DeleteAllUAAsyncTask(UADao).execute();
    }

    public void delete(Artista artista){
        new DeleteArtistaAsyncTask(UADao).execute();
    }

    public LiveData<List<Artista>> getArtistaList() {
        return listaArtistas;
    }

    public LiveData<List<UsuarioConArtistas>> getUsuariosConArtistas() {
        return listaUsuariosConArtistas;
    }

    /*public UsuarioConArtistas getUsuarioConArtistas() {
        return listaUsuarioConArtistas;
    }*/


    /////////////////////////////////////////////////////////////////////////////////////////////

    private static class InsertUsuarioAsyncTask extends AsyncTask<Usuario, Void, Void>{

        private UADao UADao;

        public InsertUsuarioAsyncTask(UADao UADao) {
            this.UADao = UADao;
        }

        @Override
        protected Void doInBackground(Usuario... usuario) {
            UADao.insertU(usuario[0]);
            return null;
        }
    }

    private static class InsertUAAsyncTask extends AsyncTask<UsuarioArtistaEntity, Void, Void>{

        private UADao UADao;

        public InsertUAAsyncTask(UADao UADao) {
            this.UADao = UADao;
        }

        @Override
        protected Void doInBackground(UsuarioArtistaEntity... usuarioArtistaEntities) {
            UADao.insertUA(usuarioArtistaEntities[0]);
            return null;
        }
    }


    private static class InsertArtistaAsyncTask extends AsyncTask<Artista, Void, Void>{

        private UADao UADao;

        public InsertArtistaAsyncTask(UADao UADao) {
            this.UADao = UADao;
        }

        @Override
        protected Void doInBackground(Artista... artistas) {
            UADao.insert(artistas[0]);
            return null;
        }
    }

    private static class UpdateArtistaAsyncTask extends AsyncTask<Artista, Void, Void>{

        private UADao UADao;

        public UpdateArtistaAsyncTask(UADao UADao) {
            this.UADao = UADao;
        }

        @Override
        protected Void doInBackground(Artista... artistas) {
            UADao.update(artistas[0]);
            return null;
        }
    }

    private static class DeleteArtistaAsyncTask extends AsyncTask<Artista, Void, Void>{

        private UADao UADao;

        public DeleteArtistaAsyncTask(UADao UADao) {
            this.UADao = UADao;
        }

        @Override
        protected Void doInBackground(Artista... artistas) {
            UADao.delete(artistas[0]);
            return null;
        }
    }


    private static class DeleteAllArtistaAsyncTask extends AsyncTask<Void, Void, Void>{

        private UADao UADao;

        public DeleteAllArtistaAsyncTask(UADao UADao) {
            this.UADao = UADao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            UADao.deleteAll();
            return null;
        }


    }

    private static class DeleteAllUsuariosAsyncTask extends AsyncTask<Void, Void, Void>{

        private UADao UADao;

        public DeleteAllUsuariosAsyncTask(UADao UADao) {
            this.UADao = UADao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            UADao.deleteAllU();
            return null;
        }

    }

    private static class DeleteAllUAAsyncTask extends AsyncTask<Void, Void, Void>{

        private UADao UADao;

        public DeleteAllUAAsyncTask(UADao UADao) {
            this.UADao = UADao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            UADao.deleteAllUA();
            return null;
        }

    }

}
