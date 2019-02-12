package com.riyan.recyclerview;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    AlertDialog.Builder alertDialog;
    LayoutInflater inflater;

    EditText editNama;
    RadioGroup rGroup;
    RadioButton rbIk, rbSi, rbTi;

    ArrayList<Siswa> siswaArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        siswaArrayList = new ArrayList<>();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog = new AlertDialog.Builder(MainActivity.this);

                inflater = getLayoutInflater();
                view = inflater.inflate(R.layout.input_layout, null);

                final View diagView = view;

                alertDialog.setView(diagView);
                alertDialog.setCancelable(true);
                alertDialog.setIcon(R.mipmap.formulir);
                alertDialog.setTitle("Biodata");

                //definisi objek
                editNama = (EditText) view.findViewById(R.id.edNama);

                //berikan id pada radio group dahulu pada MainActivity.xml
                rGroup = (RadioGroup) view.findViewById(R.id.r_Group);


                rbIk = (RadioButton) view.findViewById(R.id.rb_ik);
                rbTi = (RadioButton) view.findViewById(R.id.rb_ti);
                rbSi = (RadioButton) view.findViewById(R.id.rb_si);

                alertDialog.setPositiveButton("SIMPAN", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Simpan kedalam pojo
                        siswaArrayList.add((
                                new Siswa(editNama.getText().toString(),
                                        rbIk.isChecked(),
                                        rbTi.isChecked(),
                                        rbSi.isChecked()
                                        )
                        ));

                        Toast.makeText(getApplicationContext(),
                                "Data tersimpan",
                                Toast.LENGTH_SHORT).show();
                    }
                });

                alertDialog.setNegativeButton("BATAL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                alertDialog.show();

                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                  //      .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
