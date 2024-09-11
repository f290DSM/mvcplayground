import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.ContatoVO;
import model.dao.ContatoDAOImpl;
import model.dao.IContatoDAO;
import model.factory.ConexaoFactory;

public class Main {

    public static void main(String[] args) throws SQLException {

        Connection conexao = ConexaoFactory.getConexao();
        IContatoDAO dao = new ContatoDAOImpl(conexao);

        var c1 = new ContatoVO()
                .setNome("Erika G S Silva")
                .setEmail("erika@me.com")
                .setTelefone("19 98888-0007");

        // dao.salvar(c1);
        List<ContatoVO> contatos = dao.buscarTodos();
        contatos.forEach(c -> System.out.println(c));

    }
}