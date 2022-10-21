package br.com.dolarhoje.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DolarModel {
    private Float cotacaoCompra;
    private Float cotacaoVenda;
    private String dataHoraCotacao;
}
