package service;

// * @author Victor
import entity.Pagamento;
import java.util.List;
import repository.PagamentoRepository;

public class PagamentoService {

    PagamentoRepository pagamentoRepository = new PagamentoRepository();

    public Pagamento salvarPagamento(Pagamento pagamento) {
        return pagamentoRepository.salvarPagamento(pagamento);
    }

    public List<Pagamento> buscarPagamentos() {
        return pagamentoRepository.buscarPagamentos();
    }

}
