package com.example.room_artistas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
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

        viewModel = new ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(ArtistaViewModel.class);
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
        Usuario u = new Usuario("10101010");
        String idUsuario = u.getUsuarioId();
        viewModel.insertU(u);

        viewModel.insertUA(new UsuarioArtistaEntity(idUsuario, 1));
        viewModel.insertUA(new UsuarioArtistaEntity(idUsuario, 2));
        viewModel.insertUA(new UsuarioArtistaEntity(idUsuario, 3));
        viewModel.insertUA(new UsuarioArtistaEntity(idUsuario, 4));

        viewModel.getAllUsuariosConArtistas().observe(this, new Observer<List<UsuarioConArtistas>>() {
            @Override
            public void onChanged(List<UsuarioConArtistas> artistas) {
                // Se llamará cada vez que los datos en el LiveData Object cambie
                // Actualizar RecyclerView
                UsuarioConArtistas uCa = artistas.get(0);
                Log.d("ROOM ", "usuarioId dentro de viewModel.getAllUcA " + uCa.getUsuario().getUsuarioId());
                adapter.setArtistas(uCa.getArtistas());
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


}