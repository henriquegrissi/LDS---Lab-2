package lds_lab2.lab2_gestao_automoveis.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "AGENTE")
public class AgenteModel extends UsuarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String cnpj;
    private String tipoAgente; //ajustar tipo dps

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTipoAgente() {
        return tipoAgente;
    }

    public void setTipoAgente(String profissao) {
        this.tipoAgente = profissao;
    }    
}
