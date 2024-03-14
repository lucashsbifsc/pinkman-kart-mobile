package com.ifscgaspar.sistemapinkmankart.modelo;

import java.sql.Date;

public class Karts {
    private long id;
    private String cor;
    private String modelo;
    private String marca;
    private Long ano;
    private Long quantidade;
    private Date dataEntrada;
    private Long preco;
    private Long fornecedorCnpj;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCor() {
        return cor;
    }
    
    public void setCor(String cor) {
        this.cor = cor;
    }
    
    public String getModelo() {
    	return modelo;
    }
    
    public void setModelo(String modelo) {
    	this.modelo = modelo;
    }
    
    public String getMarca() {
    	return marca;
    }
    
    public void setMarca(String marca) {
    	this.marca = marca;
    }
    
    public Long getAno() {
    	return ano;
    }
    
    public void setAno(Long ano) {
    	this.ano = ano;
    }
    
    public Long getQuantidade() {
    	return quantidade;
    }
    
    public void setQuantidade(Long quantidade) {
    	this.quantidade = quantidade;
    }
    
    public Date getDataEntrada() {
    	return dataEntrada;
    }
    
    public void setDataEntrada(Date dataEntrada) {
    	this.dataEntrada = dataEntrada;
    }
    
    public Long getPreco() {
    	return preco;
    }
    
    public void setPreco(Long preco) {
    	this.preco = preco;
    }
    
    public Long getFornecedorCnpj() {
    	return fornecedorCnpj;
    }
    
    public void setFornecedorCnpj(Long fornecedorCnpj) {
    	this.fornecedorCnpj = fornecedorCnpj;
    }
}
