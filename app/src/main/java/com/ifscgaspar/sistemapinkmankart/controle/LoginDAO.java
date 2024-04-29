package com.ifscgaspar.sistemapinkmankart.controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
    // Método para autenticar o login
    public boolean autenticarLogin(String login, String senha) {
        Conexao con = Conexao.getInstancia();
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            conn = con.conectar();
            st = conn.prepareStatement("SELECT nome_completo, cpf FROM funcionarios WHERE nome_completo=? AND cpf=?");
            st.setString(1, login); // Defina o nome do funcionário
            st.setString(2, senha); // Defina a senha
            rs = st.executeQuery();

            if (rs.next()) {
                // Usuário autenticado
                return true;
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            // Fechar os recursos
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            con.fecharConexao(); // Fechar a conexão com o banco de dados
        }
        return false;
    }
}
