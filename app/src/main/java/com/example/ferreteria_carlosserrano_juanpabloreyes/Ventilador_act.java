package com.example.ferreteria_carlosserrano_juanpabloreyes;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class Ventilador_act extends AppCompatActivity {
    private VideoView video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventilador);
        video = findViewById(R.id.vd2);

        video.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.venti));
        MediaController mediaController = new MediaController(this);
        video.setMediaController(mediaController);
        video.start();


    }
}