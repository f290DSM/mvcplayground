import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.ContatoVO;
import model.dao.ContatoDAOImpl;
import model.dao.IContatoDAO;
import model.factory.ConexaoFactory;
import model.repository.ContatoMySQLRepository;
import model.repository.IContatoRepository;
import model.service.ContatoService;

public class Main {

    public static void main(String[] args) throws SQLException {

        Connection conexao = ConexaoFactory.getConexao();
        IContatoDAO dao = new ContatoDAOImpl(conexao);
        IContatoRepository repository = new ContatoMySQLRepository(dao);
        ContatoService service = new ContatoService(repository);

        var c1 = new ContatoVO()
                .setNome("Alvin G S Silva")
                // .setEmail("erika@me.com")
                .setTelefone("19 98888-0002");

        service.criar(c1);
        List<ContatoVO> contatos = service.buscarTodos();
        contatos.forEach(c -> System.out.println(c));

    }
}