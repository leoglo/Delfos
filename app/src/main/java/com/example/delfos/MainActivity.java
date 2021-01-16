package com.example.delfos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edtLogin;
    private EditText edtsenha;
    private Button btnLogin;
    private TextView txtcadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtLogin = findViewById(R.id.edtlogin);
        edtsenha = findViewById(R.id.edtSenha);
        btnLogin = findViewById(R.id.btnLogar);
        txtcadastro = findViewById(R.id.txtCadastro);

        txtcadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Cadastro.class));
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean validado = true;

                if(edtLogin.getText().length()==0){
                    edtLogin.setError("campo login obrigatorio");
                    edtLogin.requestFocus();
                    validado = false;
                }

                if(edtsenha.getText().length()==0){
                    edtsenha.setError("campo senha obrigatorio");
                    edtsenha.requestFocus();
                    validado = false;
                }

                if (validado){
                    Toast.makeText(getApplicationContext(),"validando seus dados", Toast.LENGTH_SHORT);

                    Maintenance manute = new Maintenance();
                    manute.validarlogin(MainActivity.this, edtLogin.getText().toString(), edtsenha.getText().toString());
                }

            }

        });
    }


}