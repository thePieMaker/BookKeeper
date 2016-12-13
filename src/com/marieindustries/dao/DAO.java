package com.marieindustries.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.marieindustries.beans.Book;
import com.marieindustries.beans.User;

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
	
	public List<Book> queryByCategory(String category) {
		Session session = s.openSession();
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Book.class);
		criteria.add(Restrictions.eq("genre", category));
		List<Book> books = (List<Book>)criteria.list();
		
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



	

}
