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

    private static IContatoRepository repository;

    public static void main(String[] args) throws SQLException {

        config(args);

        // TODO: Criar instancia do repositorio em memoria

        // TODO: Substituir o repositorio em banco de bados pelo repositorio em memoria
        ContatoService service = new ContatoService(repository);

        // TODO: Inclua os dados nos objetos que facilitem a identificacao dos mesmo nos A-FAZERES abaixo
        var c1 = new ContatoVO()
                .setNome("X")
                .setEmail("X")
                .setTelefone("?");

        var c2 = new ContatoVO()
                .setNome("A")
                .setEmail("A")
                .setTelefone("?");

        var c3 = new ContatoVO()
                .setNome("B")
                .setEmail("B")
                .setTelefone("?");

        // TODO: Salvar os 3 contatos em memoria

        // Exibir todos os contatos
        List<ContatoVO> contatos = service.buscarTodos();
        contatos.forEach(c -> System.out.println(c));

        // TODO: Buscar o terceiro contato por e-mail e exibi-o

        // TODO: Remover o segundo contato e exibir todos

        // TODO: Complete os os A-FAZERES do ContatoDAOImpl

        // TODO: Substitua o repositorio em memoria pelo repositorio em banco de dados

        // TODO: Apague os registros da tabela fatec.contatos e execute a aplicação utilizando banco de dados.

    }

    private static void config(String[] args) throws SQLException {
        atualizarTabelas();

        if (args.length == 0) {
            repository = new ContatoEmMemoriaRespository();
            return;
        }

        switch (args[0]) {
            case "-banco":
                Connection conexao = ConexaoFactory.getConexao();
                IContatoDAO dao = new ContatoDAOImpl(conexao);
                repository = new ContatoMySQLRepository(dao);
                break;
            case "-memoria":
                repository = new ContatoEmMemoriaRespository();
                break;
            default:
                repository = new ContatoEmMemoriaRespository();
                break;
        }
    }

    private static void atualizarTabelas() throws SQLException {
        Connection conexao = ConexaoFactory.getConexao();
        IContatoDAO dao = new ContatoDAOImpl(conexao);
        ContatoMySQLRepository repository = new ContatoMySQLRepository(dao);
        repository.atualizarTabelas();
    }
}