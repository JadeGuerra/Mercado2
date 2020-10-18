package com.example.mercado2.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class banco extends SQLiteOpenHelper{

    public banco(@Nullable Context context,
                 @Nullable String name,
                 @Nullable SQLiteDatabase.CursorFactory factory,
                 int version) {

        super(context, name, factory, version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_COMPRA_TABLE = "CREATE TABLE " +
                mercadoContract.compraEntry.TABLE_NAME + "("
                + mercadoContract.compraEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT "
                + mercadoContract.compraEntry.COMLUMN_LOCAL + " TEXT NOT NULL"
                + mercadoContract.compraEntry.COLUMN_SEGMENTO + " TEXT "
                + mercadoContract.compraEntry.DATA + " TEXT NOT NULL "
                + mercadoContract.compraEntry.COLUMN_TOTAL + " INTEGER DEFAULT 0 " + ")";

        db.execSQL(CREATE_COMPRA_TABLE);

        db.execSQL("CREATE TABLE ITENS_TABLE  " +
                   "(ID INTEGER PRIMARY KEY AUTOINCREMENT, "+
                   " LOCAL TEXT, "+
                   "SEGMENTO TEXT,"+
                   " DATA TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
