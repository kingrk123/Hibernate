package in.nit.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.nit.model.Student;
import in.nit.util.HibernateUtil;
import javassist.tools.rmi.ObjectNotFoundException;

public class LoadOperation {

	public static void main(String[] args) throws ObjectNotFoundException {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx = null;
		Student std = null;
		tx = ses.beginTransaction();
		std = ses.load(Student.class, 2);
		System.out.println(
				std.getStdId()+" "+std.getStdName()+" "
				+std.getEmail());
		
		ses.close();
	}
}
