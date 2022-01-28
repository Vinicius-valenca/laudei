package service;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.util.HibernateUtil;
import model.Paciente;
import model.Pessoa;

public class LoginService {

    public boolean authenticateUser(String email, String password) {
        Pessoa pessoa = getPessoaByEmail(email);          
        if(pessoa!=null && pessoa.getEmail().equals(email) && pessoa.getPassword().equals(password)){
            return true;
        }else{ 
            return false;
        }
    }

    public Pessoa getPessoaByEmail(String email) {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        Pessoa pessoa = null;
        try {
       	
        	tx = session.getTransaction();
            tx.begin();
            Query query = session.createQuery("from Pessoa where email='"+email+"'");
            pessoa = (Pessoa)query.uniqueResult();
           
        } catch (Exception e) {
           
            e.printStackTrace();
        } finally {
            session.close();
        }
        return pessoa;
    }
    
    public List<Pessoa> getListOfPessoa(){
        List<Pessoa> list = new ArrayList<Pessoa>();
        Session session = HibernateUtil.openSession();
        Transaction tx = null;        
        try {
            tx = session.getTransaction();
            tx.begin();
            list = session.createQuery("from Pessoa").list();                        
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }
    
    public List<Paciente> getListOfPaciente(){
        List<Paciente> list = new ArrayList<Paciente>();
        Session session = HibernateUtil.openSession();
        Transaction tx = null;        
        try {
            tx = session.getTransaction();
            tx.begin();
            list = session.createQuery("from Paciente").list();                        
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }
}
