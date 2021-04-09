package service;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.util.HibernateUtil;
import model.Exame;
import model.Pessoa;
public class ExameService {
	
public boolean register(Exame exame){
	 Session session = HibernateUtil.openSession();
	 if(isExameExists(exame)) return false;	
	
	 Transaction tx = null;	
	 try {
		 tx = session.getTransaction();
		 tx.begin();
		 session.saveOrUpdate(exame);		
		 tx.commit();
	 } catch (Exception e) {
		 if (tx != null) {
			 tx.rollback();
		 }
		 e.printStackTrace();
	 } finally {
		 session.close();
	 }	
	 return true;
}

public boolean register(Pessoa pessoa){
	 Session session = HibernateUtil.openSession();
	 
	 Transaction tx = null;	
	 try {
		 tx = session.getTransaction();
		 tx.begin();
		 session.saveOrUpdate(pessoa);
		 tx.commit();
	 } catch (Exception e) {
		 if (tx != null) {
			 tx.rollback();
		 }
		 e.printStackTrace();
		 return false;
	 } finally {
		 session.close();
	 }	
	 return true;
}

public boolean isExameExists(Exame exame){
	 Session session = HibernateUtil.openSession();
	 boolean result = false;
	 Transaction tx = null;
	 try{
		 tx = session.getTransaction();
		 tx.begin();
		 Query query = session.createQuery("from Exame where Id='"+exame.getId()+"'");
		 Exame e = (Exame)query.uniqueResult();
		 tx.commit();
		 if(e!=null) result = true;
	 }catch(Exception ex){
		 if(tx!=null){
			 tx.rollback();
		 }
	 }finally{
		 session.close();
	 }
	 return result;
}

public Pessoa isUserExists(Long id){
	 Session session = HibernateUtil.openSession();
	 Pessoa pessoa=null;
	 Transaction tx = null;
	 try{
		 tx = session.getTransaction();
		 tx.begin();
		 Query query = session.createQuery("from User where Id='"+id+"'");
		 pessoa =  (Pessoa) session.load(Pessoa.class, new Long(id));
		 
		 tx.commit();
	 }catch(Exception ex){
		 if(tx!=null){
			 tx.rollback();
		 }
	 }finally{
		 session.close();
	 }
	 return pessoa;
}

public boolean delete(Pessoa p){  
	Session session = HibernateUtil.openSession();
	boolean result = false;
	Transaction tx = null;
	try{
		 tx = session.getTransaction();
		 tx.begin();
		 Query query = session.createQuery("from User where Id='"+p.getId()+"'");
		  session.delete(p);
		 result=true;
		 tx.commit();
	 }catch(Exception ex){
		 if(tx!=null){
			 tx.rollback();
		 }
	 }finally{
		 session.close();
	 }
	 return result;
}


public List<Exame> getListOfExame(){
    List<Exame> list = new ArrayList<Exame>();
    Session session = HibernateUtil.openSession();
    Transaction tx = null;        
    try {
        tx = session.getTransaction();
        tx.begin();
        list = session.createQuery("from Exame").list();                        
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
