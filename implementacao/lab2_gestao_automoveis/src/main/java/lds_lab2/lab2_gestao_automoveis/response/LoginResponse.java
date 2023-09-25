package lds_lab2.lab2_gestao_automoveis.response;

import lds_lab2.lab2_gestao_automoveis.model.AgenteModel;
import lds_lab2.lab2_gestao_automoveis.model.ClienteModel;

public record LoginResponse(
    AgenteModel agente,
    ClienteModel cliente,
    String tipoCadastro){
}