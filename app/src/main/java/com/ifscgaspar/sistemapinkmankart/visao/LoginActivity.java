package com.ifscgaspar.sistemapinkmankart.visao;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.ifscgaspar.sistemapinkmankart.R;
import com.ifscgaspar.sistemapinkmankart.controle.LoginDAO;

public class LoginActivity extends AppCompatActivity {

    Button btnEntrar;
    EditText edLogin;
    EditText edSenha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.tela_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.telalogin), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnEntrar = (Button)findViewById(R.id.btnEntrar);
        edLogin = (EditText)findViewById(R.id.edLogin);
        edSenha = (EditText)findViewById(R.id.edSenha);
        btnEntrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Context contexto = getApplicationContext();
                String login = String.valueOf(edLogin.getText());
                Long senha = Long.valueOf(String.valueOf(edSenha.getText()));
                LoginDAO l = new LoginDAO();
                Boolean autenticado = l.autenticarLogin(login, senha);
                System.out.println("autenticado "+autenticado);

                if(autenticado) {
                    startActivity(new Intent(LoginActivity.this, InicialActivity.class));
                } else {
                    Toast toast = Toast.makeText(contexto, "Dados preenchidos de forma incorreta!", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });


    }
}