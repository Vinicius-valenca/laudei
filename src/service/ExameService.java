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
	 //if(isExameExists(exame)) return false;	
	
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

public Exame isExameExists(Long id){
	 Session session = HibernateUtil.openSession();
	 Exame exame=null;
	 Transaction tx = null;
	 System.out.println("teste");
	 try{
		 tx = session.getTransaction();
		 tx.begin();
		 Query query = session.createQuery("from Exame where Id='"+id+"'");
		 exame =  (Exame) session.load(Exame.class, new Long(id));
		 System.out.println("teste222");
		 System.out.println(exame);
		 tx.commit();
	 }catch(Exception ex){
		 if(tx!=null){
			 tx.rollback();
		 }
	 }finally{
		 session.close();
	 }
	 return exame;
}



public boolean delete(Exame e){  
	Session session = HibernateUtil.openSession();
	boolean result = false;
	Transaction tx = null;
	try{
		 tx = session.getTransaction();
		 tx.begin();
		 Query query = session.createQuery("from Exame where id='"+e.getId()+"'");
		  session.delete(e);
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

public List<Exame> getListOfExameSemLaudo(){
    List<Exame> list = new ArrayList<Exame>();
    Session session = HibernateUtil.openSession();
    Transaction tx = null;        
    try {
        tx = session.getTransaction();
        tx.begin();
        list = session.createQuery("from Exame where laudo is NULL").list();                        
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

public List<Exame> getListOfExameComLaudo(){
    List<Exame> list = new ArrayList<Exame>();
    Session session = HibernateUtil.openSession();
    Transaction tx = null;        
    try {
        tx = session.getTransaction();
        tx.begin();
        list = session.createQuery("from Exame where laudo is NOT NULL").list();                        
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
