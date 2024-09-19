package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.ContatoVO;
import model.dao.IContatoDAO;

public class ContatoMySQLRepository implements IContatoRepository {

    private final IContatoDAO dao;

    public ContatoMySQLRepository(IContatoDAO dao) {
        this.dao = dao;
    }

    @Override
    public void salvar(ContatoVO contato) throws SQLException {
        dao.salvar(contato);
    }

    @Override
    public void atualizar(ContatoVO contato) {
        dao.atualizar(contato);
    }

    @Override
    public void excluir(Integer id) {
        dao.excluir(id);
    }

    @Override
    public List<ContatoVO> buscarTodos() {
       return dao.buscarTodos();
    }

    @Override
    public ContatoVO buscarPorEmail(String email) {
        return dao.buscarPorEmail(email);
    }

    public void atualizarTabelas() {
        dao.atualizarTabelas();
    }
    
}
