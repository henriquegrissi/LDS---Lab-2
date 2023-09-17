package lds_lab2.lab2_gestao_automoveis.model;

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
    private Long id;
    private String tipoAgente; //ajustar tipo dps

    public String getTipoAgente() {
        return tipoAgente;
    }

    public void setTipoAgente(String profissao) {
        this.tipoAgente = profissao;
    }    
}
