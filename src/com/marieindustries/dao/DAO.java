package com.marieindustries.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.marieindustries.beans.*;


public class DAO {
	SessionFactory s = new Configuration()
			.configure("com/marieindustries/config/hibernate.cfg.xml")
			.buildSessionFactory();
	
	public void addBook(Book book) {
		//Open a new session and begin a transaction.
		Session session = s.openSession();
		session.beginTransaction();

		session.save(book);
		
		//Commit the transaction and close the session.
		session.getTransaction().commit();
		session.close();
	}
	
	public void addLivre(Livre book) {
		//Open a new session and begin a transaction.
		Session session = s.openSession();
		session.beginTransaction();

		session.save(book);
		
		//Commit the transaction and close the session.
		session.getTransaction().commit();
		session.close();
	}
	
	public List<Book> queryByBookCategory(String category) {
		Session session = s.openSession();
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Book.class);
		criteria.add(Restrictions.eq("genre", category));
		List<Book> books = (List<Book>)criteria.list();
		
		session.getTransaction().commit();
		session.close();
		
		return books;
	}
	
	public List<Livre> getLivres(){
		Session session = s.openSession();
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Livre.class);
		List<Livre> livres = (List<Livre>)criteria.list();
				
		session.getTransaction().commit();
		session.close();
		
		return livres;
	}
	
	public List<Livre> queryByCategory(String category) {
		Session session = s.openSession();
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Livre.class);
		criteria.add(Restrictions.eq("genre", category));
		List<Livre> books = (List<Livre>)criteria.list();
		
		session.getTransaction().commit();
		session.close();
		
		return books;
	}
	
	public User findByUserName(String username) {
		List<User> users = s.openSession()
			.createQuery("from User where username=:user")
			.setParameter("user", username)
			.list();

		if (users.size() > 0) return users.get(0);
		else return null;
	}

	public void createUser(User user) {
		Session session = s.openSession();
		session.beginTransaction();

		session.save(user);

		session.getTransaction().commit();
		session.close();
	}
	public void deleteLivre(int id){
		Session session = s.openSession();
		session.beginTransaction();
		
		Livre livre = new Livre();
		livre.setId(id);  //we can make a half-formed object and...
		session.delete(livre);  //... delete it from the table b/c it's the PK
				
		session.getTransaction().commit();
		session.close();
	}
	
	public Livre getLivre(int id){
		Session session = s.openSession();
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Livre.class);
		criteria.add(Restrictions.eqOrIsNull("id", id));
		List<Livre> livres = (List<Livre>)criteria.list();
		
		session.getTransaction().commit();
		session.close();
		if(livres.size() ==0){
			return null;
		}
		return livres.get(0);

	}

	

}
