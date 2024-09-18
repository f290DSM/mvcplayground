package model.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

import model.ContatoVO;
import model.repository.IContatoRepository;

public class ContatoService {

    private final IContatoRepository repository;

    public ContatoService(IContatoRepository repository) {
        this.repository = repository;
    }

    public void criar(ContatoVO contatoVO) {
        if (Objects.isNull(contatoVO)) throw new RuntimeException("O contato não deve ser nulo!");
        if (Objects.isNull(contatoVO.getNome()) || contatoVO.getNome().isEmpty()) throw new RuntimeException("O nome do contato é obrigatório!");
        if (Objects.isNull(contatoVO.getEmail()) || contatoVO.getEmail().isEmpty()) throw new RuntimeException("O e-mail do contato é obrigatório!");

        try {
            repository.salvar(contatoVO);
        } catch (SQLException e) {
            System.out.println("Erro ao salvar novo contato. Erro: " + e.getLocalizedMessage());
        }
    }

    public List<ContatoVO> buscarTodos() {
        return repository.buscarTodos();
    }

    public void atualizar(ContatoVO contatoVO) {
        //TODO: Buscar contato existente por e-mail e lancar exceção caso o o contato não exista

        //TODO: Efetivar a alteração de dados e persistir em banco de dados
    }

    public void remover(Integer id) {
        //TODO: Remover contato
    }
    
}
