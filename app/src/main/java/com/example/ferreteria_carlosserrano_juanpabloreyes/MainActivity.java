package com.example.ferreteria_carlosserrano_juanpabloreyes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import Objetos.Administrador;
import Objetos.Ferreteria;

public class MainActivity extends AppCompatActivity {
    private EditText user, pass;
    private TextView msj;
    private Button btn;
    private ProgressBar pb;
    private Administrador adm = new Administrador(); //Intancia del objeto administrador
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user=  (EditText) findViewById(R.id.etuser);
        pass = (EditText) findViewById(R.id.etpass);
        msj =  (TextView) findViewById(R.id.msj);
        btn =  (Button) findViewById(R.id.btn);
        pb = (ProgressBar)findViewById(R.id.pb);
        msj.setVisibility(View.INVISIBLE);

        pb.setVisibility(View.INVISIBLE);


        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                //Correr mi tarea asincrona
                new Task().execute();
            }
        });


    }
    //Mi tarea asincrona
    class Task extends AsyncTask<String, Void, String>{

        //Me permite definir una configuracion inicial
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pb.setVisibility(View.VISIBLE);


        }
        //Me permite ejecutar el proceso en segundo plano o mi tarea pesada
        @Override
        protected String doInBackground(String... strings) {
            try{
                for(int i = 0; i <= 10; i++){
                    Thread.sleep(200);//dormimos un proceso;

                }

            }catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            return null;
        }


        //Es la configuracion final al terminar mi tarea
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            pb.setVisibility(View.INVISIBLE);



            //Variables del Objeto
            String userObj = adm.getUser().toString().trim();
            String passObj = adm.getPass().toString().trim();
            //Variables EditText de la interfaz
            String usuario = user.getText().toString().trim();
            String contrasena = pass.getText().toString().trim();

            switch (usuario) {
                case "Carlos":
                    if (usuario.equals(userObj) && contrasena.equals(passObj)) {
                        //Inicio sesión
                        Intent i = new Intent(getBaseContext(), Home_act.class);
                        i.putExtra("usuario",user.getText().toString());
                        startActivity(i);
                    }
                    break;
                case "":
                    if (usuario.equals("")&& contrasena.equals("")){
                        //Campos vacios
                        msj.setVisibility(View.VISIBLE);
                        msj.setText("Campos vacios, rellenar los campos por favor");
                    }
                    break;
                default:
                    if(!usuario.equals(userObj) && !contrasena.equals(passObj)){
                        //Campos incorrectos
                        msj.setVisibility(View.VISIBLE);
                        msj.setText("El usuario o contraseña que ingresaste es incorrecto.");
                    }
                    break;

            }

        }
    }

    public void Facebook(View view){
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://es-la.facebook.com/"));
        startActivity(i);
    }
    public void Youtube(View view){
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.youtube.com/"));
        startActivity(i);
    }
    public void Twitter(View view){
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://twitter.com/?lang=es"));
        startActivity(i);
    }
    public void info(View view){
        Intent i = new Intent(this,Info_act.class);
        startActivity(i);
    }

    public void Closeapp(View view){
        finish();
    }

}