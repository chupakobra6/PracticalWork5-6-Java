package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SettingsPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_page);

        Button exitbutton = findViewById(R.id.exit_button);
        exitbutton.setOnClickListener(view -> {
            Toast toast = Toast.makeText(getApplicationContext(), "Чтобы выйти, нажмите Назад.", Toast.LENGTH_SHORT);
            toast.show();
        });

        Button deletebutton = findViewById(R.id.delete_button);
        deletebutton.setOnClickListener(view -> {
            Toast toast = Toast.makeText(getApplicationContext(), "Нет.", Toast.LENGTH_SHORT);
            toast.show();
        });

        Button savebutton = findViewById(R.id.save_button);
        savebutton.setOnClickListener(view -> {
            EditText newname = findViewById(R.id.fullnamechange_EditText);
            EditText newsex = findViewById(R.id.sexchange_EditText);
            EditText newage = findViewById(R.id.agechange_EditText);
            EditText newbirthdate = findViewById(R.id.birthdatechange_EditText);
            EditText newdescription = findViewById(R.id.descriptionchange_EditText);

            String name = newname.getText().toString();
            String sex = newsex.getText().toString();
            String age = newage.getText().toString();
            String birthdate = newbirthdate.getText().toString();
            String description = newdescription.getText().toString();

            Intent intent = new Intent(view.getContext(), UserPage.class);
            intent.putExtra("name", name);
            intent.putExtra("sex", sex);
            intent.putExtra("age", age);
            intent.putExtra("birthdate", birthdate);
            intent.putExtra("description", description);
            startActivity(intent);
        });
    }
}