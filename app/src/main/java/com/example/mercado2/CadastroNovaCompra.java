package com.example.mercado2;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mercado2.data.banco;
import com.example.mercado2.data.mercadoContract.compraEntry;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CadastroNovaCompra extends AppCompatActivity {

    private EditText localEditText;
    private EditText segmentoEditText;
    private TextView dateTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_nova_compra);

        localEditText = findViewById(R.id.local);
        segmentoEditText = findViewById(R.id.segmento);
        dateTextView = findViewById(R.id.data);
        setDate(dateTextView);


    }

    public void setDate (TextView view){

        Date today = Calendar.getInstance().getTime();//getting date
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");//formating according to my need
        String date = formatter.format(today);
        view.setText(date);
    }

    private void insereMercado(){
        String localString = localEditText.getText().toString().trim();
        String segmentoString = segmentoEditText.getText().toString().trim();
        String dateString = dateTextView.getText().toString().trim();

        banco bancoMercado = new banco(this);

        SQLiteDatabase db = bancoMercado.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(compraEntry.COMLUMN_LOCAL, localString);
        values.put(compraEntry.COLUMN_SEGMENTO, segmentoString);
        values.put(compraEntry.DATA, dateString);

        long newRowId = db.insert(compraEntry.TABLE_NAME, null, values);

        // Show a toast message depending on whether or not the insertion was successful
        if (newRowId == -1) {
            // If the row ID is -1, then there was an error with insertion.
            Toast.makeText(this, "Error with saving pet", Toast.LENGTH_SHORT).show();
        } else {
            // Otherwise, the insertion was successful and we can display a toast with the row ID.
            Toast.makeText(this, "Pet saved with row id: " + newRowId, Toast.LENGTH_SHORT).show();
        }

    }

        public void goCancelaCompra (View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


        public void goAdiciona (View view){
            insereMercado();
            Intent intent = new Intent(this, listaCompras.class);
            startActivity(intent);
        }
    }


