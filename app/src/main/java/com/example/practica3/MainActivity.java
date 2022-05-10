package com.example.practica3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Contacto> contactos = new ArrayList<>();
        ArrayList<String> nombres = new ArrayList<>();

        contactos.add(new Contacto("Heidy", "9711399552","HeidyA402@gmail.com"));
        contactos.add(new Contacto("Oliver", "9711165432","Oli1008@gmail.com"));


        for (Contacto contacto : contactos){
            nombres.add(contacto.getNombre());
        }

        ListView listaContactos = findViewById(R.id.listaContacto);
        listaContactos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombres));

        listaContactos.setOnItemClickListener((adapterView, view, i, l)->{
            Intent intent = new Intent(this, ContactoDetalle.class);
            intent.putExtra("KEY_EXTRA_CONTACTO", contactos.get(i));
            startActivity(intent);
            //finish();
        });

    }
}