package entidade.dao;

import entidade.Cliente;
import java.util.List;

public interface ClienteDao {
    public void inserir(Cliente m);
    public void deletar(Cliente m);
    public void atualizar(Cliente m);
    public List<Cliente> listar();
    public Cliente buscarPorId(int id);
    
    //public List<Motor> listarPorNome(String nome);
    //public List<Motor> listarPorUso(String uso);
    
}
