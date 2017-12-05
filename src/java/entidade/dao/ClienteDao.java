package entidade.dao;

import entidade.Cliente;
import java.util.List;

public interface ClienteDao {
    public void inserir(Cliente m);
    public void deletar(int codigo);
    public void atualizar(Cliente m);
    public List<Cliente> listar();
    public Cliente buscarPorId(int codigo);
    
    //public List<Motor> listarPorNome(String nome);
    //public List<Motor> listarPorUso(String uso);
    
}
