/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import entidade.Cliente;
import entidade.dao.ClienteDaoBd;
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
@Path("clientes")
public class ClienteWS {

    @Context
    private UriInfo context;
    static List<Cliente> listaClientes = new ArrayList<>();

    
    private ClienteDaoBd clienteDao;
    private int codigo;
    /**
     * Creates a new instance of MotorWS
     */
    public ClienteWS() {
        clienteDao = new ClienteDaoBd();
    }

    /**
     * Retrieves representation of an instance of ws.MotorWS
     * @return an instance of entidade.Motor
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cliente> getCliente() {
        //return listaClientes;
        return clienteDao.listar();        
    }

    /**
     * PUT method for updating or creating an instance of MotorWS
     * @param content representation for the resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void inserirCliente(Cliente cliente) {
        clienteDao.inserir(cliente);
    }
    
    @PUT
    @Path("{codigo}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void editarCliente(@PathParam("codigo") int codigo, Cliente cliente) {
        cliente.setCodigo(codigo);
        clienteDao.atualizar(cliente);
    }
    
    @DELETE
    @Path("{codigo}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void removerCliente(@PathParam("codigo") int codigo, Cliente cliente) {
        //System.out.println("TESTE");        
        //this.codigo = codigo;
        clienteDao.deletar(cliente);
    }
    
}
