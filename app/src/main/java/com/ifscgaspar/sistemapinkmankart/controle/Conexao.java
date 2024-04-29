package com.ifscgaspar.sistemapinkmankart.controle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static Connection conexao;
    private static Conexao instancia;
    private static String DATABASE = null;
    private static String USER = null;
    private static String PSW = null;

    public Conexao() {
    }

    public static Conexao getInstancia() {
        if (instancia == null) {
            instancia = new Conexao();
            lerArquivoBD();
        }
        return instancia;
    }

    public Connection conectar() {
        try {
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/" + DATABASE + "?serverTimezone=UTC", USER,
                    PSW);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conexao;
    }

    public static void lerArquivoBD() {
        // Lê as informações de login e senha do arquivo de texto

        try {
            BufferedReader reader = new BufferedReader(new FileReader("credentials.txt"));
            if (reader != null) {
                DATABASE = reader.readLine();
                USER = reader.readLine();
                PSW = reader.readLine();
            }
            reader.close();

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            return;
        }
    }

    public boolean fecharConexao() {
        try {
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return false;
    }
}
