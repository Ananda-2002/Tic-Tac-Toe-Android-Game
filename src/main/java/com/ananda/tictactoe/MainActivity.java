package com.ananda.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int []gameState = {2,2,2,2,2,2,2,2,2};
    int[][] winPosition = {{0,1,2},{3,4,5},{6,7,8},
                            {0,3,6},{1,4,7},{2,5,8},
                            {0,4,8},{2,4,6}};
    int player = 0;
    boolean play = true;
    int gameComplete = 0;
    public void playerTap(View view){
        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());

        TextView status = findViewById(R.id.Status);
        status.setText("X's turn, tap to play");

        if(gameState[tappedImage]==2 && play){
           gameState[tappedImage] =player;
            gameComplete ++;
           if(player==0){
               img.setImageResource(R.drawable.o);
               status.setText("X's turn, tap to play");
               player = 1;
           }
           else{
               img.setImageResource(R.drawable.x);
               status.setText("O's turn, tap to play");
               player = 0;
           }

        }
        
        //winner text
        String winStr = "";
        for (int[] winPos : winPosition) {
            if ( (gameState[winPos[0]] == gameState[winPos[1]]) &&  (gameState[winPos[1]] == gameState[winPos[2]]) && (gameState[winPos[0]] != 2)){
                if(gameState[winPos[0]]==0){
                    winStr = "O has own";
                    play = false;
                }
                else{
                    winStr = "X has own";
                    play = false;
                }
                status.setText(winStr);
            }

        }
        if(gameComplete==9){

            status.setText("Tie, tap to play again");
            play = false;

        }

    }


    public void reset(View view){
        for (int i=0; i<gameState.length; i++) {
            gameState[i] = 2;
        }
        player = 0;
        play = true;
        gameComplete = 0;
        TextView status = findViewById(R.id.Status);
        status.setText("Tap to play once again");
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}