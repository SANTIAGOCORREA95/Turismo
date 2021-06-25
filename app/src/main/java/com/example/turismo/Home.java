package com.example.turismo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Locale;

public class Home extends AppCompatActivity {

    ArrayList<Actividad_Turistica> listadeActividades = new ArrayList<>();
    RecyclerView listado;
    FirebaseFirestore baseDatos = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        listado=findViewById(R.id.listado);
        listado.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        crearLista();
    }

    public void cambiarIdioma(String lenguaje){

        Locale idioma = new Locale(lenguaje);
        Locale.setDefault(idioma);

        Configuration configuraciontelefono = getResources().getConfiguration();
        configuraciontelefono.locale=idioma;
        getBaseContext().getResources().updateConfiguration(configuraciontelefono,getBaseContext().getResources().getDisplayMetrics());
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu,menu);

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){

        int id=item.getItemId();

        switch (id){

            case(R.id.opcion1):

                Intent intent1=new Intent(Home.this,Acercade.class);
                startActivity(intent1);

                break;

            case(R.id.opcion2):

                cambiarIdioma("es");
                Intent intent2=new Intent(Home.this,Home.class);
                startActivity(intent2);

                break;

            case(R.id.opcion3):

                cambiarIdioma("en");
                Intent intent3=new Intent(Home.this,Home.class);
                startActivity(intent3);

                break;
        }

        return super.onOptionsItemSelected(item);

    }

    private void crearLista(){

        baseDatos.collection("actividades")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()){

                                String nombre=document.get("nombre").toString();
                                String descripcion=document.get("descripcion").toString();
                                String actividad=document.get("actividad").toString();

                                listadeActividades.add(new Actividad_Turistica(nombre,descripcion,actividad));
                            }
                            Adaptador adaptador = new Adaptador(listadeActividades);
                            listado.setAdapter(adaptador);

                        } else {

                            Toast.makeText(Home.this, "Error", Toast.LENGTH_SHORT).show();

                        }
                    }
                });

        // listadeActividades.add(new Actividad_Turistica("Desierto","La segunda mayor zona arida del pais",R.drawable.desierto));
        //listadeActividades.add(new Actividad_Turistica("Observatorio Astronomico","Observación a través de telescopios de alta tecnología",R.drawable.observatorio));
       // listadeActividades.add(new Actividad_Turistica("Casa del Totumo","Muestra bastante creativa de usos del totumo en diferentes instrumentos caseros, artesanías y mobiliario del hogar.",R.drawable.totumo));
        //listadeActividades.add(new Actividad_Turistica("Sal si Puedes","Comida deliciosa y variada",R.drawable.sal));

    }


}