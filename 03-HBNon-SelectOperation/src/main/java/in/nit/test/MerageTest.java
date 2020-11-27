package in.nit.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.nit.model.Product;
import in.nit.util.HibernateUtil;

public class MerageTest {

	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx = null;
		Product prod = null, prod1;
		prod = new Product();
		prod.setPid(21);
		prod.setPname("Plastic Chair 1");
		prod.setPrice(7894);
		prod.setQty(201);
		
		try {
			tx = ses.beginTransaction();
			prod1 = (Product)ses.merge(prod);
			System.out.println("Prod1-->"+
					prod1.getPid()+" "+prod1.getPname()
					+" "+prod1.getQty()+" "+
					prod1.getPrice());
			tx.commit();
			System.out.println("OBJECT IS INSERTED/UPDATED");
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			System.out.println("OBJECT NOT FOUND");
		}
		ses.close();
	}

}
