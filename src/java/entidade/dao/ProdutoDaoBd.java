package entidade.dao;

import entidade.Produto;
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
public class ProdutoDaoBd implements ProdutoDao {

    @Override
    public void inserir(Produto p) {
        try {
            Connection conexao = ConnectionFactory.getConnection();

            String sql = "INSERT INTO produto(nome,preco,quantidade,fabricante,website,telfabricante,nomevendedor,telvendedor) VALUES (?,?,?,?,?,?,?,?)";

            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, p.getNome());
            comando.setString(2, p.getPreco());
            comando.setString(3, p.getQuantidade());
            comando.setString(4, p.getFabricante());
            comando.setString(5, p.getWebsite());
            comando.setString(6, p.getTelfabricante());
            comando.setString(7, p.getNomevendedor());
            comando.setString(8, p.getTelvendedor());
            

            comando.executeUpdate();

            //Passo 5: fechar conexao
            comando.close();
            conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void deletar(int codigo) {
        try {
            Connection conexao = ConnectionFactory.getConnection();

            String sql = "DELETE FROM produto WHERE codigo=?";

            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, codigo);

            comando.executeUpdate();

            //Passo 5: fechar conexao
            comando.close();
            conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void atualizar(int codigo,Produto p) {
        try {
            Connection conexao = ConnectionFactory.getConnection();
            
            //System.out.println(codigo + " " + m.getNome() + " " + m.getCpf() + " " + m.getEmail() + " " + m.getEndereco() + " " + m.getTelefone());

            String sql = "UPDATE produto SET nome=?, "
                    + "preco=?, quantidade=?, fabricante=?, website=?, telfabricante=?, nomevendedor=?, telvendedor=? "
                    + "WHERE codigo=?";

            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, p.getNome());
            comando.setString(2, p.getPreco());
            comando.setString(3, p.getQuantidade());
            comando.setString(4, p.getFabricante());
            comando.setString(5, p.getWebsite());
            comando.setString(6, p.getTelfabricante());
            comando.setString(7, p.getNomevendedor());
            comando.setString(8, p.getTelvendedor());
            comando.setInt(9, p.getCodigo());
                       
            
            comando.executeUpdate();

            //Passo 5: fechar conexao
            comando.close();
            conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Produto> listar() {
        try {
            Connection conexao = ConnectionFactory.getConnection();

            //Passo 3 e 4: Comando
            String sql = "SELECT * FROM produto";

            List<Produto> listaProdutos = new ArrayList<>();

            PreparedStatement comando = conexao.prepareStatement(sql);
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                int codigo = resultado.getInt("codigo");
                String nome = resultado.getString("nome");                
                String preco = resultado.getString("preco");
                String quantidade = resultado.getString("quantidade");
                String fabricante = resultado.getString("fabricante");
                String website = resultado.getString("website");
                String telfabricante = resultado.getString("telfabricante");
                String nomevendedor = resultado.getString("nomevendedor");
                String telvendedor = resultado.getString("telvendedor");
                Produto p = new Produto(codigo, nome, preco, quantidade, fabricante, website, telfabricante,nomevendedor,telvendedor);
                listaProdutos.add(p);

            }

            //Passo 5: fechar conexao
            comando.close();
            conexao.close();

            return listaProdutos;

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Produto buscarPorId(int codigo) {
        try {
            Connection conexao = ConnectionFactory.getConnection();

            //Passo 3 e 4: Comando
            String sql = "SELECT * FROM produto WHERE codigo=?";

            Produto produto = null;

            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, codigo);

            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                codigo = resultado.getInt("codigo");
                String nome = resultado.getString("nome");                
                String preco = resultado.getString("preco");
                String quantidade = resultado.getString("quantidade");
                String fabricante = resultado.getString("fabricante");
                String website = resultado.getString("website");
                String telfabricante = resultado.getString("telfabricante");
                String nomevendedor = resultado.getString("nomevendedor");
                String telvendedor = resultado.getString("telvendedor");
                produto = new Produto(codigo, nome, preco, quantidade, fabricante, website, telfabricante,nomevendedor,telvendedor);
            }

            //Passo 5: fechar conexao
            comando.close();
            conexao.close();

            return produto;

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }




 
//    @Override
//    public Cliente buscarPorId(int id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

  


}
