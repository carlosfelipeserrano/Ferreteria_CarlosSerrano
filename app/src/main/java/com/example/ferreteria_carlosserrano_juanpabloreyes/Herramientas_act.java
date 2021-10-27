package com.example.ferreteria_carlosserrano_juanpabloreyes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Herramientas_act extends AppCompatActivity {
    private Spinner herr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_herramientas);

        herr = findViewById(R.id.spnher);
        Bundle bun = getIntent().getExtras();
        String[] listado = bun.getStringArray("herramienta");
        ArrayAdapter adaptFerreteria = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listado);
        herr.setAdapter(adaptFerreteria);
    }

}