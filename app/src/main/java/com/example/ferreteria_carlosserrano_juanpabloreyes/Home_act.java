package com.example.ferreteria_carlosserrano_juanpabloreyes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.VideoView;

import Objetos.Ferreteria;

public class Home_act extends AppCompatActivity {
    private Ferreteria fer = new Ferreteria();
    private VideoView videoView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        videoView = (VideoView) findViewById(R.id.vw);
        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.a));
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        videoView.start();



    }

    public void Material(View view){
        Intent i = new Intent(this,Material_act.class);
        Bundle bun = new Bundle();
        bun.putStringArray("material",fer.getMaterial());
        i.putExtras(bun);
        startActivity(i);

    }

    public void Herramientas(View view){
        Intent i = new Intent(this,Herramientas_act.class);
        Bundle bun = new Bundle();
        bun.putStringArray("herramienta",fer.getHerramienta());
        i.putExtras(bun);
        startActivity(i);

    }

    public void Manual(View view){
        Intent i = new Intent(this,Manual_act.class);
        Bundle bun = new Bundle();
        bun.putStringArray("manual",fer.getManual());
        i.putExtras(bun);
        startActivity(i);

    }
    public void volver(View view){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
}




