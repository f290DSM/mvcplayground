import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import model.ContatoVO;
import model.dao.ContatoDAOImpl;
import model.dao.IContatoDAO;
import model.factory.ConexaoFactory;
import model.repository.ContatoEmMemoriaRespository;
import model.repository.ContatoMySQLRepository;
import model.repository.IContatoRepository;
import model.service.ContatoService;

public class Main {

    public static void main(String[] args) throws SQLException {

        Connection conexao = ConexaoFactory.getConexao();
        IContatoDAO dao = new ContatoDAOImpl(conexao);
        IContatoRepository repository = new ContatoMySQLRepository(dao);

        // TODO: Criar instancia do repositorio em memoria

        // TODO: Substituir o repositorio em banco de bados pelo repositorio em memoria
        ContatoService service = new ContatoService(repository);

        //TODO: Inclua os dados nos objetos que facilitem a identificacao dos mesmo nos //TODOS abaixo
        var c1 = new ContatoVO()
                .setNome("?")
                .setEmail("?")
                .setTelefone("?");

        var c2 = new ContatoVO()
                .setNome("?")
                .setEmail("?")
                .setTelefone("?");

        var c3 = new ContatoVO()
                .setNome("?")
                .setEmail("?")
                .setTelefone("?");

        //TODO: Salvar os 3 contatos em memoria

        // Exibir todos os contatos
        List<ContatoVO> contatos = service.buscarTodos();
        contatos.forEach(c -> System.out.println(c));

        //TODO: Buscar o terceiro contato  por e-mail e exibir todos os contatos

        //TODO: Removr o segundo contato e exibir todos

        //TODO: COmplete os os A-FAZER do ContatoDAOImpl 
        
        //TODO: Substitua o repositorio em memoria pelo repositorio em banco de dados

        //TODO: Apague os registros da tabela fatec.contatos e refaça todos os A-FAZERES utilizando banco de dados.

    }
}