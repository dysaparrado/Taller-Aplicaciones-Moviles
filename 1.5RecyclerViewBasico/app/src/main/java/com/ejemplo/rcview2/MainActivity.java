package com.ejemplo.rcview2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    String [] nc = {
            "14400801",
            "14400802",
            "14400803",
            "14400804",
            "14400805",
            "14400806",
            "14400807",
            "I4400808",
            "14400809",
            "14400810",
            "14400811",
            "14400812",
            "14400813",
            "14400814",
            "14400815",
            "14400832",
            "14400817",
            "14400818",
            "14400983",
            "14400820",
            "14400821",
            "14400822",
            "14400823",
            "14400824",
            "14400825",
            "14400826",
            "14400827",
            "14400828",
            "14400829",
            "14400830",
            "14400831",
            "14400832"
    };

    String [] carrera = {
            "Ing. Sistemas Computacionales",
            "Ing. Sistemas Computacionales",
            "Ing. Sistemas Computacionales",
            "Ing. Sistemas Computacionales",
            "Ing. Sistemas Computacionales",
            "Ing. Sistemas Computacionales",
            "Ing. Sistemas Computacionales",
            "Ing. Sistemas Computacionales",
            "Ing. Sistemas Computacionales",
            "Ing. Sistemas Computacionales",
            "Ing. Sistemas Computacionales",
            "Ing. Sistemas Computacionales",
            "Ing. Sistemas Computacionales",
            "Ing. Sistemas Computacionales",
            "Ing. Sistemas Computacionales",
            "Ing. Sistemas Computacionales",
            "Ing. Sistemas Computacionales",
            "Ing. Sistemas Computacionales",
            "Ing. Sistemas Computacionales",
            "Ing. Sistemas Computacionales",
            "Ing. Sistemas Computacionales",
            "Ing. Sistemas Computacionales",
            "Ing. Sistemas Computacionales",
            "Ing. Sistemas Computacionales",
            "Ing. Sistemas Computacionales",
            "Ing. Sistemas Computacionales",
            "Ing. Sistemas Computacionales",
            "Ing. Sistemas Computacionales",
            "Ing. Sistemas Computacionales",
            "Ing. Sistemas Computacionales",
            "Ing. Sistemas Computacionales"
    };


    String [] nombres={"ARANDA PATRON NOMAR JAZIEL",
            "CARDENAS RAMOS FRANCISCO EMANUEL",
            "CASTILLO CORRALES VICTOR EMMANUEL",
            "CERVANTES JIMÉNEZ JOSÉ MIGUEL",
            "CORDERO RIVERA SELVA YAZMIN",
            "CORDERO VILLA OSCAR ALBERTO",
            "ESPINOSA ABANDO DENISSE YANETH",
            "FIGUEROA CUETO JUAN RAMON",
            "GALLEGOS GODINEZ FRANCISCO JAVIER",
            "GIL LLANOS JUAN PEDRO",
            "GONZALEZ ARELLANO ERNESTO",
            "GUTIERREZ ESPARZA BRAYAN JESUS",
            "GUTIÉRREZ ROJAS BRYAN",
            "LOPEZ ALVARADO MISSAEL",
            "MARTINEZ BAÑUELOS ERIKA LIZBETH",
            "MENDEZ SANTANA KEVIN ALEJANDRO",
            "MONROY SALCEDO JOSE DE JESUS",
            "PADILLA SIMÓN BRIAN EFRÉN",
            "PARRA DOMINGUEZ DYLAN SALVADOR",
            "PEREZ ARAIZA FLOR MARIELA",
            "PUGA FLORES CARLOS",
            "REYES GODINEZ CARLA GUADALUPE",
            "REYES GUERRERO GUILLERMO GUADALUPE",
            "RICO ESPARZA HENRY",
            "RIVERA RAMIREZ DAVID",
            "SANCHEZ CARRILLO BETSY DEL CARMEN",
            "SILVA CAMACHO EDUARDO LUIS",
            "TORRES CUETO JESUS MANUEL",
            "VALDEZ LOPEZ HOLLIVER EDUARDO",
            "VALENZUELA MIRAMONTES JOSE PABLO",
            "ZAMORANO ALCALÁ GUILLERMO"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Crear referencias hacia el componente RecycleriView
        recyclerView = findViewById(R.id.recycler_id);

        // Crear un objeto de tipo RecyclerAdapter que recibe un arreglo de cadenas
        adapter = new RecyclerAdapter(nombres,carrera,nc);

        // Crea un objeto de tipo LinearLayoutManager
        layoutManager = new LinearLayoutManager(this);

        // Establecer el LayautManager
        //recyclerView.setLayoutManager(layoutManager);

        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setHasFixedSize(true);

        // Establecer el Adapter
        recyclerView.setAdapter(adapter);

    }
}
