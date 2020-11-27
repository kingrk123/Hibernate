package in.nit.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.nit.model.Product;
import in.nit.util.HibernateUtil;

public class SaveOrUpdateTest {

	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx = null;
		Product prod = null;
		prod = new Product();
		prod.setPid(11);
		prod.setPname("Chair1");
		prod.setPrice(7854);
		prod.setQty(11);
		try {
			tx = ses.beginTransaction();
			ses.saveOrUpdate(prod);
			tx.commit();
			System.out.println("OBJECT IS INSERTED/UPDATED");
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			System.out.println("OBJECT IS NOT INSERTED/UPDATED");
			
		}
		ses.close();
	}

}
