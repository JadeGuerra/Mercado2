package com.example.mercado2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CadastroNovaCompra extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_nova_compra);
    }

    public void goCancelaCompra(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
