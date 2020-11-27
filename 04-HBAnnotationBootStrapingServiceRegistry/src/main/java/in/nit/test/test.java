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
		int idVal = 0;
		boolean flag = false;
		try {
		tx = ses.beginTransaction();
		details = new EmpDetails(100, "Rajesh", "Rao", "rao@gmail.com");
		idVal = (int)ses.save(details);
		System.out.println("Generated id value: "+idVal);
		flag= true;
		
		}catch (HibernateException he) {
			he.printStackTrace();
			flag = false;
		}
		catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		finally {
			if (flag == true) {
				tx.commit();
				System.out.println("Object Saved");
			} else {
				tx.rollback();
				System.out.println("Object not Saved");
			}
			ses.close();
		}
		
	}

}
