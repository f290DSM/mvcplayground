package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.ContatoVO;

public class ContatoDAOImpl implements IContatoDAO {

    private final Connection connection;
    private Logger logger;

    public ContatoDAOImpl(Connection connection) {
        this.connection = connection;
        this.logger = Logger.getLogger(ContatoDAOImpl.class.getName());
    }

    @Override
    public void salvar(ContatoVO contato) throws SQLException {
        String query = "INSERT INTO fatec.contatos (nome, email, telefone) VALUES ('%s', '%s', '%s')";
        try (Statement statement = connection.createStatement()) {
            statement.execute(String.format(query, contato.getNome(), contato.getEmail(), contato.getTelefone()));
            logger.info("Contato persistido com sucesso.");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Falha ao salvar contato.", e);
            throw e;
        }
    }

    @Override
    public void atualizar(ContatoVO contato) {
        // TODO: Atualizar contato
    }

    @Override
    public void excluir(Integer id) {
        //TODO: Excluir contato por id
    }

    @Override
    public List<ContatoVO> buscarTodos() {
        String query = "SELECT ID, NOME, EMAIL, TELEFONE FROM fatec.contatos;";
        List<ContatoVO> contatos = new ArrayList<>();

        try (Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query)) {
                while (resultSet.next()) {
                    ContatoVO contato = new ContatoVO(
                        resultSet.getInt("id"), 
                        resultSet.getString("nome"), 
                        resultSet.getString("email"), 
                        resultSet.getString("telefone"));
                    contatos.add(contato);
                }
                logger.info("Consulta de contatos realizada com sucesso");
                return contatos;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Falha na consulta de contatos.", e);
        }
        return contatos;
    }

    @Override
    public ContatoVO buscarPorEmail(String email) {
        //TODO: Criar metodo de busca de contato por e-mail
        return null;
    }

}
