/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexao.Conexao;
import DTO.lojaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aluno
 */
public class lojaDAO {
    
    final String NOMEBANCO = "lojavirtual";

    final String NOMETABELA = "loja";
    
    
    public boolean existe(lojaDTO loja){

        try{

        Connection conn = Conexao.conectar(NOMEBANCO);

        String sql = "SELECT * FROM "+NOMETABELA+" WHERE PEDIDO = ?;";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1, loja.getPedido());

        ResultSet rs = ps.executeQuery();

        if (rs.next()){

            ps.close();

            rs.close();

            conn.close();

            return true;

           }

        } catch(Exception e){

            System.err.println("Erro: "+e.toString());

            e.printStackTrace();

            return false;

        }

        return false;

        }    
   
    public boolean inserir(lojaDTO loja){

    if (existe(loja) != true){

        try{

            Connection conn = Conexao.conectar(NOMEBANCO);

            String sql = "INSERT INTO "+NOMETABELA+" (PEDIDO, DATA, NOME, SOBRENOME, ENDERECO, SEXO, TELEFONE, EMAIL, ASSUNTO, COMENTARIO) VALUES (?,?,?,?,?,?,?,?,?,?);";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, loja.getPedido());
            
            ps.setString(2, loja.getData());

            ps.setString(3, loja.getNome());
            
            ps.setString(4, loja.getSobrenome());
            
            ps.setString(5, loja.getEndereco());
            
            ps.setString(6, loja.getSexo());
            
            ps.setString(7, loja.getTelefone());
            
            ps.setString(8, loja.getEmail());
            
            ps.setString(9, loja.getAssunto());
            
            ps.setString(10, loja.getComentario());
            
            

            

            ps.execute();

            ps.close();

            conn.close();

            return true;

        } catch(Exception e){

            System.err.println("Erro: "+e.toString());

            e.printStackTrace();

            return false;

            }

        }

        return false;

    }
    
    public List<lojaDTO> montarLista (ResultSet rs) {

        List<lojaDTO> listModel = new ArrayList<lojaDTO>();

        try{

            while (rs.next()) {

                lojaDTO registro = new lojaDTO();

                registro.setPedido(rs.getInt(1));

                registro.setNome(rs.getString(2));

                listModel.add(registro);

            }

            return listModel;

        }   catch (Exception e){

            System.err.println("Erro"+e.toString());

            e.printStackTrace();

            return null;

        }

    }
    
    
    
     public lojaDTO procurar (lojaDTO loja){

        try{

            Connection conn = Conexao.conectar(NOMEBANCO);

            String sql = "SELECT * FROM "+NOMETABELA+" WHERE PEDIDO = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, loja.getPedido());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                lojaDTO registro = new lojaDTO();

                registro.setPedido(rs.getInt(1));
                
                registro.setData(rs.getString(2));

                registro.setNome(rs.getString(3));
                
                registro.setSobrenome(rs.getString(4));
                
                registro.setEndereco(rs.getString(5));
                
                registro.setSexo((rs.getString(6)));
                
                registro.setTelefone(rs.getString(7));
                
                registro.setEmail(rs.getString(8));
                
                registro.setAssunto(rs.getString(9));
                
                registro.setComentario(rs.getString(10));

                

                ps.close();

                rs.close();

                conn.close();

                return registro;

                  } else{

                ps.close();

                rs.close();

                conn.close();

                return null;

             }                      

            } catch (Exception e){

                    System.err.println("Erro: "+e.toString());

                    e.printStackTrace();

                    return null;

                    }

    }
    
}
