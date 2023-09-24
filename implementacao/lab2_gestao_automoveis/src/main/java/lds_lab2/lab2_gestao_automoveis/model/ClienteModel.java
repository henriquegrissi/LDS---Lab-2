package lds_lab2.lab2_gestao_automoveis.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CLIENTE")
public class ClienteModel extends UsuarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String profissao;
    private String entidadeEmpregaticia;

    @Column(unique = true)
    private String cpf;
    private String rg;

    public String getProfissao() {
        return profissao;
    }
    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getEntidadeEmpregaticia() {
        return entidadeEmpregaticia;
    }
    public void setEntidadeEmpregaticia(String entidadeEmpregaticia) {
        this.entidadeEmpregaticia = entidadeEmpregaticia;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }
    public void setRg(String rg) {
        this.rg = rg;
    }
}
