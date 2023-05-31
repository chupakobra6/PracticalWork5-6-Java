package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class UserPage extends AppCompatActivity {

    @Override
    protected void onStart() {
        super.onStart();
        setContentView(R.layout.activity_user_page);

        if (getIntent().getExtras() != null) {
            Bundle args = getIntent().getExtras();

            TextView fullname = findViewById(R.id.fullname_textView);
            TextView sex = findViewById(R.id.sex_textView);
            TextView age = findViewById(R.id.age_textView);
            TextView birthdate = findViewById(R.id.birthdate_textView);
            TextView description = findViewById(R.id.description_textView);

            String newname = args.getString("name");
            String newsex = args.getString("sex");
            String newage = args.getString("age");
            String newbirthdate = args.getString("birthdate");
            String newdescription = args.getString("description");

            fullname.setText("ФИО: " + newname);
            sex.setText("Пол: " + newsex);
            age.setText("Возраст: " + newage);
            birthdate.setText("Дата рождения: " + newbirthdate);
            description.setText(" Описание: " + newdescription);
        }

        Button settingsButton = (Button) findViewById(R.id.settings_button);
        settingsButton.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), SettingsPage.class);
            view.getContext().startActivity(intent);
        });
    }
}