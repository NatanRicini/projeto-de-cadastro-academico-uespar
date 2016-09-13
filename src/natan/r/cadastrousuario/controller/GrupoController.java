/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package natan.r.cadastrousuario.controller;

import java.util.ArrayList;
import java.util.List;
import natan.r.cadastrousuario.model.dao.GrupoDao;
import natan.r.cadastrousuario.model.domain.Grupo;

/**
 *
 * @author Natan
 */
public class GrupoController {
             private GrupoDao dao;
    private Grupo grupoManipulado;
    private List<Grupo> lista;
    public void pesquisar() {

      this.lista = this.dao.listar();
      
        
    }

    public GrupoController() {
        this.dao = new GrupoDao();
        this.grupoManipulado = null;
        this.lista = new ArrayList<Grupo>();
    }
    
    public void novo() {
      this.grupoManipulado = new Grupo();
    }
    public void excluir() {
      this.dao.excluir(this.grupoManipulado);
              
    }
    public void salvar() {
        this.dao.salvar(this.grupoManipulado);
         
        
    }   
    public void editar() {

    }  

    public Grupo getGrupoManipulado() {
        return grupoManipulado;
    }

    public void setGrupoManipulado(Grupo grupoManipulado) {
        this.grupoManipulado = grupoManipulado;
    }

    public List<Grupo> getLista() {
        return lista;
    }

    public void setLista(List<Grupo> lista) {
        this.lista = lista;
    }
    
}
    

        
   
    
    
    
  

    

