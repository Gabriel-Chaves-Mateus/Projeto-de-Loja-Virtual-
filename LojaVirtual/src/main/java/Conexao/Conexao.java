/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author aluno
 */
public class Conexao {
    
    public static Connection conectar(String nomeBanco){
        try{
        String db_url = "jdbc:mysql://localhost/"+nomeBanco;
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(db_url,"root","");
        System.out.println("Banco de Dados Conectado!!");
        return con;
    } catch(Exception e){
        System.out.println("Erro ao conectar o Banco de Dados:"+e);
        return null;
     }
  }
    
}
