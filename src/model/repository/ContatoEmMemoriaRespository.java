package model.repository;

import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import model.ContatoVO;

public class ContatoEmMemoriaRespository implements IContatoRepository {

    private List<ContatoVO> contatos = new ArrayList<>();

    @Override
    public void salvar(ContatoVO contato) throws SQLException {
        contatos.add(contato);
    }

    @Override
    public void atualizar(ContatoVO contato) {
        contatos.stream()
                .filter(c -> c.getEmail().equals(contato.getEmail()))
                .findFirst()
                .ifPresent(c -> {
                    c.setEmail(contato.getEmail());
                    c.setNome(contato.getNome());
                    c.setTelefone(contato.getTelefone());
                });
    }

    @Override
    public void excluir(Integer id) {
        contatos.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .ifPresent(c -> contatos.remove(c));
    }

    @Override
    public List<ContatoVO> buscarTodos() {
        return contatos;
    }

    @Override
    public ContatoVO buscarPorEmail(String email) {
        return contatos.stream()
                .filter(c -> c.getEmail().equals(email))
                .findFirst()
                .orElse(null);

    }

}
