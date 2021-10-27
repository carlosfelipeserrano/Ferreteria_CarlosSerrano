package com.example.ferreteria_carlosserrano_juanpabloreyes;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class Mesa_act extends AppCompatActivity {
private VideoView Videos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mesa);
        Videos = (VideoView) findViewById(R.id.vdo);
        Videos.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.mesa));
        MediaController mediaController = new MediaController(this);
        Videos.setMediaController(mediaController);
        Videos.start();

    }
}