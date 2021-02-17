package com.example.room_artistas.BDD;


import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.room_artistas.DAO.UADao;
import com.example.room_artistas.Entities.Artista;
import com.example.room_artistas.Entities.Usuario;
import com.example.room_artistas.Entities.UsuarioArtistaEntity;

@Database(entities = {Artista.class, Usuario.class, UsuarioArtistaEntity.class}, exportSchema = false, version = 1)

public abstract class ArtistaDatabase extends RoomDatabase {

    private static final String BDD_NAME = "artista.db";
    private static volatile ArtistaDatabase INSTANCE;



    public static ArtistaDatabase getInstance(final Context context) {
        if (INSTANCE == null) {
            synchronized (ArtistaDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ArtistaDatabase.class, BDD_NAME)
                            .addCallback(roomCallnack)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback roomCallnack = new RoomDatabase.Callback(){
        public void onCreate(@NonNull SupportSQLiteDatabase db){
            super.onCreate(db);
            new LLenarBDDAsyncTask(INSTANCE).execute();
        }
    };

    private static class LLenarBDDAsyncTask extends AsyncTask<Void, Void, Void>{
        private UADao UADao;

        public LLenarBDDAsyncTask(ArtistaDatabase db) {
            this.UADao = db.artistaDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {


            UADao.insert(new Artista("Harry STasdasdyles"));
            UADao.insert(new Artista("Niallasd asdasdHOran"));
            UADao.insert(new Artista("Perasdl JaasdasdasM"));
            UADao.insert(new Artista("The asdKillErs"));
            UADao.insert(new Artista("Ladyasdas GagA"));
            UADao.insert(new Artista("Chrisasdas CoOrnell"));
            UADao.insert(new Artista("Harry SasdasTyles"));
            UADao.insert(new Artista("Niallasd HOran"));
            UADao.insert(new Artista("Perasdl JasdM"));
            UADao.insert(new Artista("The KasdaillErs"));
            UADao.insert(new Artista("Ladyasd GagA"));
            UADao.insert(new Artista("Chris CasdoOrnell"));
            UADao.insert(new Artista("Harry asdSTyles"));
            UADao.insert(new Artista("Niallaasds HOran"));
            UADao.insert(new Artista("Perl JdaaM"));

            return null;
        }
    }
    public abstract UADao artistaDao();
}
