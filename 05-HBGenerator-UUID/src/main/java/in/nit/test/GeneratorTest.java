package in.nit.test;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.nit.model.BankTxDetail;
import in.nit.util.HibernateUtil;

public class GeneratorTest {

	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx = null;
		boolean flag = false;
		BankTxDetail txDetail = null;
		int idVal = 0;
		try {
		tx = ses.beginTransaction();
		txDetail = new BankTxDetail();
		txDetail.setTxName("Withdraw");
		txDetail.setTxAmount(5000);
		txDetail.setTxDate(new Date());
		idVal = (int)ses.save(txDetail);
		System.out.println("Generated id value: "+idVal);
		flag = true;
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
