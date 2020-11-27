package in.nit.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.nit.model.Product;
import in.nit.util.HibernateUtil;

public class DeleteLoadTest {

	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx = null;
		Product prod = null;
		prod = ses.load(Product.class, 1);
		System.out.println("After Loading");
		if(prod!=null) {
			try {
				tx = ses.beginTransaction();
				ses.delete(prod);

				tx.commit();
				System.out.println("OBJECT DELETED");
			}catch (Exception e) {
					tx.rollback();
					e.printStackTrace();
					System.out.println("OBJECT NOT FOUND");
			}
		}
		else {
			System.out.println("OBJECT NOT FOUND");
		}
		/*
		prod = ses.get(Product.class, 1);
		if(prod!=null) {
			ses.delete(prod);
			ses.flush();
			System.out.println("OBJECT DELETED");
		}
		else {
			System.out.println("OBJECT NOT FOUND");
		}
		System.out.println(prod.hashCode());
		System.out.println(prod.getPid()+" "+prod.getPname());*/

			ses.close();
		}
	}
