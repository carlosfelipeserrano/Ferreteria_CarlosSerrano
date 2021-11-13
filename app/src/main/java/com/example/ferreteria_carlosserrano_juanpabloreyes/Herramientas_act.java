package com.example.ferreteria_carlosserrano_juanpabloreyes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import Objetos.Ferreteria;

public class Herramientas_act extends AppCompatActivity {
    private Spinner herr;
    private TextView result1;
    Ferreteria fer = new Ferreteria();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_herramientas);
        result1 = findViewById(R.id.result1);

        herr = findViewById(R.id.spnher);
        Bundle bun = getIntent().getExtras();
        String[] listado = bun.getStringArray("herramienta");
        ArrayAdapter adaptFerreteria = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listado);
        herr.setAdapter(adaptFerreteria);
    }

    public void Resultado(View view)
    {
        String opcion = herr.getSelectedItem().toString();
        int resultado = 0;
        for(int i = 0;  i <= opcion.length(); i++)

        {
            if(opcion.equals(fer.getHerramienta()[i]))
            {

                resultado = fer.adicional(fer.getPreciosher()[i], 0);
                result1.setText("La opción: " + opcion + " su precio esta desde: " +"$"+ resultado);



                break;
            }



        }

    }
    public void agregarhe (View view){
        Intent i = new Intent(this,Crudher_act.class);
        startActivity(i);
    }

}