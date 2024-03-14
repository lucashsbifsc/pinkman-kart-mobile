package controle;

import java.util.ArrayList;

import modelo.Vendas;

public interface IVendasDAO {
	public int inserirVenda(Vendas end);

    public ArrayList<Vendas> listarVendas();

    public boolean atualizarVenda(Vendas end);

    public boolean removerVenda(Vendas end);

    public Vendas buscarVendaPeloId(int id);
}
