package com.example.mercado2.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;




public class banco extends SQLiteOpenHelper{

    public static final String LOG_TAG = banco.class.getSimpleName();
    private static final String DATABASE_NAME = "banco.db";
    private static final int DATABASE_VERSION = 1;

    public banco(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_COMPRA_TABLE = "CREATE TABLE " +
                mercadoContract.compraEntry.TABLE_NAME + "("
                + mercadoContract.compraEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + mercadoContract.compraEntry.COMLUMN_LOCAL + " TEXT NOT NULL,"
                + mercadoContract.compraEntry.COLUMN_SEGMENTO + " TEXT, "
                + mercadoContract.compraEntry.DATA + " TEXT NOT NULL, "
                + mercadoContract.compraEntry.COLUMN_TOTAL + " INTEGER DEFAULT 0 " + ")";

        db.execSQL(CREATE_COMPRA_TABLE);

        String CREATE_ITENS_TABLE = "CREATE TABLE " +
                mercadoContract.itemEntry.TABLE_NAME + "("
                + mercadoContract.itemEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + mercadoContract.itemEntry.COLUMN_ITEM + " TEXT NOT NULL, "
                + mercadoContract.itemEntry.COLUMN_QUANTIDADE + " INTEGER, "
                + mercadoContract.itemEntry.COLUMN_VALOR_TOTAL + " INTEGER, "
                + mercadoContract.itemEntry.COLUMN_MERCADO + " INTEGER NOT NULL, "
                + " FOREIGN KEY (" + mercadoContract.itemEntry.COLUMN_MERCADO + " ) REFERENCES "
                + mercadoContract.compraEntry.TABLE_NAME +"("
                + mercadoContract.itemEntry.COLUMN_MERCADO + ") "+")";

        db.execSQL(CREATE_ITENS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
