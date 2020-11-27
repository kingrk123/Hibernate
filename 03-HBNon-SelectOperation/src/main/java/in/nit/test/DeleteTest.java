package in.nit.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.nit.model.Product;
import in.nit.util.HibernateUtil;

public class DeleteTest {

	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx = null;
		Product prod = null;
		prod = new Product();
		prod.setPid(2);
		try {
		tx = ses.beginTransaction();
		ses.delete(prod);
		
		tx.commit();
		System.out.println("OBJECT DELETED");
		}catch (Exception e) {
			if(tx!=null && tx.getStatus().canRollback()) {
				tx.rollback();
				System.out.println("OBJECT NOT FOUND");
			}
			e.printStackTrace();
		}
		ses.close();
	}
}
