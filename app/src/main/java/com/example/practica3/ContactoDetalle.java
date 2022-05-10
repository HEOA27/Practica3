package com.example.practica3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;

public class ContactoDetalle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto_detalle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle extras= getIntent().getExtras();
        Contacto contacto =(Contacto)extras.get("KEY_EXTRA_CONTACTO");

        EditText etNombre=findViewById(R.id.etNombre);
        EditText etTelefono=findViewById(R.id.etTelefono);
        EditText etCorreo=findViewById(R.id.etcorreo);

        etNombre.setText(contacto.getNombre());
        etTelefono.setText(contacto.getTelefono());
        etCorreo.setText(contacto.getCorreo());

        etNombre.setOnClickListener(view ->{
            Intent i=new Intent(Intent.ACTION_DIAL);
            String telefono= etTelefono.getText().toString();
            i.setData(Uri.parse("telefono:"+telefono));
            startActivity(i);
        });


    }

    /*@Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            Intent i= new Intent (this, MainActivity.class);
            startActivity(i);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i= new Intent (this, MainActivity.class);
        startActivity(i);
        finish();
    }*/
}