/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import entidade.Usuario;
import entidade.dao.UsuarioDaoBd;
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
@Path("/usuarios")
public class UsuarioWS {

    @Context
    private UriInfo context;
    static List<Usuario> listaUsuarios = new ArrayList<>();

    
    private UsuarioDaoBd usuarioDao;
    private int codigo;
    /**
     * Creates a new instance of MotorWS
     */
    public UsuarioWS() {
        usuarioDao = new UsuarioDaoBd();
    }

    /**
     * Retrieves representation of an instance of ws.MotorWS
     * @return an instance of entidade.Motor
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> getUsuario() {
        //return listaClientes;
        //System.out.println("testeListar");
        return usuarioDao.listar();        
    }

    /**
     * PUT method for updating or creating an instance of MotorWS
     * @param content representation for the resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void inserirUsuario(Usuario usuario) {
        usuarioDao.inserir(usuario);
    }
    
    @PUT
    @Path("/{codigo}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void editarUsuario(@PathParam("codigo") int codigo, Usuario usuario) {
        usuario.setCodigo(codigo);
        usuarioDao.atualizar(codigo,usuario);
    }
    
    @DELETE
    @Path("/{codigo}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void removerUsuario(@PathParam("codigo") int codigo) { 
        usuarioDao.deletar(codigo);
    }
    
    @GET
    @Path("/{codigo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario buscarPorCodigo(@PathParam("codigo") int codigo) {
        return usuarioDao.buscarPorId(codigo);
    }
    
}
