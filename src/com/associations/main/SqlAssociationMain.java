package com.associations.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.associations.models.UserDetails;
import com.associations.models.Vehicle;
import com.associations.utils.HibernateUtil;

public class SqlAssociationMain {

	public static void main(String[] args) {
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		UserDetails spock=new UserDetails();
		spock.setName("Spock");
		UserDetails kirk=new UserDetails();
		kirk.setName("kirk");
		Vehicle vehicle1=new Vehicle();
		vehicle1.setVehicleName("Enterprise");
		Vehicle vehicle2=new Vehicle();
		vehicle2.setVehicleName("kelvin");
		spock.setVehicle(vehicle1);
		kirk.setVehicle(vehicle2);
		session.save(vehicle2);
		session.save(vehicle1);
		session.save(spock);
		session.save(kirk);
		session.getTransaction().commit();
		session.close();
		
	}

}
