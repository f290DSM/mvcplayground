package model.dao;

import java.sql.SQLException;
import java.util.List;

import model.ContatoVO;

public interface IContatoDAO {
    void salvar(ContatoVO contato) throws SQLException;

    void atualizar(ContatoVO contato);

    void excluir(Integer id);

    List<ContatoVO> buscarTodos();

    ContatoVO buscarPorEmail(String email);

    void atualizarTabelas();
}
