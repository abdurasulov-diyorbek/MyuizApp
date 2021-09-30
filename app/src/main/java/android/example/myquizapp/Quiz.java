package android.example.myquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Toast;

public class Quiz extends AppCompatActivity {

    RadioGroup radioGroup1, radioGroup2;
    RadioButton radioButton1, radioButton2, radioButton3, radioButton4, radioButton5, radioButton6;
    public static int rightAnswers, wrongAnswers, nonSelectedQuestions;
    Button submitButton;
    EditText editText;
    CheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        ScrollView view = findViewById(R.id.scrollView);
        view.setSmoothScrollingEnabled(true);
        view.fullScroll(View.FOCUS_DOWN);

        rightAnswers = 0;
        wrongAnswers = 0;
        nonSelectedQuestions = 0;
        radioGroup1 = findViewById(R.id.radioGroup1);
        radioGroup2 = findViewById(R.id.radioGroup2);
        radioButton1 = findViewById(R.id.rb1);
        radioButton2 = findViewById(R.id.rb2);
        radioButton3 = findViewById(R.id.rb3);
        radioButton4 = findViewById(R.id.rb4);
        radioButton5 = findViewById(R.id.rb5);
        radioButton6 = findViewById(R.id.rb6);
        checkBox1 = findViewById(R.id.btn_checkBox1);
        checkBox2 = findViewById(R.id.btn_checkBox2);
        checkBox3 = findViewById(R.id.btn_checkBox3);
        checkBox4 = findViewById(R.id.btn_checkBox4);
        checkBox5 = findViewById(R.id.btn_checkBox5);

        editText = findViewById(R.id.fourthQuestion);

        submitButton = findViewById(R.id.submit_answers_button);


        submitButton.setOnClickListener(v -> {
            checkAnswers();
            Intent intent = new Intent(Quiz.this, Results.class);
            startActivity(intent);
        });

    }

    private void checkAnswers() {
        if (radioGroup1.getCheckedRadioButtonId() == -1) {
            nonSelectedQuestions++;
        } else {
            if (radioButton2.isChecked()) {
                rightAnswers++;
            } else {
                wrongAnswers++;
            }
        }

        if (radioGroup2.getCheckedRadioButtonId() == -1) {
            nonSelectedQuestions++;
        } else {
            if (radioButton4.isChecked()) {
                rightAnswers++;
            } else {
                wrongAnswers++;
            }
        }


        if (editText.getText().toString().matches("")) {
            nonSelectedQuestions++;
        } else {
            if (editText.getText().toString().trim().equalsIgnoreCase("London") || editText.getText().toString().trim().equalsIgnoreCase("london")) {
                rightAnswers++;
            } else {
                wrongAnswers++;
            }
        }

        if (checkBox1.isChecked() || checkBox2.isChecked() || checkBox3.isChecked() || checkBox4.isChecked() || checkBox5.isChecked()) {
            if (checkBox1.isChecked() && checkBox2.isChecked() && checkBox5.isChecked() && !checkBox3.isChecked() && !checkBox4.isChecked()) {
                rightAnswers++;
            } else {
                wrongAnswers++;
            }
        } else {
            nonSelectedQuestions++;
        }

    }
}