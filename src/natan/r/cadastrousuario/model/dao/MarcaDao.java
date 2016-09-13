/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package natan.r.cadastrousuario.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import natan.r.cadastrousuario.model.domain.Marca;
import natan.r.cadastrousuario.services.Conexao;

/**
 *
 * @author Natan
 */
public class MarcaDao {

    private Connection conn;

    public MarcaDao() {
        try {
            this.conn = Conexao.getInstance();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public boolean salvar(Marca obj) {
        Integer codigo = obj.getCodigo();
        String nome = obj.getNome();
        

        StringBuilder sql = new StringBuilder();

        if (codigo == null) {
            /// insert  
            sql.append("insert into marca");
            sql.append(" (codigo, nome) ");
            sql.append(" values ( (  select coalesce(max(x.codigo), ? )+1 as ID from marca x) ,?)");

            try {
                PreparedStatement stm = this.conn.prepareStatement(sql.toString());
                stm.setString(2, nome);
                stm.setInt(1, 0);

                stm.execute();
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        } else {
            /// UPDATE
            sql.append("update marca set");

            sql.append(" nome = ?");
            sql.append(" where codigo = ?");
            try {
                PreparedStatement stm = this.conn.prepareStatement(sql.toString());
                stm.setString(1, nome);
                stm.setInt(2, codigo);

                stm.execute();
                return true;

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }

    public boolean excluir(Marca obj) {
        Integer codigo = obj.getCodigo();
        StringBuilder sql = new StringBuilder();
        sql.append("delete from marca where codigo = ?");
        try {
            PreparedStatement stm = this.conn.prepareStatement(sql.toString());
            stm.setInt(1, codigo);
            stm.execute();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Marca> listar() {
        List<Marca> lst = new ArrayList<Marca>();
        StringBuilder sql = new StringBuilder();
        sql.append("select * from marca");
        try {
            PreparedStatement stm = this.conn.prepareStatement(sql.toString());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Marca u = new Marca();
                u.setCodigo(rs.getInt("codigo"));
                u.setNome(rs.getString("nome"));

                lst.add(u);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return lst;

    }
}


