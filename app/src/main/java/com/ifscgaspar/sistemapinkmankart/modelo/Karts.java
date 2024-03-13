package com.ifscgaspar.sistemapinkmankart.modelo;

import java.sql.Date;

public class Karts {
    private Integer id;
    private String cor;
    private String modelo;
    private String marca;
    private int ano;
    private int quantidade;
    private Date data_entrada;
    private float preco;
    private int fornecedorCnpj;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCor() {
        return cor;
    }
    
    public void setCor(String cor) {
        this.cor = cor;
    }
}
