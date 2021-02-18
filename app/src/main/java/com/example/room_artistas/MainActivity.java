package com.example.room_artistas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.room_artistas.Adapters.ArtistaAdapter;
import com.example.room_artistas.BDD.ArtistaDatabase;
import com.example.room_artistas.BDD.ArtistaViewModel;
import com.example.room_artistas.BDD.Repositorio;
import com.example.room_artistas.BDD.VMFactory;
import com.example.room_artistas.Entities.Artista;
import com.example.room_artistas.Entities.Usuario;
import com.example.room_artistas.Entities.UsuarioArtistaEntity;
import com.example.room_artistas.Entities.UsuarioConArtistas;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerArtistas;

    ArtistaAdapter adapter;


    private ArtistaViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerArtistas = findViewById(R.id.recycler_artistas);
        // Inicializar el linear layout
        recyclerArtistas.setLayoutManager(new LinearLayoutManager(this));
        recyclerArtistas.setHasFixedSize(true);

        // Inicializar el adaptador
        adapter = new ArtistaAdapter();
        recyclerArtistas.setAdapter(adapter);

        // Crear usuario prueba
        Usuario u = new Usuario("123456");
        String idUsuario = u.getUsuarioId();

        VMFactory vmFactory = new VMFactory(idUsuario, this.getApplication());
        //https://stackoverflow.com/questions/51829280/how-to-use-a-viewmodelprovider-factory-when-extends-from-androidviewmodel
        viewModel = new ViewModelProvider(this, vmFactory).get(ArtistaViewModel.class);

        //viewModel = new ViewModelProvider(this,
        //  ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(ArtistaViewModel.class);


        /*viewModel.getAllArtistas().observe(this, new Observer<List<Artista>>() {
            @Override
            public void onChanged(List<Artista> artistas) {
                // Se llamará cada vez que los datos en el LiveData Object cambie
                // Actualizar RecyclerView
                adapter.setArtistas(artistas);
            }
        });*/

        //////////////////////////////////////////
        viewModel.deleteAllUA();
        viewModel.deleteAllU();
        viewModel.insertU(u);

        viewModel.insertUA(new UsuarioArtistaEntity(idUsuario, 1));



        viewModel.getUsuarioConArtistas().observe(this, new Observer<UsuarioConArtistas>() {
            @Override
            public void onChanged(UsuarioConArtistas artistas) {
                // Se llamará cada vez que los datos en el LiveData Object cambie
                // Actualizar RecyclerView
                Usuario uCa = artistas.getUsuario();
                Log.d("ROOM ", "usuarioId dentro de viewModel.getAllUcA " + uCa.getUsuarioId());

                adapter.setArtistas(artistas.getArtistas());
            }
        });

        adapter.setOnArtistaClickListener(new ArtistaAdapter.OnArtistaClickListener() {
            @Override
            public void onArtistaClick(Artista artista) {
                Intent i = new Intent(MainActivity.this, PerfilArtistaActivity.class);
                //i.putExtra("image", );
                i.putExtra("nombre", artista.getNombre());
                startActivity(i);
            }
        });


    }





        /*viewModel.getAllUsuariosConArtistas().observe(this, new Observer<List<UsuarioConArtistas>>() {
            @Override
            public void onChanged(List<UsuarioConArtistas> artistas) {
                // Se llamará cada vez que los datos en el LiveData Object cambie
                // Actualizar RecyclerView
                UsuarioConArtistas uCa = artistas.get(0);
                Log.d("ROOM ", "usuarioId dentro de viewModel.getAllUcA " + uCa.getUsuario().getUsuarioId());

                adapter.setArtistas(uCa.getArtistas());
            }
        });*/
}