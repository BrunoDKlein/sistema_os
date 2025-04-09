package service;

import entity.Aparelho;
import repository.AparelhoRepository;

public class AparelhoService {

    AparelhoRepository aparelhoRepository = new AparelhoRepository();

    public Aparelho salvarAparelho(Aparelho aparelho) {
        
        return aparelhoRepository.salvarAparelho(aparelho);
    }
}
