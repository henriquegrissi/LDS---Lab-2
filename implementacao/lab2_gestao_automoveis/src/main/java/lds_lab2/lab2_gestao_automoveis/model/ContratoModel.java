package lds_lab2.lab2_gestao_automoveis.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lds_lab2.lab2_gestao_automoveis.enums.TipoContrato;

@Entity
@Table(name = "CONTRATO")
public class ContratoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private int id;

    @OneToOne
    @JoinColumn(name = "pedido_id", referencedColumnName = "id")
    private PedidoAluguelModel pedidoAluguel;

    @OneToOne
    @JoinColumn(name = "agente_proprietario_id", referencedColumnName = "id")
    private AgenteModel proprietarioAgente;

    @OneToOne
    @JoinColumn(name = "cliente_proprietario_id", referencedColumnName = "id")
    private ClienteModel proprietarioCliente;
    
    @Enumerated(EnumType.STRING)
    private TipoContrato tipoContrato;
    private double valor;

    //#region GETTERS E SETTER
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public PedidoAluguelModel getPedidoAluguel() {
        return pedidoAluguel;
    }
    public void setPedidoAluguel(PedidoAluguelModel pedidoAluguel) {
        this.pedidoAluguel = pedidoAluguel;
    }
    
    public AgenteModel getProprietarioAgente() {
        return proprietarioAgente;
    }
    public void setProprietarioAgente(AgenteModel proprietarioAgente) {
        this.proprietarioAgente = proprietarioAgente;
    }

    public ClienteModel getProprietarioCliente() {
        return proprietarioCliente;
    }
    public void setProprietarioCliente(ClienteModel proprietarioCliente) {
        this.proprietarioCliente = proprietarioCliente;
    }

    public TipoContrato getTipoContrato() {
        return tipoContrato;
    }
    public void setTipoContrato(TipoContrato tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    //#endregion

}
