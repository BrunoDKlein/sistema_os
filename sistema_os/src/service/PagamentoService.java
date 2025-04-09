package service;

// * @author Victor
import entity.Pagamento;
import repository.PagamentoRepository;

public class PagamentoService {

    PagamentoRepository pagamentoRepository = new PagamentoRepository();
    
    public Pagamento salvarPagamento(Pagamento pagamento) {
        return pagamentoRepository.salvarPagamento(pagamento);
    }
}
