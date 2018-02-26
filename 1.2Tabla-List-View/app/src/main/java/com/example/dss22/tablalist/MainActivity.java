package com.example.dss22.tablalist;

//importados
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.widget.SeekBar;
        import android.widget.TextView;
        import android.widget.ListView;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.Toast;



public class MainActivity extends AppCompatActivity {


    SeekBar seekbar;
    TextView textview;
    ListView listView;

    String lenguajeProgramacion[]={"","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","",""};
    int dd=0;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//instanciamos

        seekbar=(SeekBar)findViewById(R.id.seekBar);
        textview=(TextView)findViewById(R.id.textView);
        listView = (ListView) findViewById(R.id.listView);

        setseekbar();



    }


public void llenar(int n){
        for(int i=1;i<=30;i++){
            lenguajeProgramacion[i]="x "+i+" = "+n*i;
        }

}

public void lista() {

    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
            android.R.layout.simple_expandable_list_item_1, lenguajeProgramacion);

    listView.setAdapter(adapter);
}
    public void setseekbar(){

        textview.setText(" " + seekbar.getProgress() );
        llenar(dd);
        lista();

        seekbar.setMax(10);
        seekbar.setOnSeekBarChangeListener(new

                                                   SeekBar.OnSeekBarChangeListener() {
                                                       @Override

                                                       public void onProgressChanged

                                                               (SeekBar seekBar,int i,boolean b)

                                                       {
                                                           textview.setText("" + i );
                                                           dd=i;
                                                           llenar(dd);
                                                           lista();
                                                       }
                                                       @Override

                                                       public void onStartTrackingTouch(SeekBar seekBar)

                                                       {}
                                                       @Override

                                                       public void onStopTrackingTouch(SeekBar seekBar)

                                                       {}
                                                   });}}