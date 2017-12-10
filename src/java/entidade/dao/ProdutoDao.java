package entidade.dao;

import entidade.Produto;
import java.util.List;

public interface ProdutoDao {
    public void inserir(Produto p);
    public void deletar(int codigo);
    public void atualizar(int codigo,Produto p);
    public List<Produto> listar();
    public Produto buscarPorId(int codigo);
    
    //public List<Motor> listarPorNome(String nome);
    //public List<Motor> listarPorUso(String uso);
    
}
