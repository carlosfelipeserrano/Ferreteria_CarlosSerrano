package com.example.ferreteria_carlosserrano_juanpabloreyes;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class Ceramica_act extends AppCompatActivity {
private VideoView ce;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ceramica);
        ce = findViewById(R.id.ce);

        ce.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.cera));
        MediaController mediaController = new MediaController(this);
        ce.setMediaController(mediaController);
        ce.start();
    }
}