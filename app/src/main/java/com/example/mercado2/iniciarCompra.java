package com.example.mercado2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class iniciarCompra extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_compra);
    }

    public void goIniciar(View view) {
        Intent intent = new Intent(this, CadastroNovaCompra.class);
        startActivity(intent);
    }
}
