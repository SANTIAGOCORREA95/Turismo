package com.example.turismo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    ArrayList<Actividad_Turistica> listadeActividades = new ArrayList<>();
    RecyclerView listado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        listado=findViewById(R.id.listado);
        listado.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        crearLista();
        Adaptador adaptador = new Adaptador(listadeActividades);
        listado.setAdapter(adaptador);
    }

    private void crearLista(){

        listadeActividades.add(new Actividad_Turistica("Desierto de Tatacoa","La segunda mayor zona arida del pais",R.drawable.desierto));
        listadeActividades.add(new Actividad_Turistica("Observatorio Astronomico","Observación a través de telescopios de alta tecnología",R.drawable.observatorio));
        listadeActividades.add(new Actividad_Turistica("Casa del Totumo","Muestra bastante creativa de usos del totumo en diferentes instrumentos caseros, artesanías y mobiliario del hogar.",R.drawable.totumo));
        listadeActividades.add(new Actividad_Turistica("Sal si Puedes","Comida deliciosa y variada",R.drawable.sal));

    }


}