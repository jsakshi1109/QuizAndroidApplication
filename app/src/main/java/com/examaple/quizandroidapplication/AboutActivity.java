package com.examaple.quizandroidapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView aboutUsText = findViewById(R.id.aboutUsText);

        // Set the content for the About Us section
        String aboutUsContent = "Welcome to our Quiz Android Application!\n\n"
                + "This application is designed to help users learn and practice various subjects through interactive quizzes. "
                + "With a wide range of topics including English, Mathematics, Science, Social Science, General Knowledge, and Computer Science, "
                + "users can test their knowledge and improve their skills in a fun and engaging way.\n\n"
                + "We are dedicated to providing a user-friendly experience and valuable educational content. "
                + "Feel free to explore the app, challenge yourself with quizzes, and enhance your learning experience!\n\n"
                + "Thank you for using our Quiz Android Application!";

        aboutUsText.setText(aboutUsContent);
    }
}