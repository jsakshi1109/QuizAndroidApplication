package com.examaple.quizandroidapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class StartQuizActivity extends AppCompatActivity {

    private TextView textViewQuestion;
    private Button buttonFlip, prevQuestionButton, nextQuestionButton;
    private SQLiteDatabase database;
    private Cursor cursor;
    private String selectedSubject;
    private boolean isQuestionVisible = true;
    private CardView cardViewQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_quiz);

        textViewQuestion = findViewById(R.id.textViewQuestion);
        buttonFlip = findViewById(R.id.buttonFlip);
        cardViewQuestion = findViewById(R.id.cardViewQuestion);
        prevQuestionButton = findViewById(R.id.prevQuestion);
        nextQuestionButton = findViewById(R.id.nextQuestion);
        TextView subject = findViewById(R.id.textViewSubject);

        // Retrieve selected subject from the Intent
        selectedSubject = getIntent().getStringExtra("SELECTED_SUBJECT");
        subject.setText(selectedSubject);

        // Check if selectedSubject is not null before executing the query
        if (selectedSubject != null) {
            // Open database and execute query
            database = new DatabaseHelper(this).getReadableDatabase();
            cursor = database.rawQuery("SELECT * FROM " + selectedSubject, null);

            // Check if cursor contains data
            if (cursor != null && cursor.moveToFirst()) {
                // Load the first question
                loadQuestion();

                // Set click listener for the flip button
                buttonFlip.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Flip between question and answer
                        flipCard();
                    }
                });

                // Set click listener for the previous question button
                prevQuestionButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Move cursor to the previous question
                        if (cursor.moveToPrevious()) {
                            buttonFlip.setVisibility(View.VISIBLE);
                            // Load the previous question
                            loadQuestion();
                        } else {
                            // Handle when there are no more previous questions
                            textViewQuestion.setText("No previous questions found.");
                            buttonFlip.setVisibility(View.INVISIBLE);
                        }
                    }
                });

                // Set click listener for the next question button
                nextQuestionButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Move cursor to the next question
                        if (cursor.moveToNext()) {
                            buttonFlip.setVisibility(View.VISIBLE);
                            // Load the next question
                            loadQuestion();
                        } else {
                            // Handle when there are no more questions
                            textViewQuestion.setText("No more questions found.");
                            buttonFlip.setVisibility(View.INVISIBLE);
                        }
                    }
                });
            } else {
                // Handle the case where cursor is null or does not contain data
                textViewQuestion.setText("No questions found for the selected subject.");
                buttonFlip.setVisibility(View.INVISIBLE);
            }
        } else {
            // Handle the case where selectedSubject is null (e.g., show an error message)
            textViewQuestion.setText("Error: No subject selected.");
            buttonFlip.setVisibility(View.INVISIBLE);
        }

        Button exitButton = findViewById(R.id.buttonExit);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartQuizActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void loadQuestion() {
        // Retrieve question from the cursor
        @SuppressLint("Range") String question = cursor.getString(cursor.getColumnIndex("question"));

        // Display the question
        textViewQuestion.setText(question);
        isQuestionVisible = true;
        buttonFlip.setText("Flip to Answer");
    }

    private void flipCard() {
        if (textViewQuestion.getText().equals("No questions found for the selected subject.")) {
            return; // No action if there are no more questions
        }

        // Flip animation for card view along the X-axis
        if (isQuestionVisible) {
            cardViewQuestion.animate().rotationX(90f).setDuration(250).withEndAction(new Runnable() {
                @SuppressLint("Range")
                @Override
                public void run() {
                    // Toggle between question and answer
                    textViewQuestion.setText(cursor.getString(cursor.getColumnIndex("answer")));
                    buttonFlip.setText("Flip to Question");
                    cardViewQuestion.setRotationX(-90f);
                    cardViewQuestion.animate().rotationX(0f).setDuration(250).start();
                }
            }).start();
        } else {
            cardViewQuestion.animate().rotationX(-90f).setDuration(250).withEndAction(new Runnable() {
                @Override
                public void run() {
                    // Toggle between question and answer
                    loadQuestion();
                    buttonFlip.setText("Flip to Answer");
                    cardViewQuestion.setRotationX(90f);
                    cardViewQuestion.animate().rotationX(0f).setDuration(250).start();
                }
            }).start();
        }

        isQuestionVisible = !isQuestionVisible;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Close the cursor and database to avoid memory leaks
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
        if (database != null && database.isOpen()) {
            database.close();
        }
    }
}
