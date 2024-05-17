/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.mfsdevsystem.onetoone_unidirecional;
/**
 *
 * @author Marcelino
 */

import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class GravaPessoa {
   
     private static final Logger logger = LoggerFactory.getLogger(GravaPessoa.class);
   
     public static void main(String[] args) {
        
        try
        { 
             Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
             SessionFactory fabrica = configuration.buildSessionFactory();
             Session sessao = fabrica.openSession();
             
             Pessoa pessoa = new Pessoa();
             Endereco endereco = new Endereco();
             
             pessoa.setId(1);
             pessoa.setNome("Marcelino Feliciano de Sousa");
             
             endereco.setId(pessoa.getId());
             endereco.setLogradouro("Rua duzentos e hum");
             //pessoa.setEndereco(endereco);
             
            // Gravar o registro pessoa
             Transaction transaction = sessao.beginTransaction();
             sessao.save(pessoa);
             sessao.save(endereco);
             
             transaction.commit();
             sessao.close();

             
         } catch (Exception e) {
             logger.error("Erro na inserção de dado no banco de dados: "+e);
             JOptionPane.showMessageDialog(null,"Erro inserção de dados no banco de dados : "+e);
         } 
         
    }
    
}

