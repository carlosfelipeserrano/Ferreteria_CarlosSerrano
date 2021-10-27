package com.example.ferreteria_carlosserrano_juanpabloreyes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import Objetos.Ferreteria;

public class Material_act extends AppCompatActivity {
    private Spinner productos;
    private TextView result;
    private RatingBar cali;
    Ferreteria fe = new Ferreteria();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);
        cali = findViewById(R.id.rb);
        result = findViewById(R.id.result);
        productos = findViewById(R.id.spnprod);
        Bundle bun = getIntent().getExtras();
        String[] listado = bun.getStringArray("material");
        ArrayAdapter adaptFerreteria = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listado);
        productos.setAdapter(adaptFerreteria);

    }
    public void calcular(View view)
    {
        String opcion = productos.getSelectedItem().toString();
        int resultado = 0;
        for(int i = 0;  i <= opcion.length(); i++)

        {
            if(opcion.equals(fe.getMaterial()[i]))
            {
                //resultado = fe.getPreciosma()[i];
                resultado = fe.adicional(fe.getPreciosma()[i], 350);

                cali.setRating(i);


                break;
            }



        }
        result.setText("La opción: " + opcion + " el precio es: " + resultado);
    }
}





