package com.ifscgaspar.sistemapinkmankart.controle;

import java.util.ArrayList;

import com.ifscgaspar.sistemapinkmankart.modelo.Karts;

public interface IKartsDAO {
	public int inserirKart(Karts end);

    public ArrayList<Karts> listarKarts();

    public boolean atualizarKart(Karts end);

    public boolean removerKart(Karts end);

    public Karts buscarKartPeloId(int id);
}
