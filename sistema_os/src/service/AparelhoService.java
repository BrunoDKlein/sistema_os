package service;

import entity.Aparelho;
import java.util.List;
import repository.AparelhoRepository;

public class AparelhoService {

    AparelhoRepository aparelhoRepository = new AparelhoRepository();

    public Aparelho salvarAparelho(Aparelho aparelho) {
        if (aparelho.getModelo().equals("")) {
            throw new NullPointerException("Descreva o modelo do aparelho para salvar");

        }
        return aparelhoRepository.salvarAparelho(aparelho);
    }

    public List<Aparelho> buscarAparelhosPorCliente(int id_Cliente) {

        return aparelhoRepository.buscarAparelhosPorCliente(id_Cliente);

    }

    public Aparelho editarAparelho(Aparelho aparelho) {
        return aparelhoRepository.editarAparelho(aparelho);//To change body of generated methods, choose Tools | Templates.
    }

    public Aparelho buscarAparelhoPorId(int id_aparelho) {
        return aparelhoRepository.editarAparelhoPorId(id_aparelho);
    }

    public List<Aparelho> buscarTodosAparelhos() {
        return aparelhoRepository.buscarTodosAparelhos();
    }

    public List<Aparelho> buscarAparelhoPorMarca(String marca) {
        return aparelhoRepository.buscarAparelhoPorMarca(marca);
    }
    }
 