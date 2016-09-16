package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int pontosTimeA = 0;
    int pontosTimeB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Mostra a pontuação do time A
     * @param score int
     */
    public void mostraTimeA(int score){
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Mostra a pontuação do time B
     * @param score int
     */
    public void mostraTimeB(int score){
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * adiciona 3 pontos ao time A
     * @param view View
     */
    public void maisTresPontosA(View view){
        pontosTimeA = pontosTimeA + 3;
        mostraTimeA(pontosTimeA);
    }

    /**
     * adiciona 2 pontos ao time A
     * @param view View
     */
    public void maisDoisPontosA(View view){
        pontosTimeA = pontosTimeA + 2;
        mostraTimeA(pontosTimeA);
    }

    /**
     * adiciona 1 ponto ao time A
     * @param view View
     */
    public void freeThrowA(View view){
        pontosTimeA = pontosTimeA + 1;
        mostraTimeA(pontosTimeA);
    }

    /**
     * adiciona 3 pontos ao time B
     * @param view View
     */
    public void maisTresPontosB(View view){
        pontosTimeB = pontosTimeB + 3;
        mostraTimeB(pontosTimeB);
    }

    /**
     * adiciona 2 pontos ao time B
     * @param view View
     */
    public void maisDoisPontosB(View view){
        pontosTimeB = pontosTimeB + 2;
        mostraTimeB(pontosTimeB);
    }

    /**
     * adiciona 1 ponto ao time B
     * @param view View
     */
    public void freeThrowB(View view){
        pontosTimeB = pontosTimeB + 1;
        mostraTimeB(pontosTimeB);
    }

    /**
     * zera os valores dos pontos do time A  e time B
     * @param view View
     */
    public void reseta(View view){
        pontosTimeA = 0;
        pontosTimeB = 0;
        mostraTimeA(pontosTimeA);
        mostraTimeB(pontosTimeB);
    }


}
