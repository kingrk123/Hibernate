package in.nit.test;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.nit.model.Student;
import in.nit.util.HibernateUtil;

public class test {

	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx = null;
		try {
		tx = ses.beginTransaction();
		Student s1=new Student(1,"AR", "ar@gm.com");
		Student s2=new Student(2,"BR", "br@gm.com");
		Student s3=new Student(3,"CR", "cr@gm.com");
		
		ses.save(s1);
		ses.save(s2);
		ses.save(s3);
		tx.commit();
		System.out.println("Saved");
		}catch (Exception e) {
			if(tx!=null && tx.getStatus().canRollback()) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		ses.close();
	}

}
