/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package natan.r.cadastrousuario.controller;

import java.util.ArrayList;
import java.util.List;
import natan.r.cadastrousuario.model.dao.MarcaDao;
import natan.r.cadastrousuario.model.domain.Marca;

/**
 *
 * @author Natan
 */
public class MarcaController {
             private MarcaDao dao;
    private Marca marcaManipulado;
    private List<Marca> lista;
    public void pesquisar() {

      this.lista = this.dao.listar();
      
        
    }

    public MarcaController() {
        this.dao = new MarcaDao();
        this.marcaManipulado = null;
        this.lista = new ArrayList<Marca>();
    }
    
    public void novo() {
      this.marcaManipulado = new Marca();
    }
    public void excluir() {
      this.dao.excluir(this.marcaManipulado);
              
    }
    public void salvar() {
        this.dao.salvar(this.marcaManipulado);
         
        
    }   
    public void editar() {

    }  

    public Marca getMarcaManipulado() {
        return marcaManipulado;
    }

    public void setMarcaManipulado(Marca marcaManipulado) {
        this.marcaManipulado = marcaManipulado;
    }

    public List<Marca> getLista() {
        return lista;
    }

    public void setLista(List<Marca> lista) {
        this.lista = lista;
    }
    
}
    

        
   
    
    
    
  

    

