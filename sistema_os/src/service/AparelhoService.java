package service;

import entity.Aparelho;
import java.util.List;
import repository.AparelhoRepository;

public class AparelhoService {

    AparelhoRepository aparelhoRepository = new AparelhoRepository();

    public Aparelho salvarAparelho(Aparelho aparelho) {
        if (aparelho.getModelo().equals("")){
         throw new NullPointerException("Descreva o modelo do aparelho para salvar");
         
        }
            return aparelhoRepository.salvarAparelho(aparelho);
    }

    public List<Aparelho> buscarAparelhosPorCliente(int id_Cliente) {

        return aparelhoRepository.buscarAparelhosPorCliente(id_Cliente);

    }
}
