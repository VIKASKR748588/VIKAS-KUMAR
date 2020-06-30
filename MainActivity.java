package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean gameActive = true;
    //Player represent
    // 0 - x
    // 1 - o
    int activePlayer = 0;
    //State meaning:
    //0 - x
    //1 - o
    // 2 - Null
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[] [] winPosition = {{0,1,2}, {3,4,5}, {6,7,8},
                            {0,3,6}, {1,4,7}, {2,5,8},
                            {0,4,8}, {2,4,6}};

    public void tap(View view){
        ImageView img =  (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());
        if(!gameActive){
            gameReset(view);
        }
        if(gameState[tappedImage] == 2 && gameActive){
            gameState[tappedImage] = activePlayer;
            img.setTranslationY((-1000f));
            if (activePlayer == 0) {
                img.setImageResource(R.drawable.xn);
                activePlayer = 1;
                TextView states = findViewById(R.id.states);
                states.setText("O-tap to play");
            }
            else{
                img.setImageResource(R.drawable.on);
                activePlayer = 0;
                TextView states = findViewById(R.id.states);
                states.setText("X-tap to play");
            }
            img.animate().translationYBy(1000f).setDuration(300);

        for(int [] winPosition: winPosition){
            if(gameState[winPosition[0]] == gameState[winPosition[1]] &&
            gameState[winPosition[1]] == gameState[winPosition[2]] &&
                    gameState[winPosition[0]] != 2){
                String winnerStr;
                gameActive = false;
                if(gameState[winPosition[0]] == 0){
                    winnerStr = " Congratulation X has won";
                }
                else{
                    winnerStr = " Congratulation O has won";
                }
                TextView states = findViewById(R.id.states);
                states.setText(winnerStr);
            }

        }

        }
    }
    public void gameReset(View view){
        gameActive = true;
        activePlayer = 0;
        for(int i=0; i<gameState.length;i++){
            gameState[i] = 2;
        }
        ((ImageView) findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView8)).setImageResource(0);

        TextView states = findViewById(R.id.states);
        states.setText("X-tap to play");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}