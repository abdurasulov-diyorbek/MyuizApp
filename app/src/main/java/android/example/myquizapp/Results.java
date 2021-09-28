package android.example.myquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Results extends AppCompatActivity {

    TextView rightAnswers, wrongAnswers, nonSelectedAnswers;
    Button tryAgain;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);


        rightAnswers = findViewById(R.id.rightAnswers);
        wrongAnswers = findViewById(R.id.wrongAnswers);
        nonSelectedAnswers = findViewById(R.id.nonSelectedAnswers);

        rightAnswers.setText("Right answers: " + Quiz.rightAnswers);
        wrongAnswers.setText("Wrong answers" + Quiz.wrongAnswers);
        nonSelectedAnswers.setText("Non selected answers: "+ Quiz.nonSelectedQuestions);

        Quiz.rightAnswers = 0;
        Quiz.wrongAnswers = 0;
        Quiz.nonSelectedQuestions = 0;

        tryAgain = findViewById(R.id.try_again_button);
        tryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Results.this, MainActivity.class);
                startActivity(intent);
            }
        });



    }
}