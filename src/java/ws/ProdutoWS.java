/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import entidade.Produto;
import entidade.dao.ProdutoDaoBd;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;


/**
 * REST Web Service
 *
 * @author 630610194
 */
@Path("/produtos")
public class ProdutoWS {

    @Context
    private UriInfo context;
    static List<Produto> listaProdutos = new ArrayList<>();

    
    private ProdutoDaoBd produtoDao;
    private int codigo;
    /**
     * Creates a new instance of MotorWS
     */
    public ProdutoWS() {
        produtoDao = new ProdutoDaoBd();
    }

    /**
     * Retrieves representation of an instance of ws.MotorWS
     * @return an instance of entidade.Motor
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Produto> getProduto() {
        //return listaClientes;
        //System.out.println("testeListar");
        return produtoDao.listar();        
    }

    /**
     * PUT method for updating or creating an instance of MotorWS
     * @param content representation for the resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void inserirProduto(Produto produto) {
        produtoDao.inserir(produto);
    }
    
    @PUT
    @Path("{codigo}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void editarProduto(@PathParam("codigo") int codigo, Produto produto) {
        produto.setCodigo(codigo);
        produtoDao.atualizar(codigo,produto);
    }
    
    @DELETE
    @Path("/{codigo}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void removerProduto(@PathParam("codigo") int codigo) { 
        produtoDao.deletar(codigo);
    }
    
    @GET
    @Path("/{codigo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Produto buscarPorCodigo(@PathParam("codigo") int codigo) {
        return produtoDao.buscarPorId(codigo);
    }
    
}
