package entidade.dao;

import entidade.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lhries
 */
public class UsuarioDaoBd implements UsuarioDao {

    @Override
    public void inserir(Usuario u) {
        try {
            Connection conexao = ConnectionFactory.getConnection();

            String sql = "INSERT INTO usuario(nome,login,cpf,email,senha,telefone) VALUES (?,?,?,?,?,?)";

            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, u.getNome());
            comando.setString(2, u.getLogin());
            comando.setString(3, u.getCpf());
            comando.setString(4, u.getEmail());
            comando.setString(5, u.getSenha());
            comando.setString(6, u.getTelefone());

            comando.executeUpdate();

            //Passo 5: fechar conexao
            comando.close();
            conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void deletar(int codigo) {
        try {
            Connection conexao = ConnectionFactory.getConnection();

            String sql = "DELETE FROM usuario WHERE codigo=?";

            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, codigo);

            comando.executeUpdate();

            //Passo 5: fechar conexao
            comando.close();
            conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void atualizar(int codigo,Usuario u) {
        try {
            Connection conexao = ConnectionFactory.getConnection();
            
            //System.out.println(codigo + " " + m.getNome() + " " + m.getCpf() + " " + m.getEmail() + " " + m.getEndereco() + " " + m.getTelefone());

            String sql = "UPDATE usuario SET nome=?, "
                    + "login=?, cpf=?, email=?, senha=?, telefone=? "
                    + "WHERE codigo=?";

            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, u.getNome());
            comando.setString(2, u.getLogin());
            comando.setString(3, u.getCpf());
            comando.setString(4, u.getEmail());
            comando.setString(5, u.getSenha());
            comando.setString(6, u.getTelefone());
            comando.setInt(7, u.getCodigo());
                       
            
            comando.executeUpdate();

            //Passo 5: fechar conexao
            comando.close();
            conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Usuario> listar() {
        try {
            Connection conexao = ConnectionFactory.getConnection();

            //Passo 3 e 4: Comando
            String sql = "SELECT * FROM usuario";

            List<Usuario> listaUsuarios = new ArrayList<>();

            PreparedStatement comando = conexao.prepareStatement(sql);
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                int codigo = resultado.getInt("codigo");
                String nome = resultado.getString("nome");                
                String login = resultado.getString("login");
                String cpf = resultado.getString("cpf");
                String email = resultado.getString("email");
                String senha = resultado.getString("senha");
                String telefone = resultado.getString("telefone");
                Usuario u = new Usuario(codigo, nome, login, cpf, email, senha, telefone);
                listaUsuarios.add(u);

            }

            //Passo 5: fechar conexao
            comando.close();
            conexao.close();

            return listaUsuarios;

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Usuario buscarPorId(int codigo) {
        try {
            Connection conexao = ConnectionFactory.getConnection();

            //Passo 3 e 4: Comando
            String sql = "SELECT * FROM usuario WHERE codigo=?";

            Usuario usuario = null;

            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, codigo);

            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                //int codigo = resultado.getInt("codigo");
                String nome = resultado.getString("nome");                
                String login = resultado.getString("login");
                String cpf = resultado.getString("cpf");
                String email = resultado.getString("email");
                String senha = resultado.getString("senha");
                String telefone = resultado.getString("telefone");
                usuario = new Usuario(codigo, nome, login, cpf, email, senha, telefone);
                //produto = new Usuario(codigo, nome, preco, quantidade, fabricante, website, telfabricante,nomevendedor,telvendedor);
            }

            //Passo 5: fechar conexao
            comando.close();
            conexao.close();

            return usuario;

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }




 
//    @Override
//    public Cliente buscarPorId(int id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

  


}
