/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 630610194
 */
@XmlRootElement
public class Produto implements Serializable {
    private int codigo;
    private String nome, preco, quantidade, fabricante, website, telfabricante, nomevendedor, telvendedor;

    public Produto() {
    }

    public Produto(int codigo, String nome, String preco, String quantidade, String fabricante, String website, String telfabricante, String nomevendedor, String telvendedor) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.fabricante = fabricante;
        this.website = website;
        this.telfabricante = telfabricante;
        this.nomevendedor = nomevendedor;
        this.telvendedor = telvendedor;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getTelfabricante() {
        return telfabricante;
    }

    public void setTelfabricante(String telfabricante) {
        this.telfabricante = telfabricante;
    }

    public String getNomevendedor() {
        return nomevendedor;
    }

    public void setNomevendedor(String nomevendedor) {
        this.nomevendedor = nomevendedor;
    }

    public String getTelvendedor() {
        return telvendedor;
    }

    public void setTelvendedor(String telvendedor) {
        this.telvendedor = telvendedor;
    }



   

   
}
