package service;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.util.HibernateUtil;
import model.Exame;
import model.Paciente;
import model.Solicitante;
public class SolicitanteService {
	
public boolean register(Solicitante solicitante){
	 Session session = HibernateUtil.openSession();
	 //if(isExameExists(exame)) return false;	
	
	 Transaction tx = null;	
	 try {
		 tx = session.getTransaction();
		 tx.begin();
		 session.saveOrUpdate(solicitante);		
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




public Solicitante isSolicitanteExists(Long id){
	 Session session = HibernateUtil.openSession();
	 Solicitante solicitante=null;
	 Transaction tx = null;
	 System.out.println("teste");
	 try{
		 tx = session.getTransaction();
		 tx.begin();
		 Query query = session.createQuery("from Solicitante where id='"+id+"'");
		 solicitante =  (Solicitante)query.uniqueResult();
		 tx.commit();
	 }catch(Exception ex){
		 if(tx!=null){
			 tx.rollback();
		 }
	 }finally{
		 session.close();
	 }
	 return solicitante;
}



public boolean delete(Paciente p){  
	Session session = HibernateUtil.openSession();
	boolean result = false;
	Transaction tx = null;
	try{
		 tx = session.getTransaction();
		 tx.begin();
		 Query query = session.createQuery("from Solicitante where id='"+p.getId()+"'");
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


public List<Solicitante> getListOfSolicitantes(){
    List<Solicitante> list = new ArrayList<Solicitante>();
    Session session = HibernateUtil.openSession();
    Transaction tx = null;        
    try {
        tx = session.getTransaction();
        tx.begin();
        list = session.createQuery("from Solicitante").list();                        
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
