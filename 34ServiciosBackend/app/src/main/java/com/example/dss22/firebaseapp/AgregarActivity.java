package com.example.dss22.firebaseapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AgregarActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Alumno> list;
    Adapter adapter;
    Button btnAgregar;
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registros);

        btnAgregar=findViewById(R.id.btnAgregar);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference mRef= database.getReference(FirebaseReferencias.BASE_REFERENCE);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    LayoutInflater inflater = getLayoutInflater();
                    View mView1 = inflater.inflate(R.layout.agregar,null);

                    final EditText input_nc = (EditText) mView1.findViewById(R.id.txtNombre);
                    final EditText input_lastname = (EditText) mView1.findViewById(R.id.txtNC);

                    final Button btnSave = (Button) mView1.findViewById(R.id.btnAgregar);

                    AlertDialog.Builder builder = new AlertDialog.Builder(AgregarActivity.this);
                    builder.setView(mView1).setTitle("Agregar Alumno")
                            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                    dialog.dismiss();
                                }
                            });

                    btnSave.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            Alumno alumno = new Alumno(input_nc.getText().toString(),input_lastname.getText().toString());
                            mRef.child(FirebaseReferencias.ALUMNO_REFERENCE).push().setValue(alumno);
                            Toast.makeText(AgregarActivity.this,"Agregado correctamente",Toast.LENGTH_SHORT).show();

                            dialog.dismiss();

                        }
                    });

                    dialog = builder.create();
                    dialog.show();
            }
        });

        recyclerView=findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();


        adapter = new Adapter(list);
        recyclerView.setAdapter(adapter);


        mRef.child(FirebaseReferencias.ALUMNO_REFERENCE).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                try {
                    String nombre = dataSnapshot.child("nombre").getValue().toString();
                    String ncontrol = dataSnapshot.child("nocontrol").getValue().toString();
                    Alumno alumnos = new Alumno(nombre, ncontrol);
                    list.add(alumnos);
                    adapter.notifyDataSetChanged();

                }catch (NullPointerException e){}
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
