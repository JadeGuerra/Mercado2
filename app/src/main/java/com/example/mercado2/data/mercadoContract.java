package com.example.mercado2.data;

import android.provider.BaseColumns;

public final class mercadoContract {

    private mercadoContract(){}

    public static final class compraEntry implements BaseColumns{

        public final static String TABLE_NAME = "compraTable";
        public final static String _ID = BaseColumns._ID;
        public final static String COMLUMN_LOCAL = "local";
        public final static String COLUMN_SEGMENTO = "segmento";
        public final static String DATA = "data";
        public final static String COLUMN_TOTAL = "total";
    }

    public static final class itemEntry implements BaseColumns{
        public final static String TABLE_NAME = "itensTable";
        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_MERCADO = "mercadoId";
        public final static String COLUMN_ITEM = "item";
        public final static String COLUMN_QUANTIDADE = "quantidade";
        public final static String COLUMN_VALOR_UNITARIO = "valorUnitario";
        public final static String COLUMN_VALOR_TOTAL = "valorTotal";

    }

}
