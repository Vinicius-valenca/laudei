package service;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.util.HibernateUtil;
import model.Pessoa;
public class RegisterService {
	
public boolean register(Pessoa user){
	 Session session = HibernateUtil.openSession();
	 
	
	 Transaction tx = null;	
	 try {
		 tx = session.beginTransaction(); 
		 session.saveOrUpdate(user);		
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



public boolean isUserExists(Pessoa user){
	 Session session = HibernateUtil.openSession();
	 boolean result = false;
	 Transaction tx = null;
	 try{
		 tx = session.beginTransaction(); 
		 Query query = session.createQuery("from Pessoa where id='"+user.getId()+"'");
		 Pessoa u = (Pessoa)query.uniqueResult();
		 tx.commit();
		 if(u!=null) result = true;
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
		 tx = session.beginTransaction(); 
		 Query query = session.createQuery("from Pessoa where Id='"+id+"'");
		 pessoa =  (Pessoa) session.load(Pessoa.class, new Long(id));
		 System.out.println("teste!????!" + pessoa);
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
		tx = session.beginTransaction(); 
		 Query query = session.createQuery("from Pessoa where Id='"+p.getId()+"'");
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
 }
