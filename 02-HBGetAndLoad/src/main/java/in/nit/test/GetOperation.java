package in.nit.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.nit.model.Student;
import in.nit.util.HibernateUtil;

public class GetOperation {

	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx = null;
		Student std = null;
		try {
			tx = ses.beginTransaction();
			std = ses.get(Student.class, 4);
			if (std!=null) {
				System.out.println(
						std.getStdId()+" "+std.getStdName()+" "
						+std.getEmail());
			}else {
				System.out.println("Object Not Found");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		ses.close();
	}

}
