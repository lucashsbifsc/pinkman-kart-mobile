package com.ifscgaspar.sistemapinkmankart.controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
    public boolean autenticarLogin(String login, long senha) {

        Conexao con = Conexao.pegaConexao();

        System.out.println(login);
        System.out.println(senha);
        try {
            if (login.equals("root") && senha == 1234) {
                // Usuário autenticado
                return true;
            }
        } finally {
           // con.fecharConexao();
        }

        return false;
    }
}
