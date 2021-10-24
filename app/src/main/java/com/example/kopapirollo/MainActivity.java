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
    private ImageView btnKo;
    private ImageView btnPapir;
    private ImageView btnOllo;
    private ImageView tippKep, tippGepKep;
    private ImageView[] felhasznaloEletek, gepEletek;
    private ImageView gepElet1, gepElet2, gepElet3;
    private ImageView felhasznaloElet1, felhasznaloElet2, felhasznaloElet3;
    private TextView eredmenyunk;
    private Random random;
    private Toast toast;
    private int felhasznaloTippje, gepTippje, felhasznaloNyereseg, gepNyereseg, dontetlenKor;
    private int felhasznaloElet, gepElet;
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
                    eredmenyunk.setText("Döntetlenek száma: " + gepNyereseg);
                    Toast.makeText(getApplicationContext(), "Döntetlen", Toast.LENGTH_SHORT).show();
                }
                else if (gepTippje == 1) {
                    tippGepKep.setImageResource(R.drawable.paper);
                    gepNyereseg++;
                    eletVesztesFelhasznalo();
                    /*eredmenyunk.setText("Eredmény: Ember :" + felhasznaloNyereseg + " Computer: " + gepNyereseg);*/
                    Toast.makeText(getApplicationContext(), "Gép nyert", Toast.LENGTH_SHORT).show();
                }
                else {
                    tippGepKep.setImageResource(R.drawable.scissors);
                    felhasznaloNyereseg++;
                    eletVesztesGep();
                    /*eredmenyunk.setText("Eredmény: Ember : " + felhasznaloNyereseg + " Computer: " +
                    gepNyereseg);*/
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
                    eletVesztesGep();
                    /*eredmenyunk.setText("Eredmény: Ember: " +  felhasznaloNyereseg
                            +" Computer: " + gepNyereseg);*/
                    Toast.makeText(getApplicationContext(), "Felhasználó nyert", Toast.LENGTH_SHORT).show();
                }
                else if (gepTippje == 1) {
                    tippGepKep.setImageResource(R.drawable.paper);
                    dontetlenKor++;
                    eredmenyunk.setText("Döntetlenek száma: " + dontetlenKor);
                    Toast.makeText(getApplicationContext(), "Döntetlen", Toast.LENGTH_SHORT).show();
                }
                else {
                    tippGepKep.setImageResource(R.drawable.scissors);
                    gepNyereseg++;
                    eletVesztesFelhasznalo();
                    /*eredmenyunk.setText("Eredmény: Ember : " + felhasznaloNyereseg + " Computer: " +
                            gepNyereseg);*/
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
                    eletVesztesFelhasznalo();
                    /*eredmenyunk.setText("Eredmény: Ember: " + felhasznaloNyereseg
                    + " Computer: " + gepNyereseg);*/
                    Toast.makeText(getApplicationContext(), "Gép nyert", Toast.LENGTH_SHORT).show();
                }
                else if (gepTippje == 1) {
                    tippGepKep.setImageResource(R.drawable.paper);
                    felhasznaloNyereseg++;
                    eletVesztesGep();
                    /*eredmenyunk.setText("Eredmény: Ember: "
                            + felhasznaloNyereseg + " Computer: " + gepNyereseg);*/
                    Toast.makeText(getApplicationContext(), "Felhasználó nyert", Toast.LENGTH_SHORT).show();
                }
                else {
                    tippGepKep.setImageResource(R.drawable.scissors);
                    dontetlenKor++;
                    eredmenyunk.setText("Döntetlenek száma: " + dontetlenKor);
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
        gepElet1 = findViewById(R.id.gepSziv1);
        gepElet2 = findViewById(R.id.gepSziv2);
        gepElet3 = findViewById(R.id.gepSziv3);
        felhasznaloElet1 = findViewById(R.id.felhasznaloSziv1);
        felhasznaloElet2 = findViewById(R.id.felhasznaloSziv2);
        felhasznaloElet3 = findViewById(R.id.felhasznaloSziv3);
        felhasznaloEletek = new ImageView[]{felhasznaloElet1, felhasznaloElet2, felhasznaloElet3};
        gepEletek = new ImageView[]{gepElet1, gepElet2, gepElet3};
        gepElet = 3;
        felhasznaloElet = 3;
    }

    private void jatekVege() {
        if (felhasznaloNyereseg > gepNyereseg && gepElet == 0) {
            alertBuild.setTitle("Győzelem").create().show();
        }
        else {
            alertBuild.setTitle("Vereség").create().show();
        }
    }

    private void eletVesztesFelhasznalo() {
        if (felhasznaloElet > 0) {
            felhasznaloElet--;

        }
        felhasznaloEletek[felhasznaloElet].setImageResource((R.drawable.heart1));
    }

    private void eletVesztesGep() {
        if (gepElet > 0) {
            gepElet--;

        }
        gepEletek[gepElet].setImageResource((R.drawable.heart1));
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
                eredmenyunk.setText("Döntetlenek száma: 0");
                tippKep.setImageResource(R.drawable.rock);
                tippGepKep.setImageResource(R.drawable.rock);
                felhasznaloNyereseg = 0;
                gepNyereseg = 0;
                dontetlenKor = 0;
                gepElet = 3;
                felhasznaloElet = 3;
                felhasznaloElet1.setImageResource(R.drawable.heart2);
                felhasznaloElet2.setImageResource(R.drawable.heart2);
                felhasznaloElet3.setImageResource(R.drawable.heart2);
                gepElet1.setImageResource(R.drawable.heart2);
                gepElet2.setImageResource(R.drawable.heart2);
                gepElet3.setImageResource(R.drawable.heart2);
                closeContextMenu();

            }
        });


        alertBuild.setCancelable(false);
    }
}
