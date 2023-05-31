package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText login = (EditText) findViewById(R.id.login_EditText);
        EditText password = (EditText) findViewById(R.id.password_EditText);

        Button enterButton = (Button) findViewById(R.id.enterButton);
        enterButton.setOnClickListener(view -> {

            String slogin = login.getText().toString();
            String spassword = password.getText().toString();
            AuthorizationService authorizationService = new AuthorizationService();

            if (authorizationService.authorize(slogin, spassword)) {
                Intent intent = new Intent(view.getContext(), UserPage.class);
                Toast toast = Toast.makeText(getApplicationContext(), "Авторизация прошла успешно", Toast.LENGTH_SHORT);
                toast.show();
                view.getContext().startActivity(intent);
                System.out.println("Авторизация прошла успешно");
            } else {
                Toast toast = Toast.makeText(getApplicationContext(), "Ошибка: некорректный логин или пароль", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

    public class AuthorizationService {
        public boolean authorize(String login, String password) {
            if (!isValidLogin(login)) {
                Toast toast = Toast.makeText(getApplicationContext(), "Ошибка: некорректный логин", Toast.LENGTH_SHORT);
                toast.show();
                return false;
            }

            if (!isValidPassword(password)) {
                Toast toast = Toast.makeText(getApplicationContext(), "Ошибка: некорректный пароль", Toast.LENGTH_SHORT);
                toast.show();
                return false;
            }

            return true;
        }

        private boolean isValidLogin(String login) {
            if (login == null || login.isEmpty()) {
                return false;
            }

            // Проверка на соответствие формату электронной почты
            String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
            Pattern pattern = Pattern.compile(emailRegex);
            Matcher matcher = pattern.matcher(login);
            return matcher.matches();
        }

        private boolean isValidPassword(String password) {
            if (password == null || password.length() < 6) {
                return false;
            }

            // Проверка на наличие спецсимволов
            if (!password.matches(".*[!@#$%^&*?].*")) {
                return false;
            }

            // Проверка на наличие заглавных букв
            if (!password.matches(".*[A-Z].*")) {
                return false;
            }

            return true;
        }
    }

}