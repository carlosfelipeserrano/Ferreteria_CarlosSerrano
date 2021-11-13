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

public class Crudma_act extends AppCompatActivity {
private EditText cod,name,pre;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crudma);
        cod = findViewById(R.id.codi);
        name = findViewById(R.id.name);
        pre = findViewById(R.id.precio);


    }
    public void añadirMaterial (View view) {
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

            Toast.makeText(getBaseContext(), "Has agregado el material", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getBaseContext(), " No has agregado el material", Toast.LENGTH_SHORT).show();

        }
    }


    public void mostrarMaterial (View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "ferreteria", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase(); //Me permite sobreescribir mi database
        String codigo = cod.getText().toString();
       if(!codigo.isEmpty()) {
           Cursor file = db.rawQuery("SELECT nombre, precio FROM materiales WHERE codigo="+codigo, null);

           if (file.moveToFirst()) //Válida si la consulta tiene valores
           {
               //Muestro lo necesito
               name.setText(file.getString(0));
               pre.setText(file.getString(1));


           }else{
               Toast.makeText(getBaseContext(),"no hay codigo material asociado",Toast.LENGTH_SHORT).show();
           }

       }else{
           Toast.makeText(getBaseContext(),"no hay codigo material asociado",Toast.LENGTH_SHORT).show();
       }

    }
    public void eliminarMaterial (View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "ferreteria", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase(); //Me permite sobreescribir mi database

        String codigo = cod.getText().toString();

        if(!codigo.isEmpty()){
            int cant = db.delete("materiales","codigo="+codigo, null);
            db.close();
            Clean();
            if(cant == 1){
                Toast.makeText(getBaseContext(), "Has eliminado el material", Toast.LENGTH_SHORT).show();

            }

        }
        else{
            Toast.makeText(getBaseContext(), "No esta el material agregado", Toast.LENGTH_SHORT).show();
        }

    }
    public void actualizarMaterial (View view){
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
            Toast.makeText(getBaseContext(), "No se han actuali", Toast.LENGTH_SHORT).show();



        }





    }
    //Metodo para poder limpiar las casillas de entrada.
    public void Clean(){
        cod.setText("");
        name.setText("");
        pre.setText("");

    }


}
