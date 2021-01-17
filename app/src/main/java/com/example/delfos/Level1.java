package com.example.delfos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Level1 extends AppCompatActivity {

    private TextView userApp;
    private TextView levelApp;
    private TextView MisaoApp;
    private Button ranking;
    private Button completarMisao;
    String name;
    String leveis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1);

        userApp = findViewById(R.id.User);
        levelApp = findViewById(R.id.level);
        MisaoApp = findViewById(R.id.MisaoBox);

        User usuario = new User();
        name = usuario.getUser();
        leveis = usuario.getLevel();
        userApp.setText(name);
        levelApp.setText(leveis);
    }
}