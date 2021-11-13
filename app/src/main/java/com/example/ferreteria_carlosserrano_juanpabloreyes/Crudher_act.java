package com.example.ferreteria_carlosserrano_juanpabloreyes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ferreteria_carlosserrano_juanpabloreyes.database.AdminSQLiteOpenHelper;

public class Crudher_act extends AppCompatActivity {
    private EditText cod,name, pre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crudher);
        cod = findViewById(R.id.co);
        name = findViewById(R.id.he);
        pre = findViewById(R.id.pe);
    }

    public void añadirHerramienta (View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "ferreteria", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase(); //Me permite sobreescribir mi database
        String codigo = cod.getText().toString();
        String nombre = name.getText().toString();
        String prec = pre.getText().toString();

        if(!nombre.isEmpty())
        {
            ContentValues cont = new ContentValues();
            cont.put("codigo", codigo);
            cont.put("nombre", nombre);
            cont.put("precio", prec);

            db.insert("materiales",null, cont);
            db.close();
            Clean();

            Toast.makeText(getBaseContext(), "Has agregado la herramienta", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getBaseContext(), " No has agregado la herramienta", Toast.LENGTH_SHORT).show();


        }

    }


    public void mostrarHerramienta (View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "ferreteria", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase(); //Me permite sobreescribir mi database
        String codigo = cod.getText().toString();
        if (!codigo.isEmpty()) {
            Cursor file = db.rawQuery("SELECT nombre, precio FROM materiales WHERE codigo=" + codigo, null);

            if (file.moveToFirst()) //Válida si la consulta tiene valores
            {
                //Muestro lo necesito
                name.setText(file.getString(0));
                pre.setText(file.getString(1));


            } else {
                Toast.makeText(getBaseContext(), "no hay codigo herramienta asociado", Toast.LENGTH_SHORT).show();
            }

        }
    }

    public void eliminarHerramienta (View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "ferreteria", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase(); //Me permite sobreescribir mi database

        String codigo = cod.getText().toString();

        if(!codigo.isEmpty()){
            int cant = db.delete("materiales","codigo="+codigo, null);
            db.close();
            Clean();
            if(cant == 1){
                Toast.makeText(getBaseContext(), "Has eliminado la herramienta", Toast.LENGTH_SHORT).show();

            }

        }
        else{
            Toast.makeText(getBaseContext(), "No esta el herramienta agregado", Toast.LENGTH_SHORT).show();
        }

    }
    public void actualizarHerramienta (View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "ferreteria", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase(); //Me permite sobreescribir mi database
        String codigo = cod.getText().toString();
        String nombre = name.getText().toString();
        String prec = pre.getText().toString();

        if(!codigo.isEmpty() && !nombre.isEmpty() && !prec.isEmpty()){
            ContentValues cont = new ContentValues();
            cont.put("codigo", codigo);
            cont.put("nombre",nombre);
            cont.put("precio",prec);


            db.update("materiales",cont,"codigo="+codigo,null);
            db.close();
            Clean();
            Toast.makeText(getBaseContext(), "Has actualizado los datos correctamente", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getBaseContext(), "No se han actualizados", Toast.LENGTH_SHORT).show();



        }





    }
    //Metodo para poder limpiar las casillas de entrada.
    public void Clean(){
        cod.setText("");
        name.setText("");
        pre.setText("");

    }
}