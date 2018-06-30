package com.example.android.computerstudiesquizapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /**
     * Defining the variable scores
     */
    int score = 0;
    String score1;
    boolean score2;
    boolean score3;
    boolean score4;
    boolean score5;
    String score6;
    boolean score7;
    boolean score8;
    boolean score9;
    boolean score10;
    Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Getting result of the answers on submission
     */
    public void get_result(View view) {
        EditText namefield = (EditText) findViewById(R.id.name_field);
        String name = namefield.getText().toString();

        //Check for users' input
        EditText checkEdit = (EditText) findViewById(R.id.answer1Text);
        score6 = checkEdit.getText().toString();
        if (score6.matches("")) {
            Toast.makeText(this, "Please answer all questions to proceed", Toast.LENGTH_LONG).show();
            return;
        }

        //Disable the submit button after submitting answers
        Button submitButton = (Button) findViewById(R.id.submit);
        submitButton.setEnabled(false);


        /**
         * Question 1 correct answer - "computer"
         */
        EditText answerScore1 = (EditText) findViewById(R.id.answer1Text);
        score1 = answerScore1.getText().toString().toLowerCase();
        if (score1.equals("computer")) {
            score = score + 1;
        } else {
            score = score + 0;
        }

        /**
         * Question 2 correct answer - "Advanced Research Project Agency Network"
         */
        RadioButton answerScore2 = (RadioButton) findViewById(R.id.answer2RadioButton1);
        score2 = answerScore2.isChecked();
        if (score2) {
            score = score + 1;
        } else {
            score = score + 0;
        }

        /**
         * Question 3 correct answer - "Supercomputer, Mainframe, Minicomputer, Microcomputer, Personal Digital Assistants(PDAs) and vice versa"
         */
        CheckBox answerScore3 = (CheckBox) findViewById(R.id.answer3_3CheckBox);
        score3 = answerScore3.isChecked();
        if (score3) {
            score = score + 1;
        } else {
            score = score + 0;
        }
        CheckBox answerScore4 = (CheckBox) findViewById(R.id.answer3_4CheckBox);
        score4 = answerScore4.isChecked();
        if (score4) {
            score = score + 1;
        } else {
            score = score + 0;
        }

        /**
         * Question 4 correct answer - "Information is processed raw data designed according user's desire"
         */
        RadioButton answerScore5 = (RadioButton) findViewById(R.id.answer4RadioButton1);
        score5 = answerScore5.isChecked();
        if (score5) {
            score = score + 1;
        } else {
            score = score + 0;
        }

        /**
         * Question 5 correct answer - "software"
         */
        EditText answerScore6 = (EditText) findViewById(R.id.answer5Text);
        score6 = answerScore6.getText().toString().toLowerCase();
        if (score6.equals("software")) {
            score = score + 1;
        } else {
            score = score + 0;
        }

        /**
         * Question 6 correct answer - "Internet is the global interconnection of computer networks which enable sharing of data, information and files"
         */
        RadioButton answerScore7 = (RadioButton) findViewById(R.id.answer6RadioButton3);
        score7 = answerScore7.isChecked();
        if (score7) {
            score = score + 1;
        } else {
            score = score + 0;
        }

        /**
         * Question 7 correct answer - "a. Larger RAMs are faster than ROMs
         *                              b. RAM is a volatile storage medium chip while ROM is a non-volatile storage medium chip
         *                              c. RAM is Random Access Memory while ROM is Read Only Memory"
         */
        CheckBox answerScore8 = (CheckBox) findViewById(R.id.answer7_1CheckBox);
        score8 = answerScore8.isChecked();
        if (score8) {
            score = score + 1;
        } else {
            score = score + 0;
        }
        CheckBox answerScore9 = (CheckBox) findViewById(R.id.answer7_2CheckBox);
        score9 = answerScore9.isChecked();
        if (score9) {
            score = score + 1;
        } else {
            score = score + 0;
        }
        CheckBox answerScore10 = (CheckBox) findViewById(R.id.answer7_3CheckBox);
        score10 = answerScore10.isChecked();
        if (score10) {
            score = score + 1;
        } else {
            score = score + 0;
        }

        /**
         * Finding total score and showing the user's score via Toast message
         */
        //Declaring the variable totalScore
        if (score == 10) {
            Toast.makeText(this, "Congratulations, " + name + " your score is: " + score + " Thank You.", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, " You failed, " + name + " your score is: " + score + ". Please try again.", Toast.LENGTH_LONG).show();
        }
        resetQuiz();

        String answers = "Correct answers are: \n 1. computer \n2. Advanced Research Project Agency Network \n3.Personal Digital Assistants(PDAs), Microcomputer, Minicomputer, Mainframe, Supercomputer \nSupercomputer, Mainframe, Minicomputer, Microcomputer, Personal Digital Assistants(PDAs) \n4.Information is processed raw data designed according to user's desire. \n5. software \n6.Internet is the global interconnection of computer networks which enables the sharing of data, information and files \n7.Larger RAMs are faster than ROMs. \nRAM is a volatile storage medium chip while ROM is a non-volatile storage medium chip. \nRAM is Random Access Memory while ROM is Read Only Memory.\"";

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); //only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Computer Quiz Answers for " + name);
        intent.putExtra(Intent.EXTRA_TEXT, answers);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }

    /**
     * Reset EditTexts fields RadioGroups and Checkboxes once the submit button is clicked
     */
    private void resetQuiz() {
        EditText editText1 = (EditText) findViewById(R.id.answer1Text);
        editText1.setText("");

        EditText editText2 = (EditText) findViewById(R.id.answer5Text);
        editText2.setText("");

        RadioGroup one = (RadioGroup) findViewById(R.id.question2);
        one.clearCheck();

        RadioGroup two = (RadioGroup) findViewById(R.id.question4);
        two.clearCheck();

        RadioGroup three = (RadioGroup) findViewById(R.id.question6);
        three.clearCheck();

        CheckBox checkBoxes1 = (CheckBox) findViewById(R.id.answer3_1CheckBox);
        checkBoxes1.setChecked(false);

        CheckBox checkBoxes2 = (CheckBox) findViewById(R.id.answer3_2CheckBox);
        checkBoxes2.setChecked(false);

        CheckBox checkBoxes3 = (CheckBox) findViewById(R.id.answer3_3CheckBox);
        checkBoxes3.setChecked(false);

        CheckBox checkBoxes4 = (CheckBox) findViewById(R.id.answer3_4CheckBox);
        checkBoxes4.setChecked(false);

        CheckBox checkBoxes5 = (CheckBox) findViewById(R.id.answer7_1CheckBox);
        checkBoxes5.setChecked(false);

        CheckBox checkBoxes6 = (CheckBox) findViewById(R.id.answer7_2CheckBox);
        checkBoxes6.setChecked(false);

        CheckBox checkBoxes7 = (CheckBox) findViewById(R.id.answer7_3CheckBox);
        checkBoxes7.setChecked(false);

        CheckBox checkBoxes8 = (CheckBox) findViewById(R.id.answer7_4CheckBox);
        checkBoxes8.setChecked(false);

        CheckBox checkBoxes9 = (CheckBox) findViewById(R.id.answer7_5CheckBox);
        checkBoxes9.setChecked(false);
    }
}
