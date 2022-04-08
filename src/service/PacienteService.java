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
public class PacienteService {
	
public boolean register(Paciente paciente){
	 Session session = HibernateUtil.openSession();
	 //if(isExameExists(exame)) return false;	
	
	 Transaction tx = null;	
	 try {
		 tx = session.getTransaction();
		 tx.begin();
		 session.saveOrUpdate(paciente);		
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


public boolean isPacienteExists(Paciente paciente){
	 Session session = HibernateUtil.openSession();
	 boolean result = false;
	 Transaction tx = null;
	 try{
		 tx = session.getTransaction();
		 tx.begin();
		 Query query = session.createQuery("from Paciente where Id='"+paciente.getId()+"'");
		 Paciente p = (Paciente)query.uniqueResult();
		 tx.commit();
		 if(p!=null) result = true;
	 }catch(Exception ex){
		 if(tx!=null){
			 tx.rollback();
		 }
	 }finally{
		 session.close();
	 }
	 return result;
}

public Paciente isPacienteExists(Long id){
	 Session session = HibernateUtil.openSession();
	 Paciente paciente=null;
	 Transaction tx = null;
	 System.out.println("teste");
	 try{
		 tx = session.getTransaction();
		 tx.begin();
		 Query query = session.createQuery("from Paciente where id='"+id+"'");
		 paciente =  (Paciente)query.uniqueResult();
		 tx.commit();
	 }catch(Exception ex){
		 if(tx!=null){
			 tx.rollback();
		 }
	 }finally{
		 session.close();
	 }
	 return paciente;
}

public Paciente isPacienteExistsUUID(String uuid){
	 Session session = HibernateUtil.openSession();
	 Paciente paciente=null;
	 Transaction tx = null;
	 
	 try{
		 tx = session.getTransaction();
		 tx.begin();
		 Query query = session.createQuery("from Paciente where code='"+uuid+"'");
		 paciente = (Paciente)query.uniqueResult();
		 
		 tx.commit();
	 }catch(Exception ex){
		 if(tx!=null){
			 tx.rollback();
		 }
	 }finally{
		 session.close();
	 }
	 return paciente;
}

public boolean delete(Paciente p){  
	Session session = HibernateUtil.openSession();
	boolean result = false;
	Transaction tx = null;
	try{
		 tx = session.getTransaction();
		 tx.begin();
		 Query query = session.createQuery("from Paciente where id='"+p.getId()+"'");
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
