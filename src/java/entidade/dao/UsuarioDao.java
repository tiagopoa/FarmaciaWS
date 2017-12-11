package entidade.dao;

import entidade.Usuario;
import java.util.List;

public interface UsuarioDao {
    public void inserir(Usuario p);
    public void deletar(int codigo);
    public void atualizar(int codigo,Usuario u);
    public List<Usuario> listar();
    public Usuario buscarPorId(int codigo);
    
    //public List<Motor> listarPorNome(String nome);
    //public List<Motor> listarPorUso(String uso);
    
}
