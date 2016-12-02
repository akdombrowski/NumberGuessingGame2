package appdev.numberguessinggame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class NumberGuesser extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_guesser);
    }

    public void startGame(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        String message = "Computer Guesses...";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
