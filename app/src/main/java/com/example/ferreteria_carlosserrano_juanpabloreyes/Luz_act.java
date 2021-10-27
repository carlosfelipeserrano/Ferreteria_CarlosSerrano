package com.example.ferreteria_carlosserrano_juanpabloreyes;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class Luz_act extends AppCompatActivity {
    private VideoView Video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luz);

        Video = (VideoView) findViewById(R.id.vd4);
        Video.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.luz));
        MediaController mediaController = new MediaController(this);
        Video.setMediaController(mediaController);
        Video.start();

    }
}