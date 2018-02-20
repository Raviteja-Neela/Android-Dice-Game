package com.example.ravit.homework21;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation; // Package for Animation
import android.view.animation.AnimationUtils; // Package for Animation
import android.widget.Button; //Package for Button
import android.widget.ImageView; //Package for Imageview
import android.widget.TextView; //Package for Textview

import java.util.Random; // Package for Random generation



public class MainActivity extends AppCompatActivity{
    Button start,reseting, reseting1; // Button declaration
    int random1, random2, count=0, sum,temp; // local variables
    ImageView img1, img2; // Imageview decalration
    TextView result,help; // TextView declaration
    String result1,result2; // String references for displaying the results

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        start = (Button) findViewById(R.id.startButton); //Button references
        reseting = (Button) findViewById(R.id.resetButton); //Button references
        reseting1 = (Button) findViewById(R.id.resetButton2); //Button references
        img1 = (ImageView) findViewById(R.id.imageView3); //Imageview references
        img2 = (ImageView) findViewById(R.id.imageView4); //Imageview references
        result = (TextView) findViewById(R.id.resultTextView); //Textview references
        help = (TextView) findViewById(R.id.helpTextView); //Textview references
        reseting1.setVisibility(View.GONE);
    }

    public void resetGame(View v)
    {
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_around_center_point); // Loading the Animation
        img1.startAnimation(animation); // Animation started for the both the images
        img2.startAnimation(animation);
        img1.setImageResource(R.drawable.random_dice); // Assigning the images randomly for both the dice
        img2.setImageResource(R.drawable.random_dice);
        count=0;
        result.setText("");
        help.setText("");
        random1=0; random2=0;
        start.setVisibility(View.VISIBLE); // Setting the flags for the start and reset startButtons
        reseting.setVisibility(View.VISIBLE);
        reseting1.setVisibility(View.GONE);
        start.setText("Play Game");
    }

    //This method is ecxecuted when the user clicks the Play button, In this method based on the random numbers generated,
    // we assign the respective images to their views and add the count of the numbers on both the images and calculates sum,
    //based on which it is decided if the user has won or lost
    public void onPlay(View v)
    {
        count=count+1;
        Random r = new Random();
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_around_center_point);
        img1.startAnimation(animation);
        img2.startAnimation(animation);
        random1 = r.nextInt(6) + 1;
        random2 = r.nextInt(6) + 1;

        if (random1 == 1)
        {
            img1.setImageResource(R.drawable.die1);
        } else if (random1 == 2)
        {
            img1.setImageResource(R.drawable.die2);
        }
        else if (random1 == 3)
        {
            img1.setImageResource(R.drawable.die3);
        }
        else if (random1 == 4)
        {
            img1.setImageResource(R.drawable.die4);
        }
        else if (random1 == 5)
        {
            img1.setImageResource(R.drawable.die5);
        }
        else
            img1.setImageResource(R.drawable.die6);


        if (random2 == 1)
        {
            img2.setImageResource(R.drawable.die1);
        }
        else if (random2 == 2)
        {
            img2.setImageResource(R.drawable.die2);
        }
        else if (random2 == 3)
        {
            img2.setImageResource(R.drawable.die3);
        }
        else if (random2 == 4)
        {
            img2.setImageResource(R.drawable.die4);
        }
        else if (random2 == 5)
        {
            img2.setImageResource(R.drawable.die5);
        }
        else
            img2.setImageResource(R.drawable.die6);

        sum=random1+random2;

        if(count==1)
        {
            if(sum==7 || sum==11)
            {
                result.setText("You have Won the game");
                help.setText("To start a new game again, Click on Reset button");
                start.setVisibility(View.GONE);
                reseting.setVisibility(View.GONE);
                reseting1.setVisibility(View.VISIBLE);

            }
            else if(sum==2 || sum==3 || sum==12)
            {
                result.setText("You have Lost the game");
                help.setText("To start a new game again, Click on reset button");
                start.setVisibility(View.GONE);
                reseting.setVisibility(View.GONE);
                reseting1.setVisibility(View.VISIBLE);

            }
            else if(sum==4 || sum==5 || sum==6 || sum==8 || sum==9 || sum==10)
            {
                temp=sum;
                result1 = Integer.toString(sum);
                result2 = "Player points" + " : " + result1;
                start.setText("Play Again");
                result.setText(result2);
                help.setText("To continue game, Click on Play again");
            }
            else
            {

            }
        }
        else if(temp!=0)
        {
            start.setText("Play Again");
            if(sum==7)
            {
                result.setText("You have lost the game");
                help.setText("To start a  new game again, Click on Reset button");
                start.setVisibility(View.GONE);
                reseting.setVisibility(View.GONE);
                reseting1.setVisibility(View.VISIBLE);
            }
            else if(temp==sum)
            {
                result.setText("You have won the game");
                help.setText("To start a new game again, Click on Reset button");
                start.setVisibility(View.GONE);
                reseting.setVisibility(View.GONE);
                reseting1.setVisibility(View.VISIBLE);
            }
            else
            {
                result.setText("Points didn't match");
                help.setText("To continue game, Click on play again");
            }
        }
        else
        {
            Animation anim1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_around_center_point);
            img1.startAnimation(anim1);
            img2.startAnimation(anim1);
            img1.setImageResource(R.drawable.random_dice);
            img2.setImageResource(R.drawable.random_dice);
            result.setText("");
            help.setText("Please click on reset button and click on play game to start a new game");
        }
    }
}

