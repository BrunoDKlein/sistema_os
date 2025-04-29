package entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PagamentoDTO {

    private int id;
    private int id_ordemServico;
    private LocalDate data;
    private double valor;
    private String metodoPagamento;

    public PagamentoDTO(int id, int id_ordemServico, LocalDate data, double valor, String metodoPagamento) {
        this.id = id;
        this.id_ordemServico = id_ordemServico;
        this.data = data;
        this.valor = valor;
        this.metodoPagamento = metodoPagamento;
    }

    public List<PagamentoDTO> converteParaDTO(List<Pagamento> listaPagamentos) {

        List<PagamentoDTO> pagamentosDTO = new ArrayList<>();

        for (Pagamento p : listaPagamentos) {
            pagamentosDTO.add(new PagamentoDTO(p.getId(), p.getOrdemServico().getId(), p.getData(), p.getValor(), p.getMetodoPagamento()));
        }
        return pagamentosDTO;
    }
}
