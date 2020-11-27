package in.nit.test;

import java.util.Arrays;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.nit.model.EmpDetails;
import in.nit.model.Student;
import in.nit.util.HibernateUtil;

public class test {

	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx = null;
		EmpDetails details = null;
		String idVal = null;
		details = new EmpDetails();
		details.setFname("Rajesh");
		details.setLname("Rao");
		details.setMail("rao@gmail.com");
		
		try {
		tx = ses.beginTransaction();
		idVal = (String)ses.save(details);
		System.out.println("Generated id value: "+idVal);
		
		tx.commit();
		}
		catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		
			ses.close();
	
	}

}
