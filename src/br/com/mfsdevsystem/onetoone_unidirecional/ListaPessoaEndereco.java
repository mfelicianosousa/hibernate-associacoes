/**
 *
 * @author Marcelino
 */
package br.com.mfsdevsystem.onetoone_unidirecional;

import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ListaPessoaEndereco {
    
    private static final Logger logger = LoggerFactory.getLogger(ListaPessoaEndereco.class);
   
     public static void main(String[] args) {
        
        try
        { 
             Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
             SessionFactory fabrica = configuration.buildSessionFactory();
             Session sessao = fabrica.openSession();
             
             Pessoa pessoa = (Pessoa) sessao.get(Pessoa.class, 1);
             String dados = "Dados Pessoa :\n\n";
             dados = dados + "Id: "+ pessoa.getId()+"\n Nome: "+pessoa.getNome();
             dados = dados+"\n\nDados Endereço :\n\n"+pessoa.getEndereco().getLogradouro();
             
             /*
             Endereco endereco = (Endereco) sessao.get(Endereco.class, 1);
             dados = dados+"\n\nDados Endereço :\n\n";
             dados = dados + "Id: "+ endereco.getId()+"\nLogradouro: "+endereco.getLogradouro();
            */
             
             System.out.println(dados);
             JOptionPane.showMessageDialog(null,dados);
           
             sessao.close();
             
             
  
             
         } catch (Exception e) {
             logger.error("Erro na inserção de dado no banco de dados: "+e);
             JOptionPane.showMessageDialog(null,"Erro inserção de dados no banco de dados : "+e);
         } 
         
    }
}
