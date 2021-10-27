package com.example.ferreteria_carlosserrano_juanpabloreyes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import Objetos.Ferreteria;

public class Vmesa_act extends AppCompatActivity {
    private VideoView video;
    private Ferreteria fe = new Ferreteria();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vmesa);
        video = (VideoView) findViewById(R.id.vdmesa);

        video.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.mesa));
        MediaController mediaController = new MediaController(this);
        video.setMediaController(mediaController);
        video.start();

    }
    public void Exit(View view){
        Intent i = new Intent(this,Home_act.class);
        startActivity(i);
    }
    public void Volver(View view){
        Intent i = new Intent(this,Manual_act.class);
        Bundle bun  = new Bundle();
        bun.putStringArray("manual",fe.getManual());
        i.putExtras(bun);
        startActivity(i);

    }
}