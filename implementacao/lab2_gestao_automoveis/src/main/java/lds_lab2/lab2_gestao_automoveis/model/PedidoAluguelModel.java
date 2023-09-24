package lds_lab2.lab2_gestao_automoveis.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lds_lab2.lab2_gestao_automoveis.enums.StatusPedido;

@Entity
@Table(name = "PEDIDO_ALUGUEL")
public class PedidoAluguelModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    private ClienteModel cliente;

    @ManyToOne
    @JoinColumn(name = "id_veiculo", referencedColumnName = "id")
    private VeiculoModel veiculo;

    @Enumerated(EnumType.STRING)
    private StatusPedido statusPedido;
    private int quantidadeDeDias;
    private double valorTotal;
    private int nota;
    private String comentariosAvaliacao;


    //#region GETTERS E SETTES
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public ClienteModel getCliente() {
        return cliente;
    }
    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }

    public VeiculoModel getVeiculo() {
        return veiculo;
    }
    public void setVeiculo(VeiculoModel veiculo) {
        this.veiculo = veiculo;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }
    public void setStatusPedido(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }

    public int getQuantidadeDeDias() {
        return quantidadeDeDias;
    }
    public void setQuantidadeDeDias(int quantidadeDeDias) {
        this.quantidadeDeDias = quantidadeDeDias;
    }

    public double getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getNota() {
        return nota;
    }
    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getComentariosAvaliacao() {
        return comentariosAvaliacao;
    }
    public void setComentariosAvaliacao(String comentariosAvaliacao) {
        this.comentariosAvaliacao = comentariosAvaliacao;
    }
    //#endregion

    public double calcularValorTotal(){
        return this.veiculo.getValorAluguel() * this.quantidadeDeDias;
    }
}
