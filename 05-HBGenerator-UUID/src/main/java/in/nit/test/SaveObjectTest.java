package in.nit.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.nit.model.Student;
import in.nit.util.HibernateUtil;

public class SaveObjectTest {

	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx = null;
		Student st = null;
		st = new Student(908, "Rajesh", "r@gmail.com");
		try {
			tx = ses.beginTransaction();
			int idVal = (int)ses.save(st);
			System.out.println("Id Value::" + idVal);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
		ses.close();
	}

}
