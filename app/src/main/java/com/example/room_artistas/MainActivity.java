package com.example.room_artistas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.room_artistas.Adapters.ArtistaAdapter;
import com.example.room_artistas.BDD.ArtistaDatabase;
import com.example.room_artistas.BDD.ArtistaViewModel;
import com.example.room_artistas.BDD.Repositorio;
import com.example.room_artistas.Entities.Artista;

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
        viewModel.getAllArtistas().observe(this, new Observer<List<Artista>>() {
            @Override
            public void onChanged(List<Artista> artistas) {
                // Se llamará cada vez que los datos en el LiveData Object cambie
                // Actualizar RecyclerView
                adapter.setArtistas(artistas);
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