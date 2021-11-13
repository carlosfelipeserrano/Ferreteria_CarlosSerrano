package com.example.ferreteria_carlosserrano_juanpabloreyes.database;
import android.content.Context;
import  android.database.sqlite.SQLiteDatabase;
import  android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {
    //constructor, importante para hacer la instancia
    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //Donde se va crear el modelo.
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE materiales(codigo int primary key , nombre text, precio int)");

    }
    //Me permite realizar actualizaciones en mi basedate.
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {


    }
}