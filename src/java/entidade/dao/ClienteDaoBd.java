package entidade.dao;

import entidade.Cliente;
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
public class ClienteDaoBd implements ClienteDao {

    @Override
    public void inserir(Cliente m) {
        try {
            Connection conexao = ConnectionFactory.getConnection();

            String sql = "INSERT INTO cliente(nome,cpf,email,endereco,telefone) VALUES (?,?,?,?,?)";

            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, m.getNome());
            comando.setString(2, m.getCpf());
            comando.setString(3, m.getEmail());
            comando.setString(4, m.getEndereco());
            comando.setString(5, m.getTelefone());

            comando.executeUpdate();

            //Passo 5: fechar conexao
            comando.close();
            conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void deletar(int codigo) {
        try {
            Connection conexao = ConnectionFactory.getConnection();

            String sql = "DELETE FROM cliente WHERE codigo=?";

            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, codigo);

            comando.executeUpdate();

            //Passo 5: fechar conexao
            comando.close();
            conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void atualizar(int codigo,Cliente m) {
        try {
            Connection conexao = ConnectionFactory.getConnection();
            
            System.out.println(codigo + " " + m.getNome() + " " + m.getCpf() + " " + m.getEmail() + " " + m.getEndereco() + " " + m.getTelefone());

            String sql = "UPDATE cliente SET nome=?, "
                    + "cpf=?, email=?, endereco=?, telefone=? "
                    + "WHERE codigo=?";

            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, m.getNome());
            comando.setString(2, m.getCpf());
            comando.setString(3, m.getEmail());
            comando.setString(4, m.getEndereco());
            comando.setString(5, m.getTelefone());
            comando.setInt(6, m.getCodigo());
                       
            
            comando.executeUpdate();

            //Passo 5: fechar conexao
            comando.close();
            conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Cliente> listar() {
        try {
            Connection conexao = ConnectionFactory.getConnection();

            //Passo 3 e 4: Comando
            String sql = "SELECT * FROM cliente";

            List<Cliente> listaClientes = new ArrayList<>();

            PreparedStatement comando = conexao.prepareStatement(sql);
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                int codigo = resultado.getInt("codigo");
                String nome = resultado.getString("nome");                
                String cpf = resultado.getString("cpf");
                String email = resultado.getString("email");
                String endereco = resultado.getString("endereco");
                String telefone = resultado.getString("telefone");
                Cliente m = new Cliente(codigo, nome, cpf, email, endereco, telefone);
                listaClientes.add(m);

            }

            //Passo 5: fechar conexao
            comando.close();
            conexao.close();

            return listaClientes;

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Cliente buscarPorId(int codigo) {
        try {
            Connection conexao = ConnectionFactory.getConnection();

            //Passo 3 e 4: Comando
            String sql = "SELECT * FROM cliente WHERE codigo=?";

            Cliente cliente = null;

            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, codigo);

            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                codigo = resultado.getInt("codigo");
                String nome = resultado.getString("nome");                
                String cpf = resultado.getString("cpf");
                String email = resultado.getString("email");
                String endereco = resultado.getString("endereco");
                String telefone = resultado.getString("telefone");
                cliente = new Cliente(codigo, nome, cpf, email, endereco, telefone);
            }

            //Passo 5: fechar conexao
            comando.close();
            conexao.close();

            return cliente;

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }




 
//    @Override
//    public Cliente buscarPorId(int id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

  


}
