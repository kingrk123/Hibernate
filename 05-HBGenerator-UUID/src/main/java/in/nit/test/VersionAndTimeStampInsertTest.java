package in.nit.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.nit.model.BankAccount;
import in.nit.util.HibernateUtil;

public class VersionAndTimeStampInsertTest {

	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx = null;
		boolean flag = false;
		BankAccount account = null;
		long idVal=0;

		try {
		tx = ses.beginTransaction();
		account = new BankAccount();
		account.setHolderName("Kelly");
		account.setType("Non-Performing");
		account.setBalance(9990000);
		idVal = (long)ses.save(account);
		System.out.println("Generated id value: "+idVal);
		flag =true;
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
