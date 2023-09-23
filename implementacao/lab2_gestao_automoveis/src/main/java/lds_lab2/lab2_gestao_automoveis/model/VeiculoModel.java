package lds_lab2.lab2_gestao_automoveis.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "VEICULO")
public class VeiculoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String placa;
    private String marca;
    private String modelo;
    private String ano;
    private Boolean alugado;

    public String getMarca(){
        return this.marca;
    }

    public void setMarca(String marca){
        this.marca = marca;
    }

    public String getPlaca(){
        return this.placa;
    }

    public void setPlaca(String placa){
        this.placa = placa;
    }

    public String getModelo(){
        return this.modelo;
    }

    public void setModelo(String modelo){
        this.modelo = modelo;
    }

    public String getAno(){
        return this.ano;
    }

    public void setAno(String ano){
        this.ano = ano;
    }

    public Boolean getAlugado(){
        return this.alugado;
    }
    
    public void setAlugado(Boolean alugado){
        this.alugado = alugado;
    }
}
