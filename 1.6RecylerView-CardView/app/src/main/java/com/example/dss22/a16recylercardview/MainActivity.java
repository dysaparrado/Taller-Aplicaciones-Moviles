package com.example.dss22.a16recylercardview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ProductAdapter adapter;
    CardView cardView;

    List<DataProvider> productList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productList = new ArrayList<>();

        recyclerView = findViewById(R.id.recycler_view);
        cardView=findViewById(R.id.card_id);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Aquí va la adición de elementos a la lista
        productList.add(
                new DataProvider("Folklorica", "Sones de la Huasteca", R.drawable.imagen1, Color.rgb(42, 87, 107))
        );
        productList.add(
                new DataProvider("Rock Alternativo", "Urbano Argentino", R.drawable.imagen2, Color.rgb(0, 119, 134))
        );
        productList.add(
                new DataProvider("Acústicos", "Conciertos de Trova",R.drawable.imagen3, Color.rgb(144, 0, 104))
        );
        productList.add(
                new DataProvider("Otros", "Otro",R.drawable.imagen4, Color.rgb(182, 0, 82))
        );
        productList.add(
                new DataProvider("Los Demas", "Otros",R.drawable.imagen5, Color.LTGRAY)
        );


        adapter = new ProductAdapter(this,productList);
        recyclerView.setAdapter(adapter);





    }
}
