package com.example.room_artistas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class PerfilArtistaActivity extends AppCompatActivity {
    TextView tv_nombrePerfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_artista);

        tv_nombrePerfil = findViewById(R.id.tv_nombrePerfil);

        // Extraer data del recycler
        Intent intent = getIntent();
        tv_nombrePerfil.setText(intent.getStringExtra("nombre"));

    }
}