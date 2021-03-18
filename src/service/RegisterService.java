package service;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.util.HibernateUtil;
import model.Pessoa;
import model.User;
public class RegisterService {
	
public boolean register(User user){
	 Session session = HibernateUtil.openSession();
	 if(isUserExists(user)) return false;	
	
	 Transaction tx = null;	
	 try {
		 tx = session.getTransaction();
		 tx.begin();
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

public boolean isUserExists(User user){
	 Session session = HibernateUtil.openSession();
	 boolean result = false;
	 Transaction tx = null;
	 try{
		 tx = session.getTransaction();
		 tx.begin();
		 Query query = session.createQuery("from User where userId='"+user.getUserId()+"'");
		 User u = (User)query.uniqueResult();
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
 }
