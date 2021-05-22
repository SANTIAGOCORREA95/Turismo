package com.example.turismo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView fotoActividad;
    TextView nombre;
    TextView descripcion;
    Actividad_Turistica actividad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fotoActividad=findViewById(R.id.activity);
        nombre=findViewById(R.id.name);
        descripcion=findViewById(R.id.description);

        actividad=(Actividad_Turistica) getIntent().getSerializableExtra("datosActividades");

        fotoActividad.setImageResource(actividad.getActividad());
        nombre.setText(actividad.getNombre());
        descripcion.setText(actividad.getDescripcion());
    }
}