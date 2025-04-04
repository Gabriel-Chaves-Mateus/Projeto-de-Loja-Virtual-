/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;

import DAO.lojaDAO;
import DTO.lojaDTO;
import java.util.List;

/**
 *
 * @author aluno
 */
public class lojaBO {
     
    public boolean inserir (lojaDTO lojadto) {

    lojaDAO fichadao = new lojaDAO();

    fichadao.inserir(lojadto);

    return true;
    }
    
    
    public lojaDTO procurar (lojaDTO lojadto) {

    lojaDAO lojadao = new lojaDAO();

    lojadto = lojadao.procurar(lojadto);

    return lojadto;

    }     

    }

