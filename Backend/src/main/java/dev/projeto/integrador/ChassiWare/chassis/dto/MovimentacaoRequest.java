package dev.projeto.integrador.ChassiWare.chassis.dto;

public class MovimentacaoRequest {

    private String codigoChassi;
    private Integer quantidade;
    private String tipoMovimentacao;

    public String getCodigoChassi() {
        return codigoChassi;
    }

    public void setCodigoChassi(String codigoChassi) {
        this.codigoChassi = codigoChassi;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(String tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }
}
