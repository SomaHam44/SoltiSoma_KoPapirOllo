package com.example.kopapirollo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button btnKo;
    private Button btnPapir;
    private Button btnOllo;
    private ImageView tippKep, tippGepKep;
    private TextView eredmenyunk;
    private Random random;
    private Toast toast;
    private int felhasznaloTippje, gepTippje,felhasznaloNyereseg, gepNyereseg, dontetlenKor;
    private AlertDialog.Builder alertBuild;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        btnKo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tippKep.setImageResource(R.drawable.rock);
                gepTippje = random.nextInt(3);
                if (gepTippje == 0) {
                    tippGepKep.setImageResource(R.drawable.rock);
                    dontetlenKor++;
                    eredmenyunk.setText("Eredmény: Ember:  " + felhasznaloNyereseg
                            + " Computer: " + gepNyereseg);
                    Toast.makeText(getApplicationContext(), "Döntetlen", Toast.LENGTH_SHORT).show();
                }
                else if (gepTippje == 1) {
                    tippGepKep.setImageResource(R.drawable.paper);
                    gepNyereseg++;
                    eredmenyunk.setText("Eredmény: Ember :" + felhasznaloNyereseg + " Computer: " + gepNyereseg);
                    Toast.makeText(getApplicationContext(), "Gép nyert", Toast.LENGTH_SHORT).show();
                }
                else {
                    tippGepKep.setImageResource(R.drawable.scissors);
                    felhasznaloNyereseg++;
                    eredmenyunk.setText("Eredmény: Ember : " + felhasznaloNyereseg + " Computer: " +
                    gepNyereseg);
                    Toast.makeText(getApplicationContext(), "Felhasználó nyert", Toast.LENGTH_SHORT).show();
                }

                if (gepNyereseg == 3 || felhasznaloNyereseg == 3) {
                    jatekVege();
                }


            }
        });

        btnPapir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tippKep.setImageResource(R.drawable.paper);
                gepTippje = random.nextInt(3);
                if (gepTippje == 0) {
                    tippGepKep.setImageResource(R.drawable.rock);
                    felhasznaloNyereseg++;
                    eredmenyunk.setText("Eredmény: Ember: " +  felhasznaloNyereseg
                            +" Computer: " + gepNyereseg);
                    Toast.makeText(getApplicationContext(), "Felhasználó nyert", Toast.LENGTH_SHORT).show();
                }
                else if (gepTippje == 1) {
                    tippGepKep.setImageResource(R.drawable.paper);
                    dontetlenKor++;
                    eredmenyunk.setText("Eredmény: Ember: " +  felhasznaloNyereseg +
                            " Computer: " + gepNyereseg);
                    Toast.makeText(getApplicationContext(), "Döntetlen", Toast.LENGTH_SHORT).show();
                }
                else {
                    tippGepKep.setImageResource(R.drawable.scissors);
                    gepNyereseg++;
                    eredmenyunk.setText("Eredmény: Ember : " + felhasznaloNyereseg + " Computer: " +
                            gepNyereseg);
                    Toast.makeText(getApplicationContext(), "Gép nyert", Toast.LENGTH_SHORT).show();
                }

                if (gepNyereseg == 3 || felhasznaloNyereseg == 3) {
                    jatekVege();

                }

            }
        });

        btnOllo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tippKep.setImageResource(R.drawable.scissors);
                gepTippje = random.nextInt(3);
                if (gepTippje == 0) {
                    tippGepKep.setImageResource(R.drawable.rock);
                    gepNyereseg++;
                    eredmenyunk.setText("Eredmény: Ember: " + felhasznaloNyereseg
                    + " Computer: " + gepNyereseg);
                    Toast.makeText(getApplicationContext(), "Gép nyert", Toast.LENGTH_SHORT).show();
                }
                else if (gepTippje == 1) {
                    tippGepKep.setImageResource(R.drawable.paper);
                    felhasznaloNyereseg++;
                    eredmenyunk.setText("Eredmény: Ember: "
                            + felhasznaloNyereseg + " Computer: " + gepNyereseg);
                    Toast.makeText(getApplicationContext(), "Felhasználó nyert", Toast.LENGTH_SHORT).show();
                }
                else {
                    tippGepKep.setImageResource(R.drawable.scissors);
                    dontetlenKor++;
                    eredmenyunk.setText("Eredmény: Ember : " + felhasznaloNyereseg + " Computer: " +
                            gepNyereseg);
                    Toast.makeText(getApplicationContext(), "Döntetlen", Toast.LENGTH_SHORT).show();
                }

                if (gepNyereseg == 3 || felhasznaloNyereseg == 3) {
                    jatekVege();

                }

            }
        });
    }

    private void init() {
        btnKo = findViewById(R.id.btn_ko);
        btnPapir = findViewById(R.id.btn_papir);
        btnOllo = findViewById(R.id.btn_ollo);
        eredmenyunk = findViewById(R.id.text_eredmeny);
        random = new Random();
        tippKep = findViewById(R.id.felhasznalo_tippKep);
        tippGepKep = findViewById(R.id.gep_tippKep);
        toast = new Toast(getApplicationContext());
        alertBuild = new AlertDialog.Builder(this);
        alertDialogLetrehoz();
    }

    private void jatekVege() {
        if (felhasznaloNyereseg > gepNyereseg) {
            alertBuild.setTitle("Győzelem").create().show();
        }
        else {
            alertBuild.setTitle("Vereség").create().show();
        }
    }

    private void alertDialogLetrehoz() {
        alertBuild.setMessage("Szeretne új játékot játszani ?");
        alertBuild.setNegativeButton("Nem", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();

            }
        });

        alertBuild.setPositiveButton("Igen", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                eredmenyunk.setText("Eredmény: Ember : 0 Computer: 0");
                tippKep.setImageResource(R.drawable.rock);
                tippGepKep.setImageResource(R.drawable.rock);
                felhasznaloNyereseg = 0;
                gepNyereseg = 0;
                closeContextMenu();

            }
        });


        alertBuild.setCancelable(false);
    }
}
