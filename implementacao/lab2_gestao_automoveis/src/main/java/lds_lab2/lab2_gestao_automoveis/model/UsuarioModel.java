package lds_lab2.lab2_gestao_automoveis.model;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class UsuarioModel {
    private String nome;
    private String endereco;
    private String login;
    private String senha;

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
