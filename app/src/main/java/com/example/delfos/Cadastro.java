package com.example.delfos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Cadastro extends AppCompatActivity {


    private EditText tripulanteApp;
    private EditText loginApp;
    private EditText senhaCadastroApp;
    private EditText confirmaSenhaApp;
    private Button cadastroApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        tripulanteApp = findViewById( R.id.txtTripulante);
        loginApp = findViewById(R.id.txtLoginCadastro);
        senhaCadastroApp = findViewById(R.id.txtSenhaCadastro);
        confirmaSenhaApp = findViewById(R.id.txtSenhaConfirmaCadastro);
        cadastroApp = findViewById(R.id.btnCadastrro);

        cadastroApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String senha = senhaCadastroApp.getText().toString();
                String confirmasenha = confirmaSenhaApp.getText().toString();

                if (senha.equals(confirmasenha))
                {
                    Maintenance maintenance = new Maintenance();

                    maintenance.registerUser(Cadastro.this,loginApp.getText().toString(), confirmasenha);
                }


            }
        });



    }
}