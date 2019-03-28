package com.evry.dao;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.evry.dto.User;

public class UserDAO {
	
	private static SessionFactory sf=new Configuration().configure().buildSessionFactory();
	
	public boolean addUser(User dto) {
		
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(dto);
		session.getTransaction().commit();
		session.close();
		
		if(dto.equals(dto)) {
			return true;
		}
		return false;
	}
	
	public long login(User dto) {
		
		Session session = sf.openSession();
		String qry ="select count(*) from User where uUserName=:uUserName and uPassword=:uPassword";
		
		 Query query = session.createQuery(qry);
		query.setParameter("uUserName", dto.getuUserName());
		query.setParameter("uPassword", dto.getuPassword());
		
		long result =  (Long) query.getSingleResult();
		return result;
	}
	
	public User addMoney(int id,double bal) {
		Session session = sf.openSession();
		User user = session.get(User.class, id);
		user.setBalance(user.getBalance()+bal);
		session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();
		System.out.println("Amount added.");
		
		
		// session.get(UserDTO.class, id);
		
		return user;
		
		
	}
	
	public double getBalance(User dto)
	{
		
		Session session = sf.openSession();
		User dt = session.get(User.class, dto.getUid());
		double balance = dt.getBalance();
		return balance;
	}
	
	public User transferMoney(int id1,int id2,double amt) {
		Session session=sf.openSession();
		session.beginTransaction();
		
		
		
		
		User acuid = session.get(User.class,id1);
		User beneficiary=session.get(User.class,id2);
		acuid.setBalance(acuid.getBalance()-amt);
		beneficiary.setBalance(beneficiary.getBalance()+amt);
		session.update(acuid);
		session.update(beneficiary);
		acuid=session.get(User.class,id1);
		session.getTransaction().commit();
		System.out.println("Done with trnasaction");
		
//		session.close();
		return acuid;
	}

}
