package com.example.ferreteria_carlosserrano_juanpabloreyes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.VideoView;

import Objetos.Ferreteria;

public class Manual_act extends AppCompatActivity {
    private Spinner manu;
    private TextView txt, txtma;
    private VideoView v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual);
        manu = findViewById(R.id.spnmanu);
        txt = findViewById(R.id.textomanu);
        txtma = findViewById(R.id.txtma);
        v = findViewById(R.id.vw);



        Bundle bun = getIntent().getExtras();
        String[] listado = bun.getStringArray("manual");


        ArrayAdapter adaptFerreteria = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listado);
        manu.setAdapter(adaptFerreteria);
    }

    public void Necesito(View view) {

        Ferreteria fe = new Ferreteria();


        if (manu.getSelectedItem().toString().equals("Pintar mesa")) {
            txt.setText("Herramientas: " + fe.getHerramienta()[1] + ", " + fe.getHerramienta()[9]);
            txtma.setText(" Material: " + fe.getMaterial()[1] + ", " + fe.getMaterial()[2] + ", " + fe.getMaterial()[3] + ", " + fe.getMaterial()[6] + ", " + fe.getMaterial()[13]);

        }
        if (manu.getSelectedItem().toString().equals("Instalar ventilador de techo")) {
            txt.setText("Herramientas: " + fe.getHerramienta()[4] + ", " + fe.getMaterial()[7]);
            txtma.setText(" Material: " + fe.getMaterial()[12] + ", " + fe.getMaterial()[14] + ", " + fe.getMaterial()[15] + ", " + fe.getMaterial()[22]);
        }
        if (manu.getSelectedItem().toString().equals("Instalación de luz")) {
            txt.setText("Herramientas: " + fe.getHerramienta()[6]);
            txtma.setText(" Material: " + fe.getMaterial()[12] + ", " + fe.getMaterial()[14] + ", " + fe.getMaterial()[15] + ", " + fe.getMaterial()[19] + " y " + fe.getMaterial()[22]);
        }
        if (manu.getSelectedItem().toString().equals("Arreglar regadera")) {
            txt.setText("Herramientas: " + fe.getHerramienta()[0] + ", " + fe.getMaterial()[6] + ", " + fe.getHerramienta()[14]);
            txtma.setText(" Material: No se necesitara ningun material por el momento");

        }
        //Preguntar
        if (manu.getSelectedItem().toString().equals("Armar closet")) {
            txt.setText("Herramientas: " + fe.getHerramienta()[8] + ", " + fe.getHerramienta()[4] + ", " + fe.getHerramienta()[2]);
            txtma.setText(" Material: " + fe.getMaterial()[15] + fe.getMaterial()[24] + ", " + fe.getMaterial()[25] + ", " + fe.getMaterial()[26] + ", " + fe.getMaterial()[27] + ", " + fe.getMaterial()[28] + ", " + fe.getMaterial()[29] + ", " + fe.getMaterial()[30] + ", " + fe.getMaterial()[31] + ", " + fe.getMaterial()[32] + " y " + fe.getMaterial()[33]);
        }

        if (manu.getSelectedItem().toString().equals("Armar repisa")) {
            txt.setText("Herramientas: " + fe.getHerramienta()[0] + ", " + fe.getHerramienta()[6] + ", " + fe.getHerramienta()[14]);
            txtma.setText(" Material: " + fe.getMaterial()[6] + ", " + fe.getMaterial()[25] + ", " + fe.getMaterial()[26] + ", " + fe.getMaterial()[15] + ", " + fe.getMaterial()[27] + ", " + fe.getMaterial()[28] + ", " + fe.getMaterial()[29] + ", " + fe.getMaterial()[30] + ", " + fe.getMaterial()[31] + ", " + fe.getMaterial()[32] + " y " + fe.getMaterial()[33]);

        }

    }

    public void Catalogo(View view) {

        if (manu.getSelectedItem().toString().equals("Pintar mesa")){
            Intent i = new Intent(this, Mesa_act.class);
            startActivity(i);
        }

            if (manu.getSelectedItem().toString().equals("Instalar ventilador de techo")){
            Intent i = new Intent(this, Ventilador_act.class);
            startActivity(i);

        }
        if (manu.getSelectedItem().toString().equals("Instalación de luz")){
            Intent i = new Intent(this, Luz_act.class);
            startActivity(i);

        }

    }

}




