package com.ssi;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UserService {
	@Autowired
	SessionFactory factory;
	@Transactional
	public void saveUser(User user){
		Session session=factory.openSession();
		session.save(user);
		session.beginTransaction().commit();
	}
	public User getUser(int userId){
		Session session=factory.openSession();
		User user=session.get(User.class, userId);
		return user;
	}
	public List<User> getAllUsers(){
		Criteria cr=factory.openSession().createCriteria(User.class);
		List<User> users=cr.list();
		return users;
	}
}
