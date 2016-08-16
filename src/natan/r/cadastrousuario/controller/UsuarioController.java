/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package natan.r.cadastrousuario.controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import natan.r.cadastrousuario.model.dao.UsuarioDao;
import natan.r.cadastrousuario.model.domain.Usuario;

/**
 *
 * @author Natan
 */
public class UsuarioController {
    private UsuarioDao dao;
    private Usuario usuarioManipulado;
    private List<Usuario> lista;
    public void pesquisar() {
      dao.listar();
      this.lista = dao.listar();
      
        
    }

    public UsuarioController() {
        this.dao = new UsuarioDao();
        this.usuarioManipulado = null;
        this.lista = new ArrayList<Usuario>();
    }
    
    public void novo() {
      this.usuarioManipulado = new Usuario();
    }
    public void excluir() {
      this.dao.excluir(this.usuarioManipulado);
              
    }
    public void salvar() {
        this.dao.salvar(this.usuarioManipulado);
         
        
    }   
    public void editar() {

    }  

    public Usuario getUsuarioManipulado() {
        return usuarioManipulado;
    }

    public void setUsuarioManipulado(Usuario usuarioManipulado) {
        this.usuarioManipulado = usuarioManipulado;
    }

    public List<Usuario> getLista() {
        return lista;
    }

    public void setLista(List<Usuario> lista) {
        this.lista = lista;
    }
    
}
   


