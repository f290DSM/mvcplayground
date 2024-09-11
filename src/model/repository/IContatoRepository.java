package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.ContatoVO;

public interface IContatoRepository {
    void salvar(ContatoVO contato) throws SQLException;

    void atualizar(ContatoVO contato);

    void excluir(Integer id);

    List<ContatoVO> buscarTodos();

    ContatoVO buscarPorEmail(String email);
}
