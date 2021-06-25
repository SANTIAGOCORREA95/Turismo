package com.example.turismo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ImageView fotoActividad;
    TextView nombre;
    TextView descripcion;
    Actividad_Turistica actividad;
    Map<String, Object> actividadTuristica = new HashMap<>();//

    FirebaseFirestore baseDatos = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fotoActividad=findViewById(R.id.activity);
        nombre=findViewById(R.id.name);
        descripcion=findViewById(R.id.description);

        actividad=(Actividad_Turistica) getIntent().getSerializableExtra("datosActividades");

        nombre.setText(actividad.getNombre());
        descripcion.setText(actividad.getDescripcion());

        Picasso.with(MainActivity.this)
                .load(actividad.getActividad())
                .into(fotoActividad);

    }

}