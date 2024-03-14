package com.ifscgaspar.sistemapinkmankart.modelo;

import java.sql.Date;

public class Vendas {
	private long id;
	private Long valorTotal;
	private Date dataVenda;
	private Long funcionarioCpf;
	
	public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Long valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Date getDataVenda() {
    	return dataVenda;
    }
    
    public void setDataVenda(Date dataVenda) {
    	this.dataVenda = dataVenda;
    }
    
    public Long getFuncionarioCpf() {
    	return funcionarioCpf;
    }
    
    public void setFuncionarioCpf(Long funcionarioCpf) {
    	this.funcionarioCpf = funcionarioCpf;
    }
}
