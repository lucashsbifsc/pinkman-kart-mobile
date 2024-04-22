package com.ifscgaspar.sistemapinkmankart.controle;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ifscgaspar.sistemapinkmankart.modelo.Vendas;

public class VendasDAO implements IVendasDAO {
	private static VendasDAO instancia;

    private VendasDAO() {}

    public static VendasDAO getInstance() {
        if (instancia == null) {
            instancia = new VendasDAO();
        }
        return instancia;
    }
	
	public int inserirVenda(Vendas end) {
		String SQL = "INSERT INTO vendas (valor_total, data_venda, funcionario_cpf) VALUES (?, ?, ?, ?)";

		Conexao con = Conexao.getInstancia();
		Connection conBD = con.conectar();

		int chavePrimariaGerada = Integer.MIN_VALUE;

		try {
			PreparedStatement ps = conBD.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

			ps.setLong(1, end.getValorTotal());
			ps.setDate(2, end.getDataVenda());
			ps.setLong(3, end.getFuncionarioCpf());

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

	public ArrayList<Vendas> listarVendas() {
		// ArrayList para armazenar os resultados do SELECT
        ArrayList<Vendas> vendas = new ArrayList<Vendas>();

        String SQL = "SELECT * FROM vendas";

        Conexao con = Conexao.getInstancia();
        Connection conBD = con.conectar();

        try {
            PreparedStatement ps = conBD.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                // Cria objeto Java
                Vendas end = new Vendas();

                // Pega os valores de cada coluna do registro
                long id = rs.getLong("id");
                Long valorTotal = rs.getLong("valor_total");
                Date dataVenda = rs.getDate("data_venda");
                Long funcionarioCpf = rs.getLong("funcionario_cpf");

                // Seta os valores no objeto java
                end.setId(id);
                end.setValorTotal(valorTotal);
                end.setDataVenda(dataVenda);
                end.setFuncionarioCpf(funcionarioCpf);

                // Adiciona objeto no ArrayList
                vendas.add(end);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            con.fecharConexao();
        }

        return vendas;
	}

	public boolean atualizarVenda(Vendas end) {
		String SQL = "UPDATE vendas SET valor_total = ?, data_venda = ?, funcionario_cpf = ?  WHERE id = ?";

        Conexao con = Conexao.getInstancia();
        Connection conBD = con.conectar();

        // Define o retorno como 0 (falso)
        int retorno = 0;

        try {
            PreparedStatement ps = conBD.prepareStatement(SQL);

            ps.setLong(1, end.getValorTotal());
            ps.setDate(2, end.getDataVenda());
            ps.setLong(3, end.getFuncionarioCpf());
            ps.setLong(4, end.getId());

            // Executa o comando SQL
            retorno = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            con.fecharConexao();
        }

        return (retorno == 0 ? false : true); // (retorno == 0 ? false : true) // IF Ternário (Operador Condicional Ternário)
	}

	public boolean removerVenda(Vendas end) {
		String SQL = "DELETE FROM vendas WHERE id = ?";

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

	public Vendas buscarVendaPeloId(int id) {
		String SQL = "SELECT FROM vendas WHERE id = ?";

        Conexao con = Conexao.getInstancia();
        Connection conBD = con.conectar();

        Vendas end = new Vendas();
        try {
            PreparedStatement ps = conBD.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();

            ps.setLong(1, end.getId());

            while (rs.next()) {
                end.setId(rs.getLong("id"));
                end.setValorTotal(rs.getLong("valor_total"));
                end.setDataVenda(rs.getDate("data_venda"));
                end.setFuncionarioCpf(rs.getLong("funcionario_cpf"));
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
