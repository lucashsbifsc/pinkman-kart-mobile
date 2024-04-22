package com.ifscgaspar.sistemapinkmankart.controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
    public boolean autenticarLogin(String login, long senha) {

        Conexao con = Conexao.getInstancia();

        try {
            Connection conn = con.conectar();
            PreparedStatement st = conn.prepareStatement("SELECT nome_completo, cpf FROM funcionarios WHERE nome_completo=? AND cpf=?");
            st.setString(1, login); // Defina o nome do funcionário
            st.setLong(2, senha); // Defina o CPF como senha
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                // Usuário autenticado
                return true;
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            con.fecharConexao();
        }

        return false;
    }
}
