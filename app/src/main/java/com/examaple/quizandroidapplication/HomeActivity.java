package com.examaple.quizandroidapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        CardView cardViewEnglish = findViewById(R.id.cardViewEnglish);
        CardView cardViewMathematics = findViewById(R.id.cardViewMathematics);
        CardView cardViewScience = findViewById(R.id.cardViewScience);
        CardView cardViewSocialScience = findViewById(R.id.cardViewSocialScience);
        CardView cardViewGeneralKnowledge = findViewById(R.id.cardViewGeneralKnowledge);
        CardView cardViewComputerScience = findViewById(R.id.cardViewComputerScience);

        cardViewEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuizActivity("English");
            }
        });

        cardViewMathematics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuizActivity("Mathematics");
            }
        });

        cardViewScience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuizActivity("Science");
            }
        });

        cardViewSocialScience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuizActivity("SocialScience");
            }
        });

        cardViewGeneralKnowledge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuizActivity("GeneralKnowledge");
            }
        });

        cardViewComputerScience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuizActivity("ComputerScience");
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
            if( item.getItemId() == R.id.menu_about_us) {
                // Handle About Us menu item click
                startActivity(new Intent(this, AboutActivity.class));
                return true;
            }
            else if( item.getItemId() == R.id.menu_contact_us) {
                startActivity(new Intent(this, ContactActivity.class));
                return true;
            }
            else if( item.getItemId() == R.id.menu_rate_us) {
                startActivity(new Intent(this, RateUsActivity.class));
                return true;
            }
            else if( item.getItemId() == R.id.menu_share_app) {
                shareApp();
                return true;
            }
            else if( item.getItemId() == R.id.logout) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Logout")
                        .setMessage("Are you sure you want to logout?")
                        .setPositiveButton("Logout", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // Clear SharedPreferences and redirect to LoginActivity
                                SharedPreferences sharedPreferences = getSharedPreferences("user_prefs",MODE_PRIVATE);
                                SharedPreferences.Editor e = sharedPreferences.edit();
                                e.clear();
                                e.apply();
                                Intent i = new Intent(HomeActivity.this, LoginActivity.class);
                                startActivity(i);
                                finish();
                            }
                        })
                        .setNegativeButton("Cancel", null);
                builder.create().show();
                return true;
            }
        return false;
    }

    private void shareApp() {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Check out this app!");
        shareIntent.putExtra(Intent.EXTRA_TEXT, "Download the Quiz App and start learning: https://play.google.com/store/apps/details?id=com.example.quizandroidapplication");
        startActivity(Intent.createChooser(shareIntent, "Share the App"));
    }

    private void startQuizActivity(String selectedSubject) {
        Intent intent = new Intent(HomeActivity.this, StartQuizActivity.class);
        intent.putExtra("SELECTED_SUBJECT", selectedSubject);
        startActivity(intent);
    }
}