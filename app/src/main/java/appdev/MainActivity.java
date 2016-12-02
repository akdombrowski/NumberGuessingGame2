package appdev.numberguessinggame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int guess;
    private int max;
    private int min;
    private static int counter;
    private static final int ROUNDS = 6;
    private Random rndGen;
    private TextView guessTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String message = intent.getStringExtra(NumberGuesser.EXTRA_MESSAGE);
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);

        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_main);
        layout.addView(textView);

        guessTxt = (TextView) findViewById(R.id.guess);
        rndGen = new Random();
        min = 1;
        max = 100;
        guess = rndGen.nextInt(100) + min;
        counter = 1;

        updateGuessText();
    }

    public void updateGuessText() {
        guessTxt.setText(guess + "");
    }

    public void higher(View view) {
        counter++;

        if (counter > ROUNDS || guess >= max) {
            lost();
        }

        min = guess;
        if (min < max) {
            int diff = max - min;
            guess = rndGen.nextInt(diff) + min;
        } else {
            guess = max;
        }

        updateGuessText();
    }

    public void lower(View view) {
        counter++;

        if(counter > ROUNDS || guess <= min) {
            lost();
        }

        max = guess;
        if (max > min) {
            int diff = max - min;
            guess = rndGen.nextInt(diff) + min;
        } else {
            guess = min;
        }
        updateGuessText();
    }

    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";


    public void correct(View view) {
        Intent intent = new Intent(this, DisplayFinalScreen.class);
        String message = "The Computer Won!";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void lost() {
        Intent intent = new Intent(this, DisplayFinalScreen.class);
        String message = "You Beat the Computer!";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }
}
