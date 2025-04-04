/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loja;

import Conexao.Conexao;
import java.sql.Connection;
import GUI.Loja;
import java.sql.DriverManager;

/**
 *
 * @author aluno
 */
public class loja {
    
    public static void main(String[] args) {
        // TODO code application logic here
        Connection conn = Conexao.conectar("lojavirtual");
        
        Loja tela = new Loja();
        tela.show();
    }
}

