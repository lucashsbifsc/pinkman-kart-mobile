package com.ifscgaspar.sistemapinkmankart.modelo;

import java.sql.Date;

public class Funcionario {
    private int cpf;
    private String nomeCompleto;
    private Date dataNascimento;
    private String cargo;

    public int getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = this.cpf;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = this.nomeCompleto;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = this.dataNascimento;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = this.cargo;
    }
}
