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
import com.ifscgaspar.sistemapinkmankart.controle.Conexao;
import com.ifscgaspar.sistemapinkmankart.controle.LoginDAO;

public class LoginActivity extends AppCompatActivity {
    Button btnEntrar;
    EditText edLogin, edSenha;

    Conexao con;

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

        btnEntrar = findViewById(R.id.btnEntrar);
        edLogin = findViewById(R.id.edLogin);
        edSenha = findViewById(R.id.edSenha);

        con = Conexao.getInstancia(); // Usando a instância global

        btnEntrar.setOnClickListener(v -> {
            Context contexto = getApplicationContext();
            String login = edLogin.getText().toString();
            String senha = edSenha.getText().toString();
            LoginDAO l = new LoginDAO();
            boolean autenticado = l.autenticarLogin(login, senha);
            System.out.println("autenticado " + autenticado);

            if (autenticado) {
                if (con.conectar() != null) { // Verifica se a conexão foi estabelecida
                    Toast.makeText(contexto, "Você entrou com sucesso!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this, InicialActivity.class));
                } else {
                    Toast.makeText(contexto, "Erro ao conectar ao banco de dados!", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(contexto, "Dados preenchidos de forma incorreta!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (con != null) {
            con.fecharConexao(); // Fecha a conexão com o banco de dados
        }
    }
}