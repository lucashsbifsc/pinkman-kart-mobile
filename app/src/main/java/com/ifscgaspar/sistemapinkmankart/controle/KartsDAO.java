package com.ifscgaspar.sistemapinkmankart.controle;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ifscgaspar.sistemapinkmankart.modelo.Karts;

public class KartsDAO implements IKartsDAO {
	
	 private static KartsDAO instancia;

	    private KartsDAO() {}

	    public static KartsDAO getInstance() {
	        if (instancia == null) {
	            instancia = new KartsDAO();
	        }
	        return instancia;
	    }

	public int inserirKart(Karts end) {
		String SQL = "INSERT INTO karts (cor, modelo, marca, ano, quantidade, data_entrada, preco, fornecedor_cnpj) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();

		int chavePrimariaGerada = Integer.MIN_VALUE;

		try {
			PreparedStatement ps = conBD.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, end.getCor());
			ps.setString(2, end.getModelo());
			ps.setString(3, end.getMarca());
			ps.setLong(4, end.getAno());
			ps.setLong(5, end.getQuantidade());
			ps.setDate(6, end.getDataEntrada());
			ps.setLong(7, end.getPreco());
			ps.setLong(8, end.getFornecedorCnpj());

			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				chavePrimariaGerada = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}

		return chavePrimariaGerada;
	}

	public ArrayList<Karts> listarKarts() {
		// ArrayList para armazenar os resultados do SELECT
        ArrayList<Karts> karts = new ArrayList<Karts>();

        String SQL = "SELECT * FROM karts";

        Conexao con = Conexao.getInstancia();
        Connection conBD = con.conectar();

        try {
            PreparedStatement ps = conBD.prepareStatement(SQL);
            
            // Cria um objeto JDBC que espera um retorno do Banco de Dados
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                // Cria objeto Java
                Karts end = new Karts();

                // Pega os valores de cada coluna do registro
                long id = rs.getLong("id");
                String cor = rs.getString("cor");
                String modelo = rs.getString("modelo");
                String marca = rs.getString("marca");
                Long ano = rs.getLong("ano");
                Long quantidade = rs.getLong("quantidade");
                Date dataEntrada = rs.getDate("data_entrada");
                Long preco = rs.getLong("preco");
                Long fornecedorCnpj = rs.getLong("fornecedor_cnpj");

                // Seta os valores no objeto Java
                end.setId(id);
                end.setCor(cor);
                end.setModelo(modelo);
                end.setMarca(marca);
                end.setAno(ano);
                end.setQuantidade(quantidade);
                end.setAno(ano);
                end.setDataEntrada(dataEntrada);
                end.setPreco(preco);
                end.setFornecedorCnpj(fornecedorCnpj);

                // Adiciona objeto no ArrayList
                karts.add(end);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            con.fecharConexao();
        }

        return karts;
	}

	public boolean atualizarKart(Karts end) {
		String SQL = "UPDATE karts SET cor = ?, modelo = ?, marca = ?, ano = ?, quantidade = ?, data_entrada = ?, preco = ?, fornecedorCnpj = ?  WHERE id = ?";

        Conexao con = Conexao.getInstancia();
        Connection conBD = con.conectar();

        // Define o retorno como 0 (falso)
        int retorno = 0;

        try {
            PreparedStatement ps = conBD.prepareStatement(SQL);

            ps.setString(1, end.getCor());
			ps.setString(2, end.getModelo());
			ps.setString(3, end.getMarca());
			ps.setLong(4, end.getAno());
			ps.setLong(5, end.getQuantidade());
			ps.setDate(6, end.getDataEntrada());
			ps.setLong(7, end.getPreco());
			ps.setLong(8, end.getFornecedorCnpj());
			ps.setLong(9, end.getId());

            // Executa o comando SQL
            retorno = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            con.fecharConexao();
        }

        return (retorno == 0 ? false : true); // (retorno == 0 ? false : true) // IF Ternário (Operador Condicional Ternário)
    }

	public boolean removerKart(Karts end) {
		String SQL = "DELETE FROM karts WHERE id = ?";

        Conexao con = Conexao.getInstancia();
        Connection conBD = con.conectar();

        int retorno = 0;

        try {
            PreparedStatement ps = conBD.prepareStatement(SQL);

            ps.setLong(1, end.getId());

            retorno = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            con.fecharConexao();
        }

        return (retorno == 0 ? false : true);
	}

	public Karts buscarKartPeloId(int id) {
		String SQL = "SELECT FROM karts WHERE id = ?";

        Conexao con = Conexao.getInstancia();
        Connection conBD = con.conectar();

        Karts end = new Karts();
        try {
            PreparedStatement ps = conBD.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            ps.setLong(1, end.getId());

            while (rs.next()) {
            	end.setId(rs.getLong("id"));
                end.setCor(rs.getString("cor"));
                end.setMarca(rs.getString("marca"));
                end.setModelo(rs.getString("modelo"));
                end.setAno(rs.getLong("ano"));
                end.setQuantidade(rs.getLong("quantidade"));
                end.setDataEntrada(rs.getDate("data_entrada"));
                end.setPreco(rs.getLong("preco"));
                end.setFornecedorCnpj(rs.getLong("fornecedor_cnpj"));
            }

            return end;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            con.fecharConexao();
        }

        return end;
	}
	
}
